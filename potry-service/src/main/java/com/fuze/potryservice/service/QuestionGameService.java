package com.fuze.potryservice.service;

public interface QuestionGameService {
    void addQuestion(String s);

    String getQuestion();

    void deleteQuestion();

    void addsum(int sum, Integer userId);
}
