package main;

/**
 * Created by Abhinav on 25-02-2017.
 */
public class Customer {

    private Table table;
    int cust_id;
    int size;

    Customer(int id, int size) {
        this.cust_id = id;
        this.size = size;
    }

    public void assignTable(Table table) {
        this.table = table;
    }

    public int getSize() {
        return size;
    }

    public Table getTable() {
        return table;
    }

    public int getCust_id() {
        return cust_id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "table=" + table +
                ", cust_id=" + cust_id +
                ", size=" + size +
                '}';
    }
}
