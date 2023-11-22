package com.mysite.sbb.domain.question.question.service;

import com.mysite.sbb.DataNotFoundException;
import com.mysite.sbb.domain.question.question.entitiy.Question;
import com.mysite.sbb.domain.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList(){
        return this.questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question=this.questionRepository.findById(id);
        if(question.isPresent()){
            return question.get();
        }else {
            throw new DataNotFoundException("question is not found");
        }
    }
    public void create(String subject, String content){
        Question question=new Question();
        question.setSubject(subject);
        question.setContent(content);
        question.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }
}
