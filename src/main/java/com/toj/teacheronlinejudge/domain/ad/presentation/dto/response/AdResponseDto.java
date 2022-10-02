package com.toj.teacheronlinejudge.domain.ad.presentation.dto.response;

import com.toj.teacheronlinejudge.domain.ad.domain.Ad;
import com.toj.teacheronlinejudge.domain.ad.domain.type.Status;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdResponseDto {

    private Long id;

    private String img;

    private String advertiser;

    private String link;

    private Status status;

    public static AdResponseDto of(Ad ad) {
        return AdResponseDto.builder()
                .id(ad.getId())
                .img(ad.getImg())
                .advertiser(ad.getAdvertiser())
                .link(ad.getLink())
                .status(ad.getStatus())
                .build();
    }
}
