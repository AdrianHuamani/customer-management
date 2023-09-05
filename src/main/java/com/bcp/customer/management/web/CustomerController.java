package com.bcp.customer.management.web;

import com.bcp.customer.management.service.CustomerService;
import com.bcp.customer.management.web.contracts.CreateCustomerRequest;
import com.bcp.customer.management.web.contracts.CustomerResponse;
import com.bcp.customer.management.web.mapper.CustomerMapper;
import com.bcp.customer.management.web.routes.ApiRoutes;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Single;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRoutes.uriBaseCustomer)
@Tag(name = "CUSTOMER", description = "customer controller")
public class CustomerController {

    private final CustomerService customerService;

    private final CustomerMapper customerMapper;

    @GetMapping
    public Maybe<ResponseEntity<Flowable<CustomerResponse>>> findAll() {
        log.info("Find All Customer Type Controller executed");
        return customerService.findAll().share()
                .isEmpty()
                .flatMapMaybe(isEmpty -> {
                    if (isEmpty) {
                        return Maybe.just(ResponseEntity.noContent().build());
                    } else {
                        return Maybe.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                                .body(customerService.findAll().map(customerMapper::entityToResponse)));
                    }
                });
    }

    @PostMapping
    public Single<ResponseEntity<CustomerResponse>> save(@Valid @RequestBody CreateCustomerRequest customerModel,
                                                   final ServerHttpRequest req) {
        log.info("Save executed : " + customerModel.toString());

        return customerService.save(customerMapper.createRequestToEntity(customerModel))
                .map(customerEntity->ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(customerEntity.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customerMapper.entityToResponse(customerEntity)));


    }



}
