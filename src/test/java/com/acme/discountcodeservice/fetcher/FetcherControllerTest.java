package com.acme.discountcodeservice.fetcher;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FetcherControllerTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    void testFetchController() {
        FetchRequest request = new FetchRequest();
        request.setCompanyId(1);
        request.setFirstName("Will E.");
        request.setLastName("Coyote");
        request.setEmail("will.e.coyote@looneytunes.com");
        request.setPhone("12345678");

        ResponseEntity<String> responseEntity = template.postForEntity("/fetch", new HttpEntity<>(request), String.class);
        assertThat(responseEntity.getStatusCode().value(), is(200));
        assertThat(responseEntity.getBody(), not(emptyOrNullString()));
        assertThat(responseEntity.getBody().length(), is(10));
    }

    @Test
    void testFetchControllerNoContent() {
        FetchRequest request = new FetchRequest();
        request.setCompanyId(2);
        request.setFirstName("Will E.");
        request.setLastName("Coyote");
        request.setEmail("will.e.coyote@looneytunes.com");
        request.setPhone("12345678");

        ResponseEntity<String> responseEntity = template.postForEntity("/fetch", new HttpEntity<>(request), String.class);
        assertThat(responseEntity.getStatusCode().value(), is(204));
        assertThat(responseEntity.getBody(), is(emptyOrNullString()));
    }
}
