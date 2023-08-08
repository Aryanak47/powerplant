package com.proshore.powerplant.usecase;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.ports.BatteryCreator;
import com.proshore.powerplant.domain.ports.BatteryFinder;
import com.proshore.powerplant.usecase.exception.BadRequestException;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatteryUsecaseInteractor implements BatteryUsecase{

    private final BatteryFinder batteryFinder;

    private final BatteryCreator batteryCreator;

    @Autowired
    public BatteryUsecaseInteractor(BatteryCreator batteryCreator, BatteryFinder batteryFinder) {
        this.batteryCreator = batteryCreator;
        this.batteryFinder = batteryFinder;
    }

    @Override
    public Battery addNewBattery(Battery battery) {
        validBattery(battery);
        return batteryCreator.create(battery);
    }


    @Override
    public Battery findBattery(String id) {
        return batteryFinder.findBattery(id);
    }

    @Override
    public List<Battery> findAllBatteries(int limit) {
        return batteryFinder.findAllBatteries(limit);
    }

    @Override
    public List<Battery> findAllBatteriesFromPostRange(int from, int to, int limit) {
        return batteryFinder.findAllBatteriesFromPostRange(from, to, limit);
    }

    private void validBattery(final Battery battery) {
        if (StringUtils.isEmpty(battery.getName())) throw new BadRequestException("Name is missing.Please provide name.");
        if (StringUtils.isEmpty(battery.getPostcode())) throw new BadRequestException("Postcode is missing.Please provide postcode.");
    }
}
