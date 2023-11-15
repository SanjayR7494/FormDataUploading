package com.example.demo_file_upload.controller;

import java.io.IOException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo_file_upload.customexception.EmailNotFoundException;
import com.example.demo_file_upload.customexception.NotUploadedFilesException;
import com.example.demo_file_upload.customexception.NotValidFile;
import com.example.demo_file_upload.entity.UserDetails;
import com.example.demo_file_upload.service.UserDataService;

@RestController
@RequestMapping("api/formdata")
public class UserDetailsController {

	@Autowired
	private UserDataService userdataservice;

	@RequestMapping(method = RequestMethod.POST, value = "upload")
	public Map<String,String> upload(@ModelAttribute UserDetails details, List<MultipartFile> file)
			throws IOException, NotValidFile, NotUploadedFilesException {
		return userdataservice.upload(details, file);
	}

	@RequestMapping(method = RequestMethod.GET, value = "download")
	public List<String> download() {
		return userdataservice.download();

	}

	@RequestMapping(method = RequestMethod.GET, value = "read")
	public List<UserDetails> read(String email) throws EmailNotFoundException {
		return userdataservice.read(email);
	}
}
