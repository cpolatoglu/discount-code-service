package com.acme.discountcodeservice.fetcher;

import lombok.Data;

@Data
public class FetchRequest {
    private long companyId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
}
