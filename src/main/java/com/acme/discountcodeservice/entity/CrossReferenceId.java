package com.acme.discountcodeservice.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode
public class CrossReferenceId implements Serializable {
    private Long customerId;
    private Long companyId;
    private String discountCode;
}
