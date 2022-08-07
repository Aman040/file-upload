package com.springboot.fileMgnt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData {
	
	private String filename;
	private String downloadURL;
	private String fileType;
	private long fileSize;
	
	
	public ResponseData() {
		
	}


	public ResponseData(String filename, String downloadURL, String fileType, long fileSize) {
		
		this.filename = filename;
		this.downloadURL = downloadURL;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}


	public String getFilename() {
		return filename;
	}


	public String getDownloadURL() {
		return downloadURL;
	}


	public String getFileType() {
		return fileType;
	}


	public long getFileSize() {
		return fileSize;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}


	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	
	

}
