package com.acme.discountcodeservice.generator;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api
@RestController
@RequestMapping("/generate")
@Slf4j
public class GeneratorController {

    @Autowired
    GeneratorService codeGeneratingService;

    @PostMapping
    @ApiOperation(value = "Create new discount codes with the amount specific in the request.", response = String.class)
    public List<String> generateCode(@RequestBody GenerateRequest request) {
        log.info(request.toString());
        return codeGeneratingService.generate(request);
    }
}
