package com.proshore.powerplant.usecase;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.BatteryResponse;
import com.proshore.powerplant.domain.ports.BatteryCreator;
import com.proshore.powerplant.domain.ports.BatteryFinder;
import com.proshore.powerplant.usecase.exception.BadRequestException;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

@Service
public class BatteryUsecaseInteractor implements BatteryUsecase {
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
    public Battery findBattery(Long id) {
        return batteryFinder.findBattery(id);
    }

    @Override
    public List<Battery> findAllBatteries() {
        return batteryFinder.findAllBatteries();
    }

    @Override
    public BatteryResponse findAllBatteriesFromPostRange(int from, int to, int page, int pageSize) {
        var batteries = batteryFinder.findAllBatteriesFromPostRange(from, to, page, pageSize);
        long totalCapacity = batteries.stream()
                .map(Battery::getCapacity)
                .mapToLong(Long::longValue)
                .reduce(0L, Long::sum);
        double avg = 0.0;
        DecimalFormat format = new DecimalFormat("0.00");
        if (totalCapacity > 0)
            avg = Double.parseDouble(format.format((double) totalCapacity / batteries.size()));
        return BatteryResponse.builder()
                .batteries(batteries)
                .totalCapacity(totalCapacity)
                .avgCapacity(avg)
                .build();
    }

    private void validBattery(final Battery battery) {
        if (StringUtils.isEmpty(battery.getName()))
            throw new BadRequestException("Name is missing.Please provide name.");
        if (StringUtils.isEmpty(battery.getPostcode()))
            throw new BadRequestException("Postcode is missing.Please provide postcode.");
    }
}
