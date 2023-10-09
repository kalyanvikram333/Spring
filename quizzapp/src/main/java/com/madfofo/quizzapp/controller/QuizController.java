package com.madfofo.quizzapp.controller;

import com.madfofo.quizzapp.model.Question;
import com.madfofo.quizzapp.model.QuestionWrapper;
import com.madfofo.quizzapp.model.Reponse;
import com.madfofo.quizzapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController
{
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int noOfQuestions,
                                             @RequestParam String title){

        return quizService.createQuiz(category,noOfQuestions,title);

    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable("id") int id){
        return quizService.getQuizbyId(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Reponse> responses){
        return quizService.calculateResult(id, responses);
    }
}
