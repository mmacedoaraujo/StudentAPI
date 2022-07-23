package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.StudentRequest;
import com.example.demo.model.StudentResponse;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/v1")
public class StudentController {

	@Autowired
	private StudentService service;
	
	@PostMapping
	public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest request) {
		return ResponseEntity.ok(service.create(request));
	}
	@GetMapping
	public ResponseEntity<List<StudentResponse>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}
}
