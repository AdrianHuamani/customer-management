package com.bcp.customer.management.web.mapper;

import com.bcp.customer.management.domain.CustomerType;
import com.bcp.customer.management.web.contracts.CreateCustomerTypeRequest;
import com.bcp.customer.management.web.contracts.CustomerTypeResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel= "spring")
public interface CustomerTypeMapper {
	CustomerTypeMapper INSTANCE= Mappers.getMapper(CustomerTypeMapper.class);
	CustomerType createRequestToEntity(CreateCustomerTypeRequest source);
	
	CustomerTypeResponse entityToResponse(CustomerType source);
	@Mapping(target = "id", ignore = true)
	void update(@MappingTarget CustomerType entity, CustomerType updateEntity);
	
}
