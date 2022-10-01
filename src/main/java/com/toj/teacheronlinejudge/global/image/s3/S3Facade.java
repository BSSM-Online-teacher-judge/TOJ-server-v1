package com.toj.teacheronlinejudge.global.image.s3;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.toj.teacheronlinejudge.global.image.exception.EmptyFileException;
import com.toj.teacheronlinejudge.global.image.exception.FailedSaveFileException;
import com.toj.teacheronlinejudge.global.image.exception.TooLongTitleException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class S3Facade {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    private final AmazonS3Client amazonS3Client;

    public String upload(MultipartFile multipartFile, String dirName) {
        validateFile(multipartFile);
        
        String fileName = dirName + UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        try {
            amazonS3Client.putObject(
                    bucket,
                    fileName,
                    multipartFile.getInputStream(),
                    getObjectMetadata(multipartFile));
        } catch (Exception e) {
            throw FailedSaveFileException.EXCEPTION;
        }

        return amazonS3Client.getUrl(bucket, fileName).toString();

    }

    private ObjectMetadata getObjectMetadata(MultipartFile multipartFile) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(multipartFile.getContentType());
        metadata.setContentLength(multipartFile.getSize());

        return metadata;
    }

    private void validateFile(MultipartFile multipartFile){
        if(multipartFile.isEmpty()) {
            throw EmptyFileException.EXCEPTION;
        }

        if (multipartFile.getOriginalFilename().length() > 20) {
            throw TooLongTitleException.EXCEPTION;
        }
    }

}
