package com.mysite.sbb.domain.question.question.controller;

import com.mysite.sbb.domain.answer.answer.dto.AnswerForm;
import com.mysite.sbb.domain.question.question.dto.QuestionForm;
import com.mysite.sbb.domain.question.question.entitiy.Question;
import com.mysite.sbb.domain.question.question.service.QuestionService;
import com.mysite.sbb.domain.user.user.entitiy.SiteUser;
import com.mysite.sbb.domain.user.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    private final UserService userService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value = "page",defaultValue = "0") int page) {
        Page<Question> paging=this.questionService.getlist(page);
        model.addAttribute("paging",paging);
        return "question/question/question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question/question/question_detail";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question/question/question_form";
    }


    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm,
                                 BindingResult bindingResult,
                                 Principal principal) {
        if(bindingResult.hasErrors()){
            return "question/question/question_form";
        }
        SiteUser siteUser=this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(),questionForm.getContent(),siteUser);
        return "redirect:/question/list";
    }


}
