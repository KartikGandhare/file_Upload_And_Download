package com.file.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.file.entity.Attachment;

 
public interface AttachmentRepository extends JpaRepository<Attachment, String>{

}
