package com.proshore.powerplant.adapter.service;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.ports.BatteryCreator;
import com.proshore.powerplant.domain.ports.BatteryFinder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryPersistanceAdapter implements BatteryCreator, BatteryFinder {
    
    
    @Override
    public Battery create(Battery sender) {
        return null;
    }

    @Override
    public Battery findBattery(String id) {
        return null;
    }

    @Override
    public List<Battery> findAllBatteries(int limit) {
        return null;
    }

    @Override
    public List<Battery> findAllBatteriesFromPostRange(int from, int to, int limit) {
        return null;
    }
}
