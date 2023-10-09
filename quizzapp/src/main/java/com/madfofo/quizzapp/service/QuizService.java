package com.madfofo.quizzapp.service;

import com.madfofo.quizzapp.dao.QuestionDAO;
import com.madfofo.quizzapp.dao.QuizDAO;
import com.madfofo.quizzapp.model.Question;
import com.madfofo.quizzapp.model.QuestionWrapper;
import com.madfofo.quizzapp.model.Quiz;
import com.madfofo.quizzapp.model.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {

    @Autowired
    QuizDAO quizDAO;

    @Autowired
    QuestionDAO questionDAO;

    public ResponseEntity<String> createQuiz(String category, int noOfQuestions, String title) {
        List<Question> questions=questionDAO.findRandomQuestionsByCategory(category,noOfQuestions);

        Quiz q=new Quiz();
        q.setTitle(title);
        q.setQuestions(questions);
        quizDAO.save(q);
        return new ResponseEntity<>("Sucess", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizbyId(int id) {
        Optional<Quiz> quiz=quizDAO.findById(id);
        List<Question> listOfQuestions=quiz.get().getQuestions(); //If optional then get() method is used

        List<QuestionWrapper> questionsForUser=new ArrayList<>();
        for(Question q:listOfQuestions){
            QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4(),q.getQuestionTitle());
            questionsForUser.add(qw);
        }

        return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Reponse> responses) {
        Quiz q=quizDAO.findById(id).get();
        List<Question> list=q.getQuestions();
        int i=0;
        Map<Integer,String> mapQuestion=new HashMap<>();
        for(Question l:list){
            mapQuestion.put(l.getId(),l.getRightAnswer());
        }
        for(Reponse res:responses){
            int qid=res.getId();
            if(mapQuestion.containsKey(qid)){
                if(mapQuestion.get(qid).equals(res.getRight_answer())){
                   i++;
                }
            }

        }
        return new ResponseEntity<>(i,HttpStatus.OK);

    }
}
