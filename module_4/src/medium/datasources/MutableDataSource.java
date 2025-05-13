package medium.datasources;

public interface MutableDataSource<T> extends DataSource<T> {
    void saveData(T t);
}
