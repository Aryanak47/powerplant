package com.proshore.powerplant.usecase;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.BatteryResponse;

import java.util.List;

public interface BatteryUsecase {
     Battery addNewBattery(Battery battery);
     Battery findBattery(String id);
     List<Battery> findAllBatteries();
     BatteryResponse findAllBatteriesFromPostRange(int from, int to, int page , int pageSize);
}
