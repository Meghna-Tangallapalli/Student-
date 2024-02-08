package com.demostudent.api.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demostudent.api.Entity.StudentEntity;
import com.demostudent.api.Repository.StudentRepository;

@RestController
//@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/student")
	public ResponseEntity<StudentEntity> saveStudent(@RequestBody StudentEntity student) {
		return new ResponseEntity<>(studentRepository.save(student),(HttpStatus.CREATED));
		
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<StudentEntity>> getStudents(){
		return new ResponseEntity<>(studentRepository.findAll(),HttpStatus.OK);
		
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<StudentEntity> getStudent(@PathVariable long id){
		 Optional<StudentEntity> student = studentRepository.findById(id);
		 if(student.isPresent()) {
			 return new ResponseEntity<>(student.get(),HttpStatus.OK);
		 }else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		 }
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<StudentEntity> updateStudent(@PathVariable long id,@RequestBody StudentEntity stu){
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(student.isPresent()) {
			student.get().setName(stu.getName());
			student.get().setEmail(stu.getEmail());
			student.get().setPhoneNumber(stu.getPhoneNumber());
			return new ResponseEntity<>(studentRepository.save(student.get()),HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable long id){
		Optional<StudentEntity> student = studentRepository.findById(id);
		if(student.isPresent()) {
			studentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
}
