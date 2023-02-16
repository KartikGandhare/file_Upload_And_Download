package com.file.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;   

@Entity
@Data
@NoArgsConstructor

public class Attachment {
	
	@Id
	@GeneratedValue(generator = "uuid")   
	@GenericGenerator(name="uuid" , strategy = "uuid2")
	private String Id;
	
	@Column(name="File_Name")
	private String fileName;
	
	@Column(name="File_Type")
	private String fileType;
	
	@Lob
	private byte[]  data;

	public Attachment(String fileName, String fileType, byte[] data) {
		
		this.fileName = fileName;
		this.fileType = fileType;
		this.data = data;
	}



}
