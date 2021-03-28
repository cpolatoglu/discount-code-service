package com.acme.discountcodeservice.generator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class GeneratorControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void testGeneratorController() {
        GeneratorRequest request = new GeneratorRequest();
        request.setCompanyId(1);
        request.setDiscountAmount(100);
        request.setNumberOfCodes(20);
        request.setPercentage(false);

        ResponseEntity<String[]> responseEntity = template.postForEntity("/generate", new HttpEntity<>(request), String[].class);
        assertThat(responseEntity.getStatusCode().is2xxSuccessful(), is(true));
        assertThat(responseEntity.getBody().length, is(20));
    }
}
