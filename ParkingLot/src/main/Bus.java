package main;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class Bus extends Vehicle{

    public Bus(){
        size = VehicleSize.Large;
        spotsNeeded = 5;
    }
    @Override
    public boolean canFit(ParkingSpot spot) {
        return spot.getSpotSize() == size;
    }

    @Override
    public void print() {
        System.out.print("Tying parking a Bus ");
    }
}
