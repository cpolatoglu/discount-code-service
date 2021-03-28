package com.acme.discountcodeservice.fetcher;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
    @ApiOperation(value = "Fetch the first available discount code from the company specified in the request", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success. Discount code is available."),
            @ApiResponse(code = 204, message = "No discount code is available")}
    )
    public String fetchDiscountCode(@RequestBody FetchRequest request, HttpServletResponse response) {
        log.info(request.toString());
        String code = discountCodeFetcherService.fetchDiscountCode(request);
        if (code == null) {
            log.info("No discount code is available. Returning 204 (NO_CONTENT)");
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        return code;
    }
}
