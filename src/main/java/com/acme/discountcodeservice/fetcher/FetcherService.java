package com.acme.discountcodeservice.fetcher;

import org.springframework.stereotype.Service;

@Service
public class FetcherService {

    public String fetchDiscountCode(FetchRequest request) {
        return "Hello";
    }
}
