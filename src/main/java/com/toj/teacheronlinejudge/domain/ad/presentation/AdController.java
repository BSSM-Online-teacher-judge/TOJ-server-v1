package com.toj.teacheronlinejudge.domain.ad.presentation;

import com.toj.teacheronlinejudge.domain.ad.domain.type.AdSize;
import com.toj.teacheronlinejudge.domain.ad.presentation.dto.request.CreateAdRequestDto;
import com.toj.teacheronlinejudge.domain.ad.presentation.dto.response.AdResponseDto;
import com.toj.teacheronlinejudge.domain.ad.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ad")
public class AdController {

    private final AdService adService;

    @PostMapping
    public void createAd(@RequestBody @Valid CreateAdRequestDto dto) {
        adService.createAd(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteAd(@PathVariable Long id) {
        adService.deleteAd(id);
    }

    @GetMapping
    public List<AdResponseDto> getAllAd(@RequestParam("size")AdSize adSize) {
        return adService.getAllAd(adSize);
    }

    @PutMapping("/{id}")
    public void updateStatus(@PathVariable Long id) {
        adService.updateStatus(id);
    }

    @GetMapping("/{id}")
    public AdResponseDto getAd(@PathVariable Long id) {
        return adService.getAd(id);
    }
}