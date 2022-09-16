package com.toj.teacheronlinejudge.global.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCodeUtil {

    public static String generateCode(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }
}
