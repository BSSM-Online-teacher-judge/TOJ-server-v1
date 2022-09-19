package com.toj.teacheronlinejudge.domain.stats.presentation;

import com.toj.teacheronlinejudge.domain.stats.presentation.dto.request.CreateSurveyRequestDto;
import com.toj.teacheronlinejudge.domain.stats.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/stats/survey/{id}")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;

    @PostMapping
    public void createSurvey(
            @PathVariable Long id,
            @Valid @RequestBody CreateSurveyRequestDto dto
    ) {
        surveyService.createSurvey(id, dto);
    }
}
