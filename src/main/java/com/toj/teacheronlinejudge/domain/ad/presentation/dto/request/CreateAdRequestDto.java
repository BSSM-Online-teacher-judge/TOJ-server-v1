package com.toj.teacheronlinejudge.domain.ad.presentation.dto.request;

import com.toj.teacheronlinejudge.domain.ad.domain.Ad;
import com.toj.teacheronlinejudge.domain.ad.domain.type.AdSize;
import com.toj.teacheronlinejudge.domain.ad.domain.type.Status;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class CreateAdRequestDto {

    @NotBlank(message = "광고주명을 입력해주세요")
    private String advertiser;

    private String link;

    private AdSize adSize;

    private String img;

    public Ad toEntity(String img) {
        return Ad.builder()
            .img(img)
            .advertiser(advertiser)
            .link(link)
            .adSize(adSize)
            .img(img)
            .status(Status.OPEN)
            .build();
    }
}
