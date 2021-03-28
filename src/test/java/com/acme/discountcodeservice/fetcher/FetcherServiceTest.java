package com.acme.discountcodeservice.fetcher;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class FetcherServiceTest {

    FetcherService discountCodeFetcherService = new FetcherService();
    @Test
    public void testFetchDiscountCode (){
        FetchRequest request = new FetchRequest();
        request.setCompanyId(1);
        request.setFirstName("Will E.");
        request.setLastName("Coyote");
        request.setEmail("will.e.coyote@looneytunes.com");
        request.setPhone("12345678");

        String string = discountCodeFetcherService.fetchDiscountCode(request);
        assertThat(string, not(emptyOrNullString()));
        assertThat(string.length(), is(10));
    }
}
