package com.proshore.powerplant.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Battery {
    private Long id;
    private String name;
    private String postcode;
    private long capacity;
}
