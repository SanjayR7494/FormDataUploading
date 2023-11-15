package com.example.demo_file_upload.customexception;

public class EmailNotFoundException extends Exception{

	public EmailNotFoundException (String message) {
		super(message);
	}
}
