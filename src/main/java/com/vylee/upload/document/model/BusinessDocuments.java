package com.vylee.upload.document.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BusinessDocuments {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long vendorId;

	@Column(nullable = false)
	private String identityProofType;

	@Column(name = "fileName")
	private String fileName;

	@Lob
	@Column(name = "images", columnDefinition = "LONGBLOB")
	private byte[] shopRegistrationFilePath;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getIdentityProofType() {
		return identityProofType;
	}

	public void setIdentityProofType(String identityProofType) {
		this.identityProofType = identityProofType;
	}

	public byte[] getShopRegistrationFilePath() {
		return shopRegistrationFilePath;
	}

	public void setShopRegistrationFilePath(byte[] shopRegistrationFilePath) {
		this.shopRegistrationFilePath = shopRegistrationFilePath;
	}

	public BusinessDocuments() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BusinessDocuments(Long vendorId, String identityProofType, String fileName,
			byte[] shopRegistrationFilePath) {
		super();
		this.vendorId = vendorId;
		this.identityProofType = identityProofType;
		this.fileName = fileName;
		this.shopRegistrationFilePath = shopRegistrationFilePath;
	}

	
}