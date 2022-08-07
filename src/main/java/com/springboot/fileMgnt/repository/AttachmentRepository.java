package com.springboot.fileMgnt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.fileMgnt.entity.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String> {

}
