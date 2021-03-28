package com.acme.discountcodeservice.repository;

import com.acme.discountcodeservice.entity.CrossReferenceId;
import com.acme.discountcodeservice.entity.CustomerDiscount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDiscountRepository extends JpaRepository<CustomerDiscount, CrossReferenceId> {
}
