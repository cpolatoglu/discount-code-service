package com.acme.discountcodeservice.generator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/generate")
public class GeneratorController {

    @PostMapping
    public void generateCode(@RequestBody GeneratorRequest request) {
        System.out.println("Request: " + request.toString());
    }
}
