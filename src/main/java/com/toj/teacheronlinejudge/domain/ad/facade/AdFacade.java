package com.toj.teacheronlinejudge.domain.ad.facade;

import com.toj.teacheronlinejudge.domain.ad.domain.Ad;
import com.toj.teacheronlinejudge.domain.ad.domain.repository.AdRepository;
import com.toj.teacheronlinejudge.domain.ad.domain.type.Status;
import com.toj.teacheronlinejudge.domain.ad.exception.AdNotFoundException;
import com.toj.teacheronlinejudge.domain.ad.exception.AlreadyCloseAdException;
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

    public void validateGetAd(Ad ad) {
        if (ad.getStatus().equals(Status.CLOSE)) {
            throw AlreadyCloseAdException.EXCEPTION;
        }
    }
}
