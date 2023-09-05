package com.bcp.customer.management.web.contracts;

import com.bcp.customer.management.domain.CustomerType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class UpdateCustomerRequest {

    private String documentDescription;

    private String documentCode;

    private CustomerType customerType;

    private Boolean resident;

    private String civilStatus;

    private String instruction;

    private List<String> cellPhones;

    private List< @Email String> emails;

    private String location;

    private String direction;

    private Boolean employee;

}
