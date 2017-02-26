package main;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class Car extends Vehicle {

    public Car() {
        size = VehicleSize.Compact;
        spotsNeeded = 1;
    }

    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }

    @Override
    public void print() {
        System.out.print("Tying parking a Car ");
    }
}
