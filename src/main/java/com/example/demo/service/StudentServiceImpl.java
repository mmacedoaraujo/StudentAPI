package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.StudentRequest;
import com.example.demo.model.StudentResponse;
import com.example.demo.persistence.entity.Student;
import com.example.demo.persistence.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public StudentResponse create(StudentRequest request) {
		Student student = new Student();
		student.setName(request.getName());
		student.setDocument(request.getDocument());
		student.setBirthDate(request.getBirthDate());

		studentRepo.save(student);

		return createResponse(student);
	}

	@Override
	public List<StudentResponse> getAll() {
		List<StudentResponse> responses = new ArrayList<>();

		List<Student> students = studentRepo.findAll();

		if (!students.isEmpty()) {
			students.forEach(student -> responses.add(createResponse(student)));
		}

		return responses;
	}

	private StudentResponse createResponse(Student student) {
		StudentResponse response = new StudentResponse();
		response.setId(student.getId());
		response.setName(student.getName());
		response.setDocument(student.getDocument());
		response.setBirthDate(student.getBirthDate());

		return response;
	}		

}
