package com.toj.teacheronlinejudge.domain.stats.presentation;

import com.toj.teacheronlinejudge.domain.stats.presentation.dto.response.StatsResponseDto;
import com.toj.teacheronlinejudge.domain.stats.service.StatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stats/{teacherId}")
public class StatsController {

    private final StatsService statsService;

    @GetMapping
    public StatsResponseDto findStats(@PathVariable Long teacherId) {
        return statsService.findStats(teacherId);
    }
}
