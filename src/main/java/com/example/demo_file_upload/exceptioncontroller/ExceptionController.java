package com.example.demo_file_upload.exceptioncontroller;

import java.util.List;
import java.util.Map;
import java.lang.String;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.example.demo_file_upload.customexception.EmailNotFoundException;
import com.example.demo_file_upload.customexception.NotUploadedFilesException;
import com.example.demo_file_upload.customexception.NotValidFile;

@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(NotValidFile.class)
	public String NotValidFileExtension(NotValidFile e) {
		return e.getMessage();
	}

	@ExceptionHandler(EmailNotFoundException.class)
	public String EmailNotFound(EmailNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public String NotAllowedFileSize(MaxUploadSizeExceededException e) {
		return e.getMessage();
	}

	@ExceptionHandler(NotUploadedFilesException.class)
	public Map<String,String> notUploadedFiles(NotUploadedFilesException ex) {
		return ex.getTestmap();
	}
}
