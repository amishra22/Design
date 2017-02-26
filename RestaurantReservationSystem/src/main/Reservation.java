package main;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by Abhinav on 25-02-2017.
 */
public class Reservation {

    public static void main(String[] args){

        Restaurant restaurant = new Restaurant();

        Random rand = new Random();
        int size = rand.nextInt(10) + 1;
        Set<Integer> set = new HashSet<>();
        int id = rand.nextInt(100);
        Customer c = new Customer(id, size);
        while(restaurant.bookTable(c)) {
            set.add(c.getCust_id());
            id = rand.nextInt(100);
            while(set.contains(id)) {
                id = rand.nextInt(100);
            }
            c = new Customer(id, rand.nextInt(10)+1);
        }

        restaurant.printDetails();

    }
}
