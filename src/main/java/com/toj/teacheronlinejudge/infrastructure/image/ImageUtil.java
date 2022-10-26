package com.toj.teacheronlinejudge.infrastructure.image;

import org.springframework.web.multipart.MultipartFile;

public interface ImageUtil {

    String uploadImage(MultipartFile image, String dirName);
}
