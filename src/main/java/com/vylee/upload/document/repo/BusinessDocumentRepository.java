package com.vylee.upload.document.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vylee.upload.document.model.BusinessDocuments;

public interface BusinessDocumentRepository extends JpaRepository<BusinessDocuments, Long> {

}