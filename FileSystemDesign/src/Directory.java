import java.util.ArrayList;
import java.util.List;

/**
 * Created by Abhinav on 28-02-2017.
 */
public class Directory extends Entity {

    protected List<Entity> content;

    Directory(String name, Directory parent) {
        super(name, parent);
        content = new ArrayList<>();
    }

    @Override
    public int size(){
        int size = 0;
        for(Entity e : content) {
            size += e.size();
        }
        return size;
    }

    public void addEntry(Entity e) {
        content.add(e);
    }


}
