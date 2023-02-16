package com.file.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.file.service.AttachmentService;
import com.file.entity.Attachment;
import com.file.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService {
	
private AttachmentRepository attachmentRepository;
	
	// Bind krne ke liye Autowired na used krke Hune Constructor create kr diya

	public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
	
		this.attachmentRepository = attachmentRepository;
	}

	@Override
	public Attachment saveAttachment(MultipartFile file) throws Exception {
String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if(fileName.contains("..")) {
				throw new Exception("Filename contains invalid path sequence" + fileName);
			}
			Attachment attachment = new Attachment(fileName, 
					                   file.getContentType(),
					                   file.getBytes());
			return attachmentRepository.save(attachment);
			       
			  
		} catch(Exception e) {
			throw new Exception( " Could not save File:" +fileName);
		}
	}

	@Override
	public Attachment getAttachment(String fileId) throws Exception {
		
		return attachmentRepository.findById(fileId)
				.orElseThrow(
						() -> new Exception("file not found By Id:"  + fileId)); 
		}
	}	



