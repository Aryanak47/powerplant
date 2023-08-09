package com.proshore.powerplant.adapter.database.entity;

import com.proshore.powerplant.domain.model.Battery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "battery")
public class BatteryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String postcode;
    private long capacity;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostcode() {
        return postcode;
    }

    public long getCapacity() {
        return capacity;
    }

    public static   BatteryEntity from(Battery battery){
        return BatteryEntity.builder()
                .name(battery.getName())
                .postcode(battery.getPostcode())
                .capacity(battery.getCapacity())
                .build();
    }
    public  Battery to(){
        return Battery.builder()
                .id(this.getId())
                .name(this.getName())
                .postcode(this.getPostcode())
                .capacity(this.getCapacity())
                .build();
    }
}
