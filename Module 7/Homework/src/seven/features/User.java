package seven.features;

import java.io.Serial;
import java.io.Serializable;

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int id;
    private static int NEXT_ID = 1;

    public User(String name) {
        this.name = name;
        this.id = NEXT_ID++;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return name;
    }
}
