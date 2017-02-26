package main;

/**
 * Created by Abhinav on 14-02-2017.
 */
public abstract class Table {
    int id;
    int cap;
    TableType type;

  /*Table(int id, int cap) {
        this.id = id;
        this.cap = cap;
     }*/

    public int getId() {
        return id;
    }

    public int getCap() {
        return cap;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Table)) return false;

        Table table = (Table) o;

        //if (getId() != table.getId()) return false;
        //if (getCap() != table.getCap()) return false;
        return type == table.type;

    }

    @Override
    public int hashCode() {
        int result = 31*type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", cap=" + cap +
                ", type=" + type +
                '}';
    }
}
