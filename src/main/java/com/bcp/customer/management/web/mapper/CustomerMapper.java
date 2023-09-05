package com.bcp.customer.management.web.mapper;

import com.bcp.customer.management.domain.Customer;
import com.bcp.customer.management.web.contracts.CreateCustomerRequest;
import com.bcp.customer.management.web.contracts.CustomerResponse;
import com.bcp.customer.management.web.contracts.UpdateCustomerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel= "spring")
public interface CustomerMapper {
	CustomerMapper INSTANCE= Mappers.getMapper(CustomerMapper.class);
	Customer createRequestToEntity(CreateCustomerRequest source);
	Customer updateRequestToEntity(UpdateCustomerRequest source);
	@Mapping(target="customerTypeId", source="source.customerType.id")
	CustomerResponse entityToResponse(Customer source);
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget Customer entity, Customer updateEntity);
	
}
