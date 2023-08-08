package com.proshore.powerplant.domain.ports;

import com.proshore.powerplant.domain.model.Battery;

import java.util.List;

public interface BatteryFinder {
    public Battery findBattery(String id);

    public List<Battery> findAllBatteries(int limit);

    public List<Battery> findAllBatteriesFromPostRange(int from, int to, int limit);

}
