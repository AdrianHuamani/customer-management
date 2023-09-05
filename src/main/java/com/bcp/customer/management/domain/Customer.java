package com.bcp.customer.management.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "customers")
public class Customer extends AuditableEntity{

	@Id
	private String id;
	
	@Indexed(unique=true)
	private String internalCode;
	
	@NotNull
	private String documentDescription;
	
	@NotNull
	private String documentCode;
	
	@NotNull
	private CustomerType customerType;
	
	@NotNull
	private String name;
	
	@NotNull
	private String lastName;
	
	@NotNull
	private LocalDate birthDate;
	
	@NotNull
	private String nationality;
	
	@NotNull
	private String gender;
	
	@NotNull
	private Boolean resident;
	
	@NotNull
	private String civilStatus;
	
	@NotNull
	private String instruction;

	@NotNull
	private List<String> cellPhones;
	
	@NotNull
	private List<@Email String> emails;
	
	@NotNull
	private String location;
	
	@NotNull
	private String direction;
	
	@NotNull
	private Boolean employee;

	@NotNull
	private String codeAgency;

}
