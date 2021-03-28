package com.acme.discountcodeservice.fetcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fetch")
@Slf4j
public class FetcherController {

    @Autowired
    FetcherService discountCodeFetcherService;

    @PostMapping
    public String fetchDiscountCode(@RequestBody FetchRequest request){
        log.info(request.toString());
        return discountCodeFetcherService.fetchDiscountCode(request);
    }
}
