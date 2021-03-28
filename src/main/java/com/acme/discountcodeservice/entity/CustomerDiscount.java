package com.acme.discountcodeservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Data
@Entity
@IdClass(CrossReferenceId.class)
public class CustomerDiscount {

    @Id
    private Long customerId;

    @Id
    private Long companyId;

    @Id
    private String discountCode;
}
