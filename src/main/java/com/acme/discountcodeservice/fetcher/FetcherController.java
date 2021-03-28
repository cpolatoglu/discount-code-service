package com.acme.discountcodeservice.fetcher;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/fetch")
@Slf4j
public class FetcherController {

    @Autowired
    FetcherService discountCodeFetcherService;

    @PostMapping
    public String fetchDiscountCode(@RequestBody FetchRequest request, HttpServletResponse response){
        log.info(request.toString());
        String code = discountCodeFetcherService.fetchDiscountCode(request);
        if(code == null){
            log.info("No discount code is available. Returning 204 (NO_CONTENT)");
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return code;
    }
}
