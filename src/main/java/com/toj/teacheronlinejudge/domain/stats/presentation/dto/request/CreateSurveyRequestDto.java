package com.toj.teacheronlinejudge.domain.stats.presentation.dto.request;

import com.toj.teacheronlinejudge.domain.stats.domain.Survey;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CreateSurveyRequestDto {

    @NotNull
    @Size(max = 10)
    private int humor;      // 유머
    
    @NotNull
    @Size(max = 10)
    private int tenacity;   // 인성
    
    @NotNull
    @Size(max = 10)
    private int expertise;  // 전문성
    
    @NotNull
    @Size(max = 10)
    private int fairness;   // 공평성
    
    @NotNull
    @Size(max = 10)
    private int snackReadiness;  // 간식 준비성
    
    @NotNull
    @Size(max = 10)
    private int modesty;    // 겸손
    
    @NotNull
    @Size(max = 10)
    private int passion;    // 열정

    
    @NotNull
    @Size(max = 10)
    private int stubborn;   // 고집
    
    @NotNull
    @Size(max = 10)
    private int authoritarianism; // 권위주의
    
    @NotNull
    @Size(max = 10)
    private int SUA;    // 급발진 정도

    public Survey toEntity() {
        return Survey.builder()
                .humor(humor)
                .tenacity(tenacity)
                .expertise(expertise)
                .fairness(fairness)
                .snackReadiness(snackReadiness)
                .modesty(modesty)
                .passion(passion)
                .stubborn(stubborn)
                .authoritarianism(authoritarianism)
                .SUA(SUA)
                .build();
    }
}
