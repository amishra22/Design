package main;

import java.util.*;

/**
 * Created by Abhinav on 25-02-2017.
 */
public class Restaurant {

    HashMap<TableType, Queue<Table>> map;
    List<Customer> customers;
    final int BIG_SIZE_TABLE=10;
    final int MED_SIZE_TABLE=10;
    final int SMALL_SIZE_TABLE=10;
    final int LARGE_CAP = 10;
    final int MED_CAP = 6;
    final int SMALL_CAP = 4;

    Restaurant(){
        map = new HashMap<>();
        customers = new ArrayList<>();

        for(int i=0; i<BIG_SIZE_TABLE; i++){
            TableType tableType = TableType.getTypeFromId("L");
            if(!map.containsKey(tableType)) {
                Queue<Table> queue = new LinkedList<>();
                Table t = new LargeTable(i, LARGE_CAP, tableType);
                queue.add(t);
                map.put(tableType, queue);
            } else {
                Table t = new LargeTable(i, LARGE_CAP, tableType);
                map.put(tableType, map.get(tableType)).add(t);
            }
        }


        for(int i=BIG_SIZE_TABLE; i<BIG_SIZE_TABLE+MED_SIZE_TABLE; i++){
            TableType tableType = TableType.getTypeFromId("M");
            if(!map.containsKey(tableType)) {
                Queue<Table> queue = new LinkedList<>();
                Table t = new LargeTable(i, MED_CAP, tableType);
                queue.add(t);
                map.put(tableType, queue);
            } else {
                Table t = new LargeTable(i, MED_CAP, tableType);
                map.put(tableType, map.get(tableType)).add(t);
            }
        }



        for(int i=BIG_SIZE_TABLE+MED_SIZE_TABLE; i<BIG_SIZE_TABLE+MED_SIZE_TABLE+SMALL_SIZE_TABLE; i++){
            TableType tableType = TableType.getTypeFromId("S");
            if(!map.containsKey(tableType)) {
                Queue<Table> queue = new LinkedList<>();
                Table t = new LargeTable(i, SMALL_CAP, tableType);
                queue.add(t);
                map.put(tableType, queue);
            } else {
                Table t = new LargeTable(i, SMALL_CAP, tableType);
                map.put(tableType, map.get(tableType)).add(t);
            }
        }
        //System.out.println("Map is " + map.toString());
    }

    public boolean bookTable(Customer c) {
        System.out.println("Looking for a table for customer with id " + c.getCust_id() + " and size " + c.getSize());
        int minSize = c.getSize();
        TableType lType = TableType.getTypeFromId("L");
        TableType mType = TableType.getTypeFromId("M");
        TableType sType = TableType.getTypeFromId("S");


        if(minSize > LARGE_CAP) {
            return false;
        } else if(minSize > MED_CAP) {
            Table table = checkAvailable(lType);
            if(table != null ) {
                c.assignTable(table);
                customers.add(c);
                System.out.println("Found a table " + table.toString());
                return true;
            }
        } else if(minSize > SMALL_CAP) {
            Table table = checkAvailable(mType);
            if(table != null) {
                c.assignTable(table);
                customers.add(c);
                System.out.println("Found a table " + table.toString());
                return true;
            } else {
                table = checkAvailable(lType);
                if(table != null) {
                    c.assignTable(table);
                    customers.add(c);
                    System.out.println("Found a table " + table.toString());
                    return true;
                }
            }
        } else {
            Table table = checkAvailable(sType);
            if(table != null) {
                c.assignTable(table);
                customers.add(c);
                System.out.println("Found a table " + table.toString());
                return true;
            } else {
                table = checkAvailable(mType);
                if(table != null) {
                    c.assignTable(table);
                    customers.add(c);
                    System.out.println("Found a table " + table.toString());
                    return true;
                } else {
                    table = checkAvailable(sType);
                    if(table != null) {
                        c.assignTable(table);
                        customers.add(c);
                        System.out.println("Found a table " + table.toString());
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private Table checkAvailable(TableType tableType) {

        if(!map.containsKey(tableType)) {
            return null;
        } else {
            Queue<Table> queue = map.get(tableType);
            if(!queue.isEmpty()) {
                return queue.poll();
            }
        }
        return null;
    }

    public void printDetails() {
        for(Customer c : customers) {
            System.out.println(c.toString());
        }
    }

}
