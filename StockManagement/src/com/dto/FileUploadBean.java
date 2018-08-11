package com.dto;

public class FileUploadBean {

	private Long length;
	private byte[] bytes;
	private String contentType;
	private String name;
	
	
	public Long getLength() {
		return length;
	}
	public void setLength(Long length) {
		this.length = length;
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
