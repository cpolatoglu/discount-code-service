package com.acme.discountcodeservice.fetcher;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fetch")
@Slf4j
public class FetcherController {

    @PostMapping
    public String fetchDiscountCode(@RequestBody FetchRequest request){
        log.info(request.toString());
        return "Here comes the code!";
    }
}
