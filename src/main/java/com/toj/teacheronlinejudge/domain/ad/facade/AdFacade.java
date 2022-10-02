package com.toj.teacheronlinejudge.domain.ad.facade;

import com.toj.teacheronlinejudge.domain.ad.domain.Ad;
import com.toj.teacheronlinejudge.domain.ad.domain.repository.AdRepository;
import com.toj.teacheronlinejudge.domain.ad.exception.AdNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdFacade {

    private final AdRepository adRepository;

    public Ad findAdById(Long id) {
        return adRepository.findById(id)
                .orElseThrow(() -> AdNotFoundException.EXCEPTION);
    }
}
