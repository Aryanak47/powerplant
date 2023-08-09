package com.proshore.powerplant.adapter.service;

import com.proshore.powerplant.adapter.database.entity.BatteryEntity;
import com.proshore.powerplant.adapter.database.repo.BatteryRepo;
import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.ports.BatteryCreator;
import com.proshore.powerplant.domain.ports.BatteryFinder;
import com.proshore.powerplant.usecase.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
class BatteryPersistanceAdapter implements BatteryCreator, BatteryFinder {

    @Autowired
    BatteryRepo batteryRepo;
    
    @Override
    public Battery create(Battery battery) {
        return batteryRepo.save(BatteryEntity.from(battery)).to();
    }

    @Override
    public Battery findBattery(String id) {
        return batteryRepo.findById(id).orElseThrow(()-> new BadRequestException("Invalid id")).to();
    }

    @Override
    public List<Battery> findAllBatteries() {
        return batteryRepo.findAll().stream().map(BatteryEntity::to).collect(Collectors.toList());
    }

    @Override
    public List<Battery> findAllBatteriesFromPostRange(int from, int to, int page , int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return batteryRepo.findAllByPostcodeRange(from, to, pageable).orElse(Collections.emptyList()).stream().map(BatteryEntity::to).collect(Collectors.toList());
    }
}
