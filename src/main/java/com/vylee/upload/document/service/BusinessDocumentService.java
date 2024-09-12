package com.vylee.upload.document.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.vylee.upload.document.model.BusinessDocuments;

public interface BusinessDocumentService {

	List<BusinessDocuments> saveFile(List<MultipartFile> multipartFile, Long vendorId) throws IOException;

}