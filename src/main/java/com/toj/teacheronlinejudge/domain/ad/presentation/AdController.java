package com.toj.teacheronlinejudge.domain.ad.presentation;

import com.toj.teacheronlinejudge.domain.ad.presentation.dto.request.CreateAdRequestDto;
import com.toj.teacheronlinejudge.domain.ad.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AdController {

    private final AdService adService;

    @PostMapping
    public void createAd(
            @RequestBody @Valid CreateAdRequestDto dto,
            @RequestParam(name = "image")MultipartFile multipartFile
    ) {
        adService.createAd(dto, multipartFile);
    }
}
