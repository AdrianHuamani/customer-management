package com.bcp.customer.management.web.contracts;

import com.bcp.customer.management.domain.CustomerType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CreateCustomerRequest {

    @NotBlank(message="documentDescription cannot be null or empty")
    private String documentDescription;

    @NotBlank(message="documentCode cannot be null or empty")
    private String documentCode;

    private CustomerType customerType;

    @NotBlank(message="name cannot be null or empty")
    private String name;

    private String lastName;

    private LocalDate birthDate;

    @NotBlank(message="birthDate cannot be null or empty")
    private String nationality;

    @NotBlank(message="gender cannot be null or empty")
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
