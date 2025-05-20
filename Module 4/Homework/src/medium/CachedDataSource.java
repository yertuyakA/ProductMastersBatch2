package medium;

public class CachedDataSource<T> implements MutableDataSource<T> {
    private T myData;

    @Override
    public T getData() {
        return myData;
    }

    @Override
    public void saveData(T myData) {
        this.myData = myData;
    }
}
