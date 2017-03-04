package main.java;

/**
 * Created by Abhinav on 04-03-2017.
 */
public class Solution {
    public static void main(String[] args) {

        MyMap<Integer, Integer> map = new MyMap<>(10);
        map.put(5,15);
        map.put(6, 20);
        map.put(16, 21);
        map.put(11, 25);
        map.put(1, 26);
        map.put(1, 27);
        map.put(4, 18);
        map.put(9, 1);
        map.put(7, 8);
        map.put(17, 28);
        //System.out.println(map.get(16));
        //System.out.println(map.toString());
        System.out.println("Initial Map : ");
        map.printMap();
        int keyToRemove = 1;
        System.out.println("Removing entry with key " + keyToRemove);
        map.remove(keyToRemove);
        System.out.println("After Removing entry with key " + keyToRemove);
        map.printMap();

        keyToRemove = 11;
        System.out.println("Removing entry with key " + keyToRemove);
        map.remove(keyToRemove);
        System.out.println("After Removing entry with key " + keyToRemove);
        map.printMap();

        int keyToAddd = 101;
        System.out.println("After adding an entry with key " + keyToAddd);
        map.put(keyToAddd, 1);
        map.printMap();
    }
}
