package com.madfofo.quizzapp.controller;


import com.madfofo.quizzapp.model.Question;
import com.madfofo.quizzapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;

    @GetMapping("allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return
                questionService.getAllQuestions();
    }


    @GetMapping("category/{topic}")
    public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("topic") String category ){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question q){

        return questionService.addQuestion(q);
    }

    @DeleteMapping("delete/{id}")
    public String deleteQuestion(@PathVariable("id") int id){
        return questionService.deleteQuestion(id);
    }

}
