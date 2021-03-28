package com.acme.discountcodeservice.fetcher;

import com.acme.discountcodeservice.entity.Customer;
import com.acme.discountcodeservice.entity.CustomerDiscount;
import com.acme.discountcodeservice.entity.DiscountCode;
import com.acme.discountcodeservice.repository.CustomerDiscountRepository;
import com.acme.discountcodeservice.repository.CustomerRepository;
import com.acme.discountcodeservice.repository.DiscountCodeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FetcherService {

    @Autowired
    DiscountCodeRepository discountCodeRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CustomerDiscountRepository customerDiscountRepository;

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


        log.info("Saving customer information");
        Customer customer = new Customer();
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setPhone(request.getPhone());
        customerRepository.save(customer);

        // According to my design this should be a kafka message but I don't have much time to complete with Kafka producer
        // So, for now I am saving to DB. A new endpoint can be exposed to use this information or Kafka producer can read it from here
        log.info("Saving the customer discount mapping for future use");
        CustomerDiscount customerDiscount = new CustomerDiscount();
        customerDiscount.setDiscountCode(discountCode.getCode());
        customerDiscount.setCustomerId(customer.getId());
        customerDiscount.setCompanyId(request.getCompanyId());
        customerDiscountRepository.save(customerDiscount);

        return discountCode.getCode();
    }
}
