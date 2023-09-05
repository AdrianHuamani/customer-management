package com.bcp.customer.management.repository;

import com.bcp.customer.management.domain.Customer;
import io.reactivex.rxjava3.core.Maybe;

public interface CustomerRepository extends GenericRepository<Customer, String> {

    Maybe<Customer> findByInternalCode(String internalCode);
}
