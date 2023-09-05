package com.bcp.customer.management.web;

import com.bcp.customer.management.service.CustomerTypeService;
import com.bcp.customer.management.web.contracts.CreateCustomerTypeRequest;
import com.bcp.customer.management.web.contracts.CustomerTypeResponse;
import com.bcp.customer.management.web.mapper.CustomerTypeMapper;
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
@RequestMapping(ApiRoutes.uriBaseCustomerType)
@Tag(name = "CUSTOMER TYPE", description = "customer type controller")
public class CustomerTypeController {

    private final CustomerTypeService customerTypeService;

    private final CustomerTypeMapper customerTypeMapper;

    @GetMapping
    public Maybe<ResponseEntity<Flowable<CustomerTypeResponse>>> findAll() {
        log.info("Find All Customer Type Controller executed");
        return customerTypeService.findAll().share()
                .isEmpty()
                .flatMapMaybe(isEmpty -> {
                    if (isEmpty) {
                        return Maybe.just(ResponseEntity.noContent().build());
                    } else {
                        return Maybe.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                                .body(customerTypeService.findAll().map(customerTypeMapper::entityToResponse)));
                    }
                });
    }

    @PostMapping
    public Single<ResponseEntity<CustomerTypeResponse>> save(@Valid @RequestBody CreateCustomerTypeRequest customerTypeModel,
                                                   final ServerHttpRequest req) {
        log.info("Save executed : " + customerTypeModel.toString());

        return customerTypeService.save(customerTypeMapper.createRequestToEntity(customerTypeModel))
                .map(customerTypeEntity->ResponseEntity.created(URI.create(req.getURI().toString().concat("/").concat(customerTypeEntity.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(customerTypeMapper.entityToResponse(customerTypeEntity)));
    }



}
