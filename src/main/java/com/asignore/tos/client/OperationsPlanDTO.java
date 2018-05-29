package com.asignore.tos.client;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OperationsPlanDTO {
    private String origin;
    private String destination;
    private String departure;
}
