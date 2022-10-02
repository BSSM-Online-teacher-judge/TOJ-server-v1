package com.toj.teacheronlinejudge.domain.ad.presentation;

import com.toj.teacheronlinejudge.domain.ad.presentation.dto.response.AdResponseDto;
import com.toj.teacheronlinejudge.domain.ad.presentation.dto.request.CreateAdRequestDto;
import com.toj.teacheronlinejudge.domain.ad.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ad")
public class AdController {

    private final AdService adService;

    @PostMapping
    public void createAd(
            @RequestPart(name = "dto") @Valid CreateAdRequestDto dto,
            @RequestPart(name = "image")MultipartFile multipartFile
    ) {
        adService.createAd(dto, multipartFile);
    }

    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
    }

    @GetMapping
    public List<AdResponseDto> getAllAd() {
        return adService.getAllAd();
    }

    @PutMapping("/{id}")
    public void updateStatus(@PathVariable Long id) {
        adService.updateStatus(id);
    }
}