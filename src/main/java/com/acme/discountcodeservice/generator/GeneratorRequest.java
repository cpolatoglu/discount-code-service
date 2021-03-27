package com.acme.discountcodeservice.generator;

import lombok.Data;

@Data
public class GeneratorRequest {
    int numberOfCodes;
    int discountAmount;
    boolean isPercentage;
}
