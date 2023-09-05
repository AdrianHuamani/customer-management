package com.bcp.customer.management.web.contracts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerResponse {

    private String id;

    private String internalCode;

    private String documentDescription;

    private String documentCode;

    private String customerTypeId;

    private String name;

    private String lastName;

    private LocalDate birthDate;

    private String nationality;

    private String gender;

    private Boolean resident;

    private String civilStatus;

    private String instruction;

    private List<String> cellPhones;

    private List< @Email String> emails;

    private String location;

    private String direction;

    private Boolean employee;

    private String codeAgency;

}
