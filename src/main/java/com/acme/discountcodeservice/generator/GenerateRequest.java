package com.acme.discountcodeservice.generator;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Request model to generate discount codes")
public class GenerateRequest {
    @ApiModelProperty("ID of a company that is creating discount codes.")
    long companyId;

    @ApiModelProperty("Defines how many codes shall be created.")
    int numberOfCodes;

    @ApiModelProperty("Defines the amount of the discount. A number between 1-100 shall be used if the isPercentage is true.")
    int discountAmount;

    @ApiModelProperty("Defines whether the discount is percentage based or not.")
    boolean isPercentage;
}
