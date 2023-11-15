package com.example.demo_file_upload.service;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo_file_upload.customexception.EmailNotFoundException;
import com.example.demo_file_upload.customexception.NotUploadedFilesException;
import com.example.demo_file_upload.customexception.NotValidFile;
import com.example.demo_file_upload.entity.UserDetails;
import com.example.demo_file_upload.entity.UsersFilesDetails;
import com.example.demo_file_upload.repository.UserDataUpload;
import com.example.demo_file_upload.repository.UserFileDataUpload;

/*
 * This class used to perform
 * upload and download operations
 */
@Service
public class UserDataServiceImplement implements UserDataService {

	@Autowired
	private UserDataUpload userdataupload;

	@Autowired
	private UserFileDataUpload filedataupload;

	@Value("${spring.file.path}")
	public String path;

	private static final Logger logger = LoggerFactory.getLogger(UserDataServiceImplement.class);

	/*
	 * upload method returns map key-filename value-UserDetails object for correct
	 * files returns key-filename value-error message for incorrect files
	 */
	public Map<String, String> upload(UserDetails details, List<MultipartFile> files)
			throws IOException, NotValidFile, NotUploadedFilesException {
		UserDetails userdetail = new UserDetails();
		userdataupload.save(userdetail);
		Map<String, String> testmap = new HashMap<>();
		for (MultipartFile file : files) {
			if (file.isEmpty()) {
				testmap.put("Error", "File field is empty");
				logger.info("empty file");
				continue;
			}
			Tika t = new Tika();
			String extension = t.detect(file.getInputStream());
			if (!(extension.equals("image/jpeg") || extension.equals("image/avif"))) {
				testmap.put(file.getOriginalFilename(), extension + " error");
				logger.warn("extension error");
				continue;
			}
			UsersFilesDetails filedetails = new UsersFilesDetails();
			userdetail.setEmail(details.getEmail());
			userdetail.setName(details.getName());
			String uniquefilename = UUID.randomUUID() + file.getOriginalFilename();
			file.transferTo(new File(path + uniquefilename));
			filedetails.setDisplayname(file.getOriginalFilename());
			filedetails.setFilename(path + uniquefilename);
			filedetails.setUserid(userdetail);
			testmap.put(file.getOriginalFilename(), userdetail.toString());
			filedataupload.save(filedetails);
		}
		return testmap;
	}

	/*
	 * returns all filenames
	 */
	public List<String> download() {
		List<String> filenames = userdataupload.findAllFiles();
		return filenames;
	}

	/*
	 * read method will return list of file details of a particular user Input
	 * parameter is email If email not found throws exception
	 */
	public List<UserDetails> read(String email) throws EmailNotFoundException {
		List<UserDetails> data = userdataupload.findByEmailId(email);
		if (data.isEmpty()) {
			throw new EmailNotFoundException("Hey Email is not found");
		}
		return data;
	}

}
