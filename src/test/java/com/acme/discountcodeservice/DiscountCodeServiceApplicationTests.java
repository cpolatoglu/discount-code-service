package com.acme.discountcodeservice;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
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
