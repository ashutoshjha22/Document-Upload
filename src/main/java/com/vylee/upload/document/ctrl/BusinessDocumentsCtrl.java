package com.vylee.upload.document.ctrl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vylee.upload.document.service.BusinessDocumentService;

@RestController
@RequestMapping("Document-upload")
public class BusinessDocumentsCtrl {

	@Autowired
	private BusinessDocumentService businessDocumentService;

	@PostMapping("/upload/document/images")
	public ResponseEntity<String> uploadFile(@RequestParam("files") List<MultipartFile> files,
			@RequestParam("vendorId") Long vendorId) {
		try {
			if (vendorId == null) {
				return new ResponseEntity<>("Vendor ID is missing", HttpStatus.BAD_REQUEST);
			}

			if (files == null || files.isEmpty()) {
				return new ResponseEntity<>("No files were uploaded", HttpStatus.BAD_REQUEST);
			}

			businessDocumentService.saveFile(files, vendorId);

			return new ResponseEntity<>("Files uploaded successfully!", HttpStatus.OK);
		} catch (IOException e) {
			return new ResponseEntity<>("Failed to upload files: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}