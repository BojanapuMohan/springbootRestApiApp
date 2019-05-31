package com.springboot.learning.springbootlearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.learning.springbootlearning.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
	
	

}
