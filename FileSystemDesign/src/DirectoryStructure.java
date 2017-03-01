/**
 * Created by Abhinav on 28-02-2017.
 */
public class DirectoryStructure {

    public static void main(String[] args) {

        Directory root = new Directory("Eatables", null);
            Directory dir1_1 = new Directory("Fruit", root);
            Directory dir1_2 = new Directory("Veggie", root);
            File f1 = new File("details.txt", root, 10);
            root.addEntry(f1);

                Directory dir1_1_1 = new Directory("Citrus", dir1_1);
                    File f1_1_1 = new File("Oranges.txt", dir1_1_1, 20);
                    File f1_1_2 = new File("Maushami.txt", dir1_1_1, 25);
                dir1_1_1.addEntry(f1_1_1);
                dir1_1_1.addEntry(f1_1_2);

                dir1_1.addEntry(dir1_1_1);


                Directory dir1_1_2 = new Directory("Non-Citrus", dir1_1);
                    File f1_1_21 = new File("Banana", dir1_1_2, 15);
                    File f1_1_22 = new File("Apple", dir1_1_2, 10);

                dir1_1_2.addEntry(f1_1_21);
                dir1_1_2.addEntry(f1_1_22);

                dir1_1.addEntry(dir1_1_2);

                Directory dir1_2_1 = new Directory("Test1", dir1_2);
                    File f1_2_1 = new File("Onion", dir1_2_1, 20);

                dir1_2_1.addEntry(f1_2_1);
                dir1_2.addEntry(dir1_2_1);

            root.addEntry(dir1_1);
            root.addEntry(dir1_2);

        System.out.println(dir1_2_1.getFullPath());
    }
}
