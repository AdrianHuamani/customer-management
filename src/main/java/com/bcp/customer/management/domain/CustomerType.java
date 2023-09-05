package com.bcp.customer.management.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Document(collection = "customerTypes")
public class CustomerType extends AuditableEntity {
	
    @Id
    private String id;

    @NotNull
    private String type;

    @NotNull
    private String profile;

    @NotNull
    private String segment;

    @NotNull
    private String subsegment;


}
