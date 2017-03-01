/**
 * Created by Abhinav on 27-02-2017.
 */
public abstract class Entity {

    protected Directory parent;
    protected String name;
    protected long creationTime;
    protected long lastUpdated;


    Entity(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.creationTime = System.currentTimeMillis();
    }

    public long getCreationTime(){
        return creationTime;
    }

    public abstract int size();

    public String getFullPath(){
        if(parent == null) {
            return name;
        } else {
            return parent.getFullPath() + "/" + name;
        }
    }

    public long getLastUpdated(){
        return lastUpdated;
    }

    public void changeName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }


}
