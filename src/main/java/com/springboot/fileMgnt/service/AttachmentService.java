package com.springboot.fileMgnt.service;

import org.springframework.web.multipart.MultipartFile;

import com.springboot.fileMgnt.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file) throws Exception;

	Attachment getAttachment(String fileId) throws Exception;

}
