package com.toj.teacheronlinejudge.domain.stats.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.stats.domain.Stats;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StatsResponseDto {

    private PositiveStats positiveStats;
    private NegativeStats negativeStats;

    @Getter
    @Builder
    public static class PositiveStats {
        protected int humor;      // 유머

        protected int tenacity;   // 인성

        protected int expertise;  // 전문성

        protected int fairness;   // 공평성

        protected int snackReadiness;  // 간식 준비성

        protected int modesty;    // 겸손

        protected int passion;    // 열정
    }

    @Getter
    @Builder
    public static class NegativeStats {
        protected int stubborn;   // 고집

        protected int authoritarianism; // 권위주의

        protected int SUA;    // 급발진 정도
    }

    public static StatsResponseDto of(Stats stats) {

        PositiveStats positiveStats = PositiveStats.builder()
                .humor(stats.getHumor())
                .tenacity(stats.getTenacity())
                .expertise(stats.getExpertise())
                .fairness(stats.getFairness())
                .snackReadiness(stats.getSnackReadiness())
                .modesty(stats.getModesty())
                .passion(stats.getPassion())
                .build();

        NegativeStats negativeStats = NegativeStats.builder()
                .stubborn(stats.getStubborn())
                .authoritarianism(stats.getAuthoritarianism())
                .SUA(stats.getSua())
                .build();


        return StatsResponseDto.builder()
                .positiveStats(positiveStats)
                .negativeStats(negativeStats)
                .build();
    }
}
