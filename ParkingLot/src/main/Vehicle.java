package main;

import java.util.ArrayList;

/**
 * Created by Abhinav on 14-02-2017.
 */
public abstract class Vehicle {
    //protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<>();
    protected VehicleSize size;
    String licensePlate;
    protected int spotsNeeded;

    public VehicleSize getSize() {
        return size;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public abstract boolean canFit(ParkingSpot spot);

    //public void parkInSpot(ParkingSpot parkingSpot) {
    //    parkingSpots.add(parkingSpot);
    //}
    public void clearSpots(){

    }

    public abstract void print();
}
