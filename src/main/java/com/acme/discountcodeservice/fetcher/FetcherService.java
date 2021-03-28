package com.acme.discountcodeservice.fetcher;

import com.acme.discountcodeservice.entity.DiscountCode;
import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetcherService {

    @Autowired
    DiscountCodeRepository discountCodeRepository;

    public String fetchDiscountCode(FetchRequest request) {
        DiscountCode discountCode = discountCodeRepository.findFirstByCompanyIdAndAvailableTrue(request.getCompanyId());
        discountCode.setAvailable(false);
        discountCodeRepository.save(discountCode);

        return discountCode.getCode();
    }
}
