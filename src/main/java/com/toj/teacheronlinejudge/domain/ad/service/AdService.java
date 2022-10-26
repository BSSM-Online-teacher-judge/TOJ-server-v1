package com.toj.teacheronlinejudge.domain.ad.service;

import com.toj.teacheronlinejudge.domain.ad.domain.Ad;
import com.toj.teacheronlinejudge.domain.ad.domain.repository.AdRepository;
import com.toj.teacheronlinejudge.domain.ad.domain.type.AdSize;
import com.toj.teacheronlinejudge.domain.ad.facade.AdFacade;
import com.toj.teacheronlinejudge.domain.ad.presentation.dto.request.CreateAdRequestDto;
import com.toj.teacheronlinejudge.domain.ad.presentation.dto.response.AdResponseDto;
import com.toj.teacheronlinejudge.infrastructure.image.s3.S3Properties;
import com.toj.teacheronlinejudge.infrastructure.image.s3.facade.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdService {

    private final AdRepository adRepository;
    private final AdFacade adFacade;
    private final S3Facade s3Facade;
    private final S3Properties s3Properties;

    @Transactional
    public void createAd(CreateAdRequestDto dto, MultipartFile multipartFile) {
        String img = s3Facade.uploadImage(multipartFile, s3Properties.getAd());
        adRepository.save(dto.toEntity(img));
    }

    @Transactional
    public void deleteAd(Long id) {
        Ad ad = adFacade.findAdById(id);
        adRepository.delete(ad);
    }

    @Transactional(readOnly = true)
    public @ResponseBody List<AdResponseDto> getAllAd(AdSize adSize) {
        return adRepository.findByAdSizeOrderByIdDesc(adSize).stream()
                .map(AdResponseDto::of)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateStatus(Long id) {
        adFacade.findAdById(id).updateStatus();
    }

    @Transactional(readOnly = true)
    public AdResponseDto getAd(Long id) {
        Ad ad = adFacade.findAdById(id);
        adFacade.validateGetAd(ad);

        return AdResponseDto.of(ad);
    }
}
