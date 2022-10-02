package com.toj.teacheronlinejudge.domain.ad.service;

import com.toj.teacheronlinejudge.domain.ad.domain.repository.AdRepository;
import com.toj.teacheronlinejudge.domain.ad.presentation.dto.request.CreateAdRequestDto;
import com.toj.teacheronlinejudge.global.image.s3.S3Facade;
import com.toj.teacheronlinejudge.global.image.s3.S3Properties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;
    private final S3Facade s3Facade;

    @Transactional
    public void createAd(CreateAdRequestDto dto, MultipartFile multipartFile) {
        String img = s3Facade.upload(multipartFile, S3Properties.AD_IMG);
        adRepository.save(dto.toEntity(img));
    }
}
