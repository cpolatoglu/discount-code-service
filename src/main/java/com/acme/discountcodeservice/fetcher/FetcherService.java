package com.acme.discountcodeservice.fetcher;

import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetcherService {

    @Autowired
    DiscountCodeRepository discountCodeRepository;

    public String fetchDiscountCode(FetchRequest request) {
        return discountCodeRepository.findFirstAvailableTrueByCompanyId(request.getCompanyId()).getCode();
    }
}
