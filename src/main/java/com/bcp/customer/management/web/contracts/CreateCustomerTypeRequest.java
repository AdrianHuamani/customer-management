package com.bcp.customer.management.web.contracts;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CreateCustomerTypeRequest {

    @NotNull
    private String type;

    @NotNull
    private String profile;

    @NotNull
    private String segment;

    @NotNull
    private String subsegment;

}
