package com.vylee.upload.document.serviceIml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vylee.upload.document.model.BusinessDocuments;
import com.vylee.upload.document.repo.BusinessDocumentRepository;
import com.vylee.upload.document.service.BusinessDocumentService;

@Service
public class BusinessDocumentServiceImpl implements BusinessDocumentService {

	@Autowired
	private BusinessDocumentRepository businessDocumentRepository;

	@Override
	public List<BusinessDocuments> saveFile(List<MultipartFile> multipartFiles, Long vendorId) throws IOException {
		List<BusinessDocuments> savedFiles = new ArrayList<>();

		for (MultipartFile file : multipartFiles) {
			String fileName = file.getOriginalFilename();
			String fileType = file.getContentType();
			byte[] data = file.getBytes();

			BusinessDocuments businessDocuments = new BusinessDocuments(vendorId, fileType, fileName, data);

			savedFiles.add(businessDocumentRepository.save(businessDocuments));
		}

		return savedFiles;
	}

}