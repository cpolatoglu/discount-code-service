package com.acme.discountcodeservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class DiscountCodeServiceApplicationTests {

	@Autowired
	private TestRestTemplate template;

	@Test
	void testHealthcheck() {
		HttpStatus status = this.template.getForEntity("/actuator/health", String.class).getStatusCode();
		assertThat(status.is2xxSuccessful(), is(true));
	}
}
