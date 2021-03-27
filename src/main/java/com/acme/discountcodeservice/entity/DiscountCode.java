package com.acme.discountcodeservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class DiscountCode {
    @Id
    private Long id;
    private String code;
    private boolean available;
    private Long companyId;
}
