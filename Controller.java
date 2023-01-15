package com;

import java.util.Optional;
import org.springframework.boot.ApplicationArguments; 
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

import com.repo.StudentRepository;
import com.beans.Student;

public class Controller {

	@Bean
	ApplicationRunner init(StudentRepository studentRepository) {
		return (ApplicationArguments args) -> dataSetup(studentRepository);
	}

	private void dataSetup(StudentRepository studentRepository) {

		Student student = new Student(1, "Pratik", "Mashere", "Pune");

		studentRepository.save(student);                                  // Insert Records..

		student.setFirstName("Shubham");
		studentRepository.save(student);                                  // Update FirstName
		
		student.setCity("Delhi");
		studentRepository.save(student);                                  // Update City

		student.setLastName("Supekar");                                   // Update LastName
		studentRepository.save(student);

		studentRepository.delete(student);                              // Delete Record from Student
		
        student = new Student(2, "Rohan", "Deshmukh", "Mumbai");
        student = new Student(3, "Gaurav", "Kale", "Pimpri");
        
		studentRepository.save(student);                                  // Insert Records..
		
		studentRepository.findRevisions(1).stream().forEach(e->{
	        Optional<Integer> nr=e.getRevisionNumber();
	        Student entity=e.getEntity();
	        System.out.println(nr.get()+" "+entity.toString());
	});
  }
}