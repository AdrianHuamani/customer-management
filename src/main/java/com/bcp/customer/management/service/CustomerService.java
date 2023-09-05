package com.bcp.customer.management.service;

import com.bcp.customer.management.domain.Customer;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface CustomerService {
    Flowable<Customer> findAll();
    Maybe<Customer> findById(String id);
    Completable delete(String id);
    Single<Customer> save(Customer documentType);
}
