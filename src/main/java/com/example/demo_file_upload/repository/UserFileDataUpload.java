package com.example.demo_file_upload.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo_file_upload.entity.UsersFilesDetails;

@Repository
public interface UserFileDataUpload extends JpaRepository<UsersFilesDetails, Integer>{

}
