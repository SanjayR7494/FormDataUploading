package com.example.demo_file_upload.customexception;

import java.util.List;
import java.util.Map;

public class NotUploadedFilesException extends Exception {
	 
	private Map<String,String>testmap;

	/**
	 * @return the testmap
	 */
	public Map<String, String> getTestmap() {
		return testmap;
	}

	/**
	 * @param testmap the testmap to set
	 */
	public void setTestmap(Map<String, String> testmap) {
		this.testmap = testmap;
	}

	public NotUploadedFilesException(Map<String, String> testmap) {
		this.testmap = testmap;
	}

	/**
	 * @param testmap the testmap to set
	 */
	
	

}
