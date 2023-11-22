package com.mysite.sbb.global.initdata;

import com.mysite.sbb.domain.question.question.entitiy.Question;
import com.mysite.sbb.domain.question.question.repository.QuestionRepository;
import com.mysite.sbb.domain.question.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {
    @Autowired
    private QuestionRepository questionRepository;
    @Bean
    public ApplicationRunner initNotProd(
            QuestionService questionService
    ){
        return args ->  {
            Question question2=new Question();
            questionService.create(
                    "sbb에 대해 알고싶습니다.",
                    "sbb에 대해 알려주세요"
            );
            questionService.create(
                    "안녕하세요 질문 있습니다.",
                    "sbb의 좋은점을 알려주세요."
            );
        };
    }

}
