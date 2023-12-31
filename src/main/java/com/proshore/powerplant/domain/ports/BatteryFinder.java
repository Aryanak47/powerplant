package com.proshore.powerplant.domain.ports;

import com.proshore.powerplant.domain.model.Battery;

import java.util.List;

public interface BatteryFinder {
    public Battery findBattery(Long id);

    public List<Battery> findAllBatteries();

    public List<Battery> findAllBatteriesFromPostRange(int from, int to, int page , int pageSize);

}
