package com.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import com.beans.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>,RevisionRepository <Student, Integer, Integer> {
}