package com.proshore.powerplant.domain.ports;

import com.proshore.powerplant.domain.model.Battery;

public interface BatteryCreator {
    Battery create(Battery battery);
}
