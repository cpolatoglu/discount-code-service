package com.acme.discountcodeservice.generator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class GeneratorControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void testGeneratorController() {
        GeneratorRequest request = new GeneratorRequest();
        request.setDiscountAmount(100);
        request.setNumberOfCodes(20);
        request.setPercentage(false);

        HttpStatus status = this.template.postForEntity("/generate", new HttpEntity<>(request), Void.class).getStatusCode();
        assertThat(status.is2xxSuccessful(), is(true));
    }
}
