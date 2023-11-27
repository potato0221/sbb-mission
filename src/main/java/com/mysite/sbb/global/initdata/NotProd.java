package com.mysite.sbb.global.initdata;

import com.mysite.sbb.domain.question.question.entitiy.Question;
import com.mysite.sbb.domain.question.question.repository.QuestionRepository;
import com.mysite.sbb.domain.question.question.service.QuestionService;
import com.mysite.sbb.domain.user.user.entitiy.SiteUser;
import com.mysite.sbb.domain.user.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {
    @Autowired
    private QuestionRepository questionRepository;

    //    페이징을 위해 대량 테스트 데이터 추가
    @Bean
    public ApplicationRunner initNotProd(
            QuestionService questionService,
            UserService userService
    ) {
        return args -> {
            SiteUser siteUser1 = new SiteUser();
            SiteUser siteUser2 = new SiteUser();
            siteUser1 = userService.create("user1", "www1@email.com", "1234");
            siteUser2 = userService.create("user2", "www2@email.com", "1234");


            for (int i = 1; i <= 60; i++) {
                Question question = new Question();
                questionService.create(
                        "질문 제목 " + i,
                        "질문 내용 " + i,
                        siteUser1
                );
            }

        };
    }

}
