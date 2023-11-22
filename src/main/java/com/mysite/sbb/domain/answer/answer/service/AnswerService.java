package com.mysite.sbb.domain.answer.answer.service;

import com.mysite.sbb.domain.answer.answer.entity.Answer;
import com.mysite.sbb.domain.answer.answer.repository.AnswerRepository;
import com.mysite.sbb.domain.question.question.entitiy.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void create(Question question,String content){
        Answer answer=new Answer();

        answer.setContent(content);
        answer.setCreateDate(LocalDateTime.now());
        answer.setQuestion(question);
        this.answerRepository.save(answer);
    }

}
