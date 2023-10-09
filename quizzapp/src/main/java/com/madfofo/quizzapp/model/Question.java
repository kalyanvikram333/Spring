package com.madfofo.quizzapp.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String category;
    String difficultyLevel;

    String option1;
    String option2;
    String option3;
    String option4;
    String rightAnswer;
    String questionTitle;
}
