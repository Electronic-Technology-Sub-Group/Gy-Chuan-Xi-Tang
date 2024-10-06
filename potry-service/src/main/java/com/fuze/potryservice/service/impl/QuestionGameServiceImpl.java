package com.fuze.potryservice.service.impl;

import com.fuze.potryservice.mapper.QuestionGameMapper;
import com.fuze.potryservice.service.QuestionGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionGameServiceImpl implements QuestionGameService {
    @Autowired
    private QuestionGameMapper questionGameMapper;
    @Override
    public void addQuestion(String s) {
        questionGameMapper.addQuestion(s);
    }

    @Override
    public String getQuestion() {
        return questionGameMapper.getquestion();
    }

    @Override
    public void deleteQuestion() {
        questionGameMapper.deleteQuestion();
    }

    @Override
    public void addsum(int sum, Integer userId) {
        questionGameMapper.addsum(sum, userId);
    }
}
