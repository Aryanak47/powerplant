package com.proshore.powerplant.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BatteryResponse {
    private List<Battery> batteries;
    private long totalCapacity;
    private double avgCapacity;
}
