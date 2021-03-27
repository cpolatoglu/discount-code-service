package com.acme.discountcodeservice.generator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/generate")
public class GeneratorController {

    @Autowired
    GeneratorService codeGeneratingService;

    @PostMapping
    public List<String> generateCode(@RequestBody GeneratorRequest request) {
        System.out.println("Request: " + request.toString());
        return codeGeneratingService.generate(request);
    }
}
