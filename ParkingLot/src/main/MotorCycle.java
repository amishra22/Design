package main;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class MotorCycle extends Vehicle {

    public MotorCycle(){
        spotsNeeded = 1;
        size = VehicleSize.Motorcycle;
    }
    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }

    @Override
    public void print() {
        System.out.print("Tying parking a MotorCycle ");
    }
}
