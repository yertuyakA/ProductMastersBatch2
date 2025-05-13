package medium.datasources;

import java.util.List;

public interface DataSource<T> {
    List<T> getAllData();
}
