package com.toj.teacheronlinejudge.domain.teacher.presentation;

import com.toj.teacheronlinejudge.domain.teacher.presentation.dto.request.CreateSurveyRequestDto;
import com.toj.teacheronlinejudge.domain.teacher.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher/survey/{id}")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping
    public void createSurvey(
            @PathVariable Long id,
            @RequestBody CreateSurveyRequestDto dto
    ) {
        surveyService.createSurvey(id, dto);
    }
}
