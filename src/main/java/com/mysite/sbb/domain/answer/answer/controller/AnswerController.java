package com.mysite.sbb.domain.answer.answer.controller;

import com.mysite.sbb.domain.answer.answer.service.AnswerService;
import com.mysite.sbb.domain.models.dto.AnswerForm;
import com.mysite.sbb.domain.question.question.entitiy.Question;
import com.mysite.sbb.domain.question.question.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model,
                               @PathVariable("id") Integer id,
                               @Valid AnswerForm answerForm, BindingResult bindingResult){
        Question question=this.questionService.getQuestion(id);
        if(bindingResult.hasErrors()){
            model.addAttribute("question",question);
            return "question/question/question_detail";
        }
        this.answerService.create(question,answerForm.getContent());
        return String.format("redirect:/question/detail/%s",id);
    }
}
