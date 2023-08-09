package com.proshore.powerplant.endpoint;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.BatteryResponse;
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
    public List<Battery> getBatteries(){
        return batteryUsecase.findAllBatteries();
    }

    @GetMapping(path = "/{id}")
    public Battery getBatteries(@PathVariable Long id){
        return batteryUsecase.findBattery(id);
    }

    @GetMapping("/all/range")
    public BatteryResponse getBatteriesFromPostcodeRange(@RequestParam int from,
                                                         @RequestParam int to,
                                                         @RequestParam(defaultValue = "0" ) int  page,
                                                         @RequestParam(defaultValue = "10") int pageSize){
        return batteryUsecase.findAllBatteriesFromPostRange(from, to, page, pageSize);
    }

}
