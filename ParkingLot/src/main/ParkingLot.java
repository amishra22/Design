package main;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class ParkingLot {
    private Level[] levels;
    private final int NUM_LEVELS = 5;

    ParkingLot(){
        levels = new Level[NUM_LEVELS];
        for(int i=0; i < NUM_LEVELS; i++) {
            // 20 spots on each level
            levels[i] = new Level(i, 20);
        }
    }

    public boolean parkVehicle(Vehicle v){
        for(int i=0; i<NUM_LEVELS; i++){
            if(levels[i].parkVehicle(v)) {
                System.out.println(" level " + i);
                return true;
            }
        }
        return false;
    }
}
