package com.acme.discountcodeservice.fetcher;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Request model to fetch discount codes")
public class FetchRequest {
    @ApiModelProperty("ID of the company that the discount code shall be fetched.")
    private long companyId;

    @ApiModelProperty("First name of the customer.")
    private String firstName;

    @ApiModelProperty("Last name of the customer")
    private String lastName;

    @ApiModelProperty("Email address of the customer")
    private String email;

    @ApiModelProperty("Last name of the customer")
    private String phone;
}
