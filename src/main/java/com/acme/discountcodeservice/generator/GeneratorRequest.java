package com.acme.discountcodeservice.generator;

import lombok.Data;

@Data
public class GeneratorRequest {
    long companyId;
    int numberOfCodes;
    int discountAmount;
    boolean isPercentage;
}
