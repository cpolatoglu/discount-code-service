package com.acme.discountcodeservice.fetcher;

import com.acme.discountcodeservice.entity.DiscountCode;
import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FetcherService {

    @Autowired
    DiscountCodeRepository discountCodeRepository;

    public String fetchDiscountCode(FetchRequest request) {
        log.info("Fetching a discount code from database");
        DiscountCode discountCode = discountCodeRepository.findFirstByCompanyIdAndAvailableTrue(request.getCompanyId());
        if(discountCode == null){
            log.info("No discount code is available");
            return null;
        }
        log.info("Fetched the discount code from database");

        log.info("Making the discount code unavailable");
        discountCode.setAvailable(false);
        discountCodeRepository.save(discountCode);

        return discountCode.getCode();
    }
}
