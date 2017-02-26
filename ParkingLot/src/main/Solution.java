package main;

import java.util.Random;

/**
 * Created by Abhinav on 15-02-2017.
 */
public class Solution {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot();
        Random rand = new Random();
        Vehicle vehicle = null;
        while(vehicle == null || parkingLot.parkVehicle(vehicle)){
            int r = rand.nextInt(10);
            if(r < 2){
                vehicle = new Bus();
            } else if(r < 4){
                vehicle = new MotorCycle();
            } else {
                vehicle = new Car();
            }
            vehicle.print();
            //System.out.println("");
        }
    }
}
