package com.springboot.fileMgnt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Attachment {
	
	
	
	public Attachment() {
		
	}

	public String getId() {
		return id;
	}

	public String getFilename() {
		return filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid", strategy = "uuid2")
	private String id;
	private String filename;
	private String filetype;
	
	@Lob
	private byte[] data;

	public Attachment(String filename, String filetype, byte[] data) {
		super();
		this.filename = filename;
		this.filetype = filetype;
		this.data = data;
	}
	
	
}
