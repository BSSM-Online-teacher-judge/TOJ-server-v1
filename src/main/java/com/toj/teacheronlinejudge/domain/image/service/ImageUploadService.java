package com.toj.teacheronlinejudge.domain.image.service;

import com.toj.teacheronlinejudge.domain.image.presentation.dto.response.ImageUrlResponse;
import com.toj.teacheronlinejudge.domain.image.presentation.type.Dir;
import com.toj.teacheronlinejudge.global.annotation.ServiceWithTransactionalReadOnly;
import com.toj.teacheronlinejudge.infrastructure.image.s3.facade.S3Facade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@ServiceWithTransactionalReadOnly
@RequiredArgsConstructor
public class ImageUploadService {

    private final S3Facade s3Facade;

    public ImageUrlResponse execute(List<MultipartFile> images, Dir dir) {

        String dirName = s3Facade.getDirName(dir);

        List<String> imageUrl = images.stream()
            .map(img -> s3Facade.uploadImage(img, dirName))
            .collect(Collectors.toList());

        return new ImageUrlResponse(imageUrl);
    }
}
