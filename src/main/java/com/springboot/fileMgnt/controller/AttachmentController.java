package com.springboot.fileMgnt.controller;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.fileMgnt.entity.Attachment;
import com.springboot.fileMgnt.model.ResponseData;
import com.springboot.fileMgnt.service.AttachmentService;

@RestController
public class AttachmentController {
	
	private AttachmentService attachmentService;

	public AttachmentController(AttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	
	@PostMapping("/upload")
	public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
			Attachment attachment=null;
			String downloadURL="";
		
				attachment=attachmentService.saveAttachment(file);
				downloadURL=ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/download/")
							.path(attachment.getId())
							.toUriString();
				
			return new ResponseData(attachment.getFilename(),
					downloadURL,
					file.getContentType(),
					file.getSize());
			
	}
	
	@GetMapping("/download/{fileId}")
	 public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception{
		 Attachment attachment=null;
		 attachment=attachmentService.getAttachment(fileId);
		 
		 return ResponseEntity.ok()
				 .contentType(MediaType.parseMediaType(attachment.getFiletype()))
				 .header(HttpHeaders.CONTENT_DISPOSITION, 
						 "attachmet; filename=\""+attachment.getFilename()
						 +"\"")
				 .body(new ByteArrayResource(attachment.getData()));
	 }

}
