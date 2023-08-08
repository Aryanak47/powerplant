package com.proshore.powerplant.adapter.database;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Battery {

    @Id
    private Long id;
    private String name;
    private String postcode;
    private int capacity;
}
