package lesson;

public class Repository<T> implements DataSource<T> {
    private final MutableDataSource<T> cachedDataSource;
    private final DataSource<T> cloudDataSource;

    public Repository(MutableDataSource<T> cachedDataSource, DataSource<T> cloudDataSource) {
        this.cachedDataSource = cachedDataSource;
        this.cloudDataSource = cloudDataSource;
    }

    @Override
    public T getData() {
        T result = cachedDataSource.getData();
        if (result == null) {
            System.out.println("В кэше нет данных");
            result = cloudDataSource.getData();
            cachedDataSource.saveData(result);
        } else {
            System.out.println("Данные были взяты из кэша");
        }
        return result;
    }

}
