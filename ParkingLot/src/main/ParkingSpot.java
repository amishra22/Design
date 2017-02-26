package main;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class ParkingSpot {
    private int spotNumber;
    private VehicleSize spotSize;
    private Level level;
    private Vehicle vehicle;

    public ParkingSpot(Level level, int spotNumber, VehicleSize sz) {
        this.level = level;
        this.spotNumber = spotNumber;
        this.spotSize = sz;
    }

    public boolean isAvailable(){
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v){
        return isAvailable() && v.canFit(this);
    }

    public boolean park(Vehicle v){
        if(!canFitVehicle(v)) {
            return  false;
        }
        vehicle = v;
        //v.parkInSpot(this);
        return true;
    }

    public void removeVehicle(){
        //level.spotFree(this);
        vehicle = null;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleSize getSpotSize() {
        return spotSize;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Level getLevel() {
        return level;
    }
}
