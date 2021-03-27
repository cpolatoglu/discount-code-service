package com.acme.discountcodeservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Company {

    @Id
    private Long id;
    private String companyName;
    private String website;
    private String contactInfo;
}
