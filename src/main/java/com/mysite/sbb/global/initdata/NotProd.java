package com.mysite.sbb.global.initdata;

import com.mysite.sbb.domain.question.question.entitiy.Question;
import com.mysite.sbb.domain.question.question.repository.QuestionRepository;
import com.mysite.sbb.domain.question.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class NotProd {
    @Autowired
    private QuestionRepository questionRepository;
    @Bean
    public ApplicationRunner initNotProd(
            QuestionService questionService
    ){
        return args ->  {
            Question question1=new Question();
            question1.setSubject("sbb가 무엇인가요?");
            question1.setContent("sbb에 대해 알고 싶습니다.");
            question1.setCreateDate(LocalDateTime.now());
            this.questionRepository.save(question1);

            Question question2=new Question();
            question2.setSubject("안녕하세요 질문 있습니다.");
            question2.setContent("sbb의 좋은점을 알려주세요.");
            question2.setCreateDate(LocalDateTime.now());
            this.questionRepository.save(question2);
        };
    }

}
