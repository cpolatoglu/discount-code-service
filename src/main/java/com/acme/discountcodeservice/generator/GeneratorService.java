package com.acme.discountcodeservice.generator;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneratorService {
        public List<String> generate(GeneratorRequest request) {
        List<String> discountCodeList = new ArrayList<>();

        SecureRandom secureRandom = new SecureRandom();
        for(int i = 0; i < request.getNumberOfCodes(); i++){
            discountCodeList.add(RandomStringUtils.random(10, 0, 0, true, true, null, secureRandom));
        }
        return discountCodeList;
    }
}
