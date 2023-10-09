package com.madfofo.quizzapp.dao;

import com.madfofo.quizzapp.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDAO extends JpaRepository<Question,Integer> {
    public List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM QUESTION q WHERE q.category=:category ORDER BY RAND() LIMIT :noOfQuestions", nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int noOfQuestions);
}
