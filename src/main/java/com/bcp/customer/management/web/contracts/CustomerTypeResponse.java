package com.bcp.customer.management.web.contracts;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class CustomerTypeResponse {

    private String id;

    private String type;

    private String profile;

    private String segment;

    private String subsegment;
}
