package com.springboot.learning.springbootlearning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learning.springbootlearning.model.Question;
import com.springboot.learning.springbootlearning.repository.QuestionRepository;

@RestController
@CrossOrigin(origins = "*")
public class QuestionController {
	
	@Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/questions")
    public Page<Question> getQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

}
