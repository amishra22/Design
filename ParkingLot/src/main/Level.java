package main;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class Level {
    int level;
    private ParkingSpot[] spots;
    //private final int SPOTS_PER_ROW = 10;
    private int availableSpots = 0;
    private int carSpots;
    private int mcSpots;
    private int busSpots;

    public Level(int lvl, int numSpots) {
        this.level = lvl;
        spots = new ParkingSpot[numSpots];

        carSpots = numSpots/2;
        mcSpots = (2*(numSpots-carSpots))/3;
        busSpots = numSpots - carSpots - mcSpots;

        int i;
        for(i=0; i<carSpots; i++) {
            VehicleSize sz = VehicleSize.Compact;
            spots[i] = new ParkingSpot(this, i, sz);
        }
        while(i < carSpots + mcSpots){
            VehicleSize sz = VehicleSize.Motorcycle;
            spots[i] = new ParkingSpot(this, i, sz);
            i++;
        }
        while(i < numSpots){
            VehicleSize sz = VehicleSize.Large;
            spots[i] = new ParkingSpot(this, i, sz);
            i++;
        }
        availableSpots = numSpots;
    }

    public int getAvailableSpots(Vehicle v) {
        if(v.getSize().equals(VehicleSize.Compact)){
            return carSpots--;
        } else if(v.getSize().equals(VehicleSize.Motorcycle)) {
            return mcSpots--;
        } else if(v.getSize().equals(VehicleSize.Large)){
            return busSpots--;
        }
        return 0;
    }

    /*
    public void spotFree(ParkingSpot parkingSpot) {
        if(parkingSpot.getSpotSize() == VehicleSize.Compact){
            carSpots++;
        } else if(parkingSpot.getSpotSize() == VehicleSize.Large) {
            busSpots++;
        } else {
            mcSpots++;
        }
        //availableSpots++;
    }
    */

    public boolean parkVehicle(Vehicle v) {
        if(getAvailableSpots(v) > 0){
            if(findSpot(v)) {
                return true;
            }
        }
        return false;
    }

    private boolean findSpot(Vehicle v) {
        for(int i=0; i<spots.length; i++){
            ParkingSpot parkingSpot = spots[i];
            if(parkingSpot.getSpotSize().equals(v.getSize()) && parkingSpot.isAvailable()) {
                if(parkingSpot.park(v)){
                    System.out.print(" .. Found a spot number " + i + " at ");
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
