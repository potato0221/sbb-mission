package com.mysite.sbb.domain.answer.answer.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerForm {
    @NotEmpty(message = "답변을 입력 해 주세요.")
    private String content;
}
