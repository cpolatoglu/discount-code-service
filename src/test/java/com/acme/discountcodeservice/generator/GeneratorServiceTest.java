package com.acme.discountcodeservice.generator;

import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GeneratorServiceTest {

    @Mock
    DiscountCodeRepository repository;

    @Spy
    @InjectMocks
    GeneratorService codeGeneratorService;

    @Test
    void testCodeGeneration() {
        when(repository.saveAll(any())).thenReturn(null);
        GenerateRequest request = new GenerateRequest();
        request.setDiscountAmount(100);
        request.setNumberOfCodes(20);
        request.setPercentage(false);

        List<String> discountCodes = codeGeneratorService.generate(request);
        assertThat(discountCodes.size(), is(20));
    }
}
