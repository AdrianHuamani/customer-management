package com.bcp.customer.management.service.impl;

import com.bcp.customer.management.domain.CustomerType;
import com.bcp.customer.management.repository.CustomerTypeRepository;
import com.bcp.customer.management.service.CustomerTypeService;
import com.bcp.customer.management.web.mapper.CustomerTypeMapper;
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
public class CustomerTypeServiceImpl implements CustomerTypeService {

    private final CustomerTypeRepository customerTypeRepository;

    private final CustomerTypeMapper customerTypeMapper;

    @Override
    public Flowable<CustomerType> findAll() {
        log.debug("findAll executed");
        return customerTypeRepository.findAll();
    }

    @Override
    public Maybe<CustomerType> findById(String id) {
        log.debug("findById executed {}", id);
        return customerTypeRepository.findById(id);
    }

    @Override
    public Completable delete(String id) {
        log.debug("delete executed {}", id);
        return customerTypeRepository.deleteById(id);
    }
    @Override
    public Single<CustomerType> save(CustomerType customerType) {
        log.debug("create executed {}", customerType);
        customerType.setUserCreationId(System.getProperty("user.name"));
        customerType.setCreationDateOnUtc(Instant.now());
        return customerTypeRepository.save(customerType);
    }

}
