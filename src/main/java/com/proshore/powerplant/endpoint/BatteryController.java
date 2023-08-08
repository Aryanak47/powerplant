package com.proshore.powerplant.endpoint;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.usecase.BatteryUsecase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/battery")
public class BatteryController {

    private final BatteryUsecase batteryUsecase;

    @Autowired
    public BatteryController(BatteryUsecase batteryUsecase) {
        this.batteryUsecase = batteryUsecase;
    }

    @PostMapping
    public Battery saveBattery(@RequestBody Battery battery){
        return batteryUsecase.addNewBattery(battery);
    }

    @GetMapping("/all")
    public List<Battery> getBatteries(@RequestParam int limit ){
        return batteryUsecase.findAllBatteries(limit);
    }

    @GetMapping("/all/range")
    public List<Battery> getBatteriesFromPostcodeRange(@RequestParam int from, @RequestParam Integer to, @RequestParam Integer limit){
        return batteryUsecase.findAllBatteriesFromPostRange(from, to, limit);
    }

}
