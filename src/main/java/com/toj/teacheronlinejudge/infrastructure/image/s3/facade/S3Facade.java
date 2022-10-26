package com.toj.teacheronlinejudge.infrastructure.image.s3.facade;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.toj.teacheronlinejudge.infrastructure.image.ImageUtil;
import com.toj.teacheronlinejudge.infrastructure.image.s3.S3Properties;
import com.toj.teacheronlinejudge.infrastructure.image.s3.exception.EmptyFileException;
import com.toj.teacheronlinejudge.infrastructure.image.s3.exception.SaveFailedException;
import com.toj.teacheronlinejudge.infrastructure.image.s3.exception.TooLongTitleException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class S3Facade implements ImageUtil {

    private final S3Properties s3Properties;
    private final AmazonS3Client amazonS3Client;

    @Override
    public String uploadImage(MultipartFile image, String dirName) {

        validateFile(image);

        String fileName = s3Properties.getBucket() + "/" + dirName + UUID.randomUUID() + image.getOriginalFilename();

        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(
                s3Properties.getBucket(),
                fileName,
                image.getInputStream(),
                getObjectMetadata(image)
            );

            amazonS3Client.putObject(putObjectRequest.withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (Exception e) {
            throw SaveFailedException.EXCEPTION;
        }

        return getFileUrl(fileName);
    }

    private void validateFile(MultipartFile multipartFile){
        if(multipartFile.isEmpty()) {
            throw EmptyFileException.EXCEPTION;
        }

        if (multipartFile.getOriginalFilename().length() > 20) {
            throw TooLongTitleException.EXCEPTION;
        }
    }

    private ObjectMetadata getObjectMetadata(MultipartFile image) {
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(image.getSize());
        objectMetadata.setContentType(image.getContentType());
        return objectMetadata;
    }

    private String getFileUrl(String fileName) {
        return amazonS3Client.getUrl(s3Properties.getBucket(), fileName).toString();
    }
}
