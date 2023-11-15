package com.example.demo_file_upload.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo_file_upload.entity.UserDetails;

@Repository
public interface UserDataUpload extends JpaRepository<UserDetails, Integer>{

	@Query(value= "SELECT userdetails.name from UserDetails userdetails")
	List<String> findAllFiles();
	
	@Query(value="select userdetails from UserDetails userdetails where userdetails.email= :email")
	List<UserDetails> findByEmailId(String email);
}
