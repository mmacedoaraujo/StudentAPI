package com.example.demo.service;

import java.util.List;

import com.example.demo.model.StudentRequest;
import com.example.demo.model.StudentResponse;

public interface StudentService {
	
	StudentResponse create(StudentRequest request);
	
	List<StudentResponse> getAll();
}
