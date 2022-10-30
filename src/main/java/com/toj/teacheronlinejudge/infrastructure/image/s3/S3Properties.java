package com.toj.teacheronlinejudge.infrastructure.image.s3;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@Validated
@ConfigurationProperties("cloud.aws.s3")
public class S3Properties {

    @NotEmpty
    private final String bucket;

    @NotEmpty
    private final String user;

    @NotEmpty
    private final String teacher;

    @NotEmpty
    private final String ad;
}
