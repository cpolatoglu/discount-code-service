package com.acme.discountcodeservice.generator;

import com.acme.discountcodeservice.entity.DiscountCode;
import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class GeneratorService {

    @Autowired
    DiscountCodeRepository discountCodeRepository;

    public List<String> generate(GenerateRequest request) {
        List<DiscountCode> discountCodeList = new ArrayList<>();

        SecureRandom secureRandom = new SecureRandom();
        log.info("Creating {} amount of codes", request.getNumberOfCodes());
        for (int i = 0; i < request.getNumberOfCodes(); i++) {
            DiscountCode discountCode = new DiscountCode();
            discountCode.setCode(RandomStringUtils.random(10, 0, 0, true, true, null, secureRandom));
            discountCode.setCompanyId(request.getCompanyId());
            discountCode.setAvailable(true);
            discountCodeList.add(discountCode);
        }
        log.info("Created {} number of codes", request.getNumberOfCodes());

        discountCodeRepository.saveAll(discountCodeList);
        log.info("Saved the discount codes in the database.");

        return discountCodeList.stream().map(DiscountCode::getCode).collect(Collectors.toList());
    }
}
