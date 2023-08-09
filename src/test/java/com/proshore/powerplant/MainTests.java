package com.proshore.powerplant;

import com.proshore.powerplant.domain.model.Battery;
import com.proshore.powerplant.domain.model.BatteryResponse;
import com.proshore.powerplant.domain.ports.BatteryCreator;
import com.proshore.powerplant.domain.ports.BatteryFinder;
import com.proshore.powerplant.usecase.BatteryUsecase;
import com.proshore.powerplant.usecase.BatteryUsecaseInteractor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MainTests {

    private BatteryUsecase batteryUsecase;

    @Mock
    private BatteryFinder batteryFinder;

    @Mock
    private BatteryCreator batteryCreator;

    @BeforeEach
    void setup() {
        this.batteryUsecase = new BatteryUsecaseInteractor(batteryCreator, batteryFinder);
    }


    @Test
    public void testAddNewBattery() {
        Battery battery = new Battery();
        battery.setName("Armadale");
        battery.setId(1000L);
        battery.setCapacity(10000);
        battery.setPostcode("7000");

        when(batteryCreator.create(any(Battery.class))).thenReturn(battery);
        when(batteryFinder.findBattery(eq(1000L))).thenReturn(battery);

        Battery resultBattery = batteryUsecase.addNewBattery(battery);
        Battery actualResult = batteryUsecase.findBattery(battery.getId());

        assertNotNull(resultBattery);
        assertNotNull(actualResult);
        assertEquals(battery.getName(), actualResult.getName());
        assertEquals(battery.getPostcode(), actualResult.getPostcode());
        assertEquals(battery.getCapacity(), actualResult.getCapacity());

        verify(batteryCreator).create(battery);
        verify(batteryFinder).findBattery(eq(1000L));
    }

    @Test
    public void testFindAllBatteriesFromPostRange() {

        int from = 6000;
        int to = 7000;
        int page = 1;
        int pageSize = 10;

        Battery battery1 = new Battery();
        battery1.setName("A1");
        battery1.setId(100L);
        battery1.setPostcode("6500");
        battery1.setCapacity(10000);

        Battery battery2 = new Battery();
        battery2.setName("B1");
        battery1.setId(200L);
        battery1.setPostcode("7000");
        battery2.setCapacity(15000);

        double expectedAvg = 12500.00;

        List<Battery> batteries = List.of(battery1, battery2);

        when(batteryFinder.findAllBatteriesFromPostRange(from, to, page, pageSize)).thenReturn(batteries);

        BatteryResponse result = batteryUsecase.findAllBatteriesFromPostRange(from, to, page, pageSize);

        assertEquals(2, result.getBatteries().size());
        assertEquals(25000, result.getTotalCapacity());
        assertEquals(expectedAvg, result.getAvgCapacity());

        verify(batteryFinder).findAllBatteriesFromPostRange(from,to,page,pageSize);
    }

}
