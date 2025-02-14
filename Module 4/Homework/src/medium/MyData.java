package medium;

public class MyData {
    private final int id;
    private final String description;

    public MyData(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String toString() {
        return "medium.lesson.MyData: id = " + id + ", description = " + description;
    }
}
