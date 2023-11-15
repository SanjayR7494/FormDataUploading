package com.example.demo_file_upload.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo_file_upload.customexception.EmailNotFoundException;
import com.example.demo_file_upload.customexception.NotUploadedFilesException;
import com.example.demo_file_upload.customexception.NotValidFile;
import com.example.demo_file_upload.entity.UserDetails;

public interface UserDataService {

	Map<String,String> upload(UserDetails details,List<MultipartFile> files) throws IOException, NotValidFile, NotUploadedFilesException;
	
	List<String> download();
	
	List<UserDetails> read(String email) throws EmailNotFoundException;

}
