/**
 * Created by Abhinav on 28-02-2017.
 */
public class File extends Entity {

    private String content;
    private int size;

    File(String name, Directory parent, int size) {
        super(name, parent);
        this.size = size;
    }


    @Override
    public int size() {
        return size;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
