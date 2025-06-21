package seven.managers;

import java.io.*;
import java.util.List;

public interface FileManager {

    default <T> void saveObjectsToFile(List<T> o, String fileName) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileName + ".ser"))) {
            ous.writeObject(o);
            System.out.println("Posts saved to a file.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    default <T> List<T> loadObjectsFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName + ".ser"))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to load posts: " + e.getMessage());
            return null;
        }
    }
}
