package main;

import javafx.scene.control.Tab;

/**
 * Created by Abhinav on 25-02-2017.
 */
public enum TableType {
    LARGE("L"), MED("M"), SMALL("S");
    String id;

    TableType(String id){
        this.id = id;
    }

    public static TableType getTypeFromId(String id) {
        switch (id) {
            case "L" :
                //System.out.println("Type Large");
                return TableType.LARGE;
            case "M" :
                //System.out.println("Type Medium");
                return TableType.MED;
            case "S" :
                //System.out.println("Type Small");
                return  TableType.SMALL;
            default:
                return null;
        }
    }


}
