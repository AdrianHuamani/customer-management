package com.bcp.customer.management.service.impl;

import com.bcp.customer.management.domain.Customer;
import com.bcp.customer.management.repository.CustomerRepository;
import com.bcp.customer.management.repository.CustomerTypeRepository;
import com.bcp.customer.management.service.CustomerService;
import com.bcp.customer.management.web.mapper.CustomerMapper;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerTypeRepository customerTypeRepository;

    private final CustomerMapper customerMapper;

    @Override
    public Flowable<Customer> findAll() {
        log.debug("findAll executed");
        return customerRepository.findAll();
    }

    @Override
    public Maybe<Customer> findById(String id) {
        log.debug("findById executed {}", id);
        return customerRepository.findById(id);
    }

    @Override
    public Completable delete(String id) {
        log.debug("delete executed {}", id);
        return customerRepository.deleteById(id);
    }
    @Override
    public Single<Customer> save(Customer documentType) {
        log.debug("create executed {}", documentType);
        documentType.setUserCreationId(System.getProperty("user.name"));
        documentType.setCreationDateOnUtc(Instant.now());
        return customerRepository.save(documentType);
    }

}
