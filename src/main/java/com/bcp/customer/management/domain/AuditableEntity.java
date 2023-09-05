package com.bcp.customer.management.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class AuditableEntity {
    @NotNull
    private Instant creationDateOnUtc;
    private Instant modifiedDateOnUtc;
    @NotNull
    private String userCreationId;
    private String userUpdateId;
}
