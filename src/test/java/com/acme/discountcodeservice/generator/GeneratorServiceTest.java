package com.acme.discountcodeservice.generator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GeneratorServiceTest {

    GeneratorService codeGeneratorService = new GeneratorService();

    @Test
    public void testCodeGeneration() {
        GeneratorRequest request = new GeneratorRequest();
        request.setDiscountAmount(100);
        request.setNumberOfCodes(20);
        request.setPercentage(false);

        List<String> discountCodes = codeGeneratorService.generate(request);
        assertThat(discountCodes.size(), is(20));
    }
}
