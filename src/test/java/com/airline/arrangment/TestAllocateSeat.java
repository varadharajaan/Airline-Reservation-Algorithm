package com.airline.arrangment;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

/**
 * @Author Varadharajan on 26/05/20 00:43
 * @Projectname Airline_Arrangement
 */

@RunWith(BlockJUnit4ClassRunner.class)
public class TestAllocateSeat {

    AirlineUtils airlineUtils;

    @Before
    public  void setup() {
        airlineUtils = new AirlineUtils();
    }

    @Test
    public void checkNormalFlow() {

        String seats = "[[3,2],[4,3],[2,3],[3,4]]";
        int passengersCount = 30;
        airlineUtils.allocateSeats(seats,passengersCount);

    }

    @Test(expected = RuntimeException.class)
    public void checkExceptionFlow() {

        String seats = "[[s,2],[4,3],[2,3],[3,4]]";
        int passengersCount = 30;
        airlineUtils.allocateSeats(seats,passengersCount);

    }


}
