package com.proshore.powerplant.usecase;

import com.proshore.powerplant.domain.model.Battery;

import java.util.List;

public interface BatteryUsecase {
     Battery addNewBattery(Battery battery);
     Battery findBattery(String id);
     List<Battery> findAllBatteries(int limit);
     List<Battery> findAllBatteriesFromPostRange(int from, int to, int limit);
}
