package com.bcp.customer.management.service;

import com.bcp.customer.management.domain.CustomerType;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;

public interface CustomerTypeService {
    Flowable<CustomerType> findAll();
    Maybe<CustomerType> findById(String id);
    Completable delete(String id);
    Single<CustomerType> save(CustomerType documentType);
}
