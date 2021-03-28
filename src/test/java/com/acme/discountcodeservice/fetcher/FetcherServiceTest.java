package com.acme.discountcodeservice.fetcher;

import com.acme.discountcodeservice.entity.DiscountCode;
import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FetcherServiceTest {

    @Mock
    DiscountCodeRepository discountCodeRepository;

    @Spy
    @InjectMocks
    FetcherService discountCodeFetcherService;

    @Test
    public void testFetchDiscountCode (){
        FetchRequest request = new FetchRequest();
        request.setCompanyId(1);
        request.setFirstName("Will E.");
        request.setLastName("Coyote");
        request.setEmail("will.e.coyote@looneytunes.com");
        request.setPhone("12345678");

        DiscountCode discountCode = new DiscountCode();
        discountCode.setCompanyId(1L);
        discountCode.setAvailable(true);
        discountCode.setCode("Gi1uFPmlqd");

        when(discountCodeRepository.findFirstByCompanyIdAndAvailableTrue(anyLong())).thenReturn(discountCode);
        String string = discountCodeFetcherService.fetchDiscountCode(request);
        assertThat(string, not(emptyOrNullString()));
        assertThat(string.length(), is(10));
        assertThat(discountCode.isAvailable(), is(false));
    }

    @Test
    public void testFetchDiscountCodeNotAvailable (){
        FetchRequest request = new FetchRequest();
        request.setCompanyId(1);
        request.setFirstName("Will E.");
        request.setLastName("Coyote");
        request.setEmail("will.e.coyote@looneytunes.com");
        request.setPhone("12345678");

        when(discountCodeRepository.findFirstByCompanyIdAndAvailableTrue(anyLong())).thenReturn(null);
        String string = discountCodeFetcherService.fetchDiscountCode(request);
        assertThat(string, is(emptyOrNullString()));
    }
}
