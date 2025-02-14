package medium;

public class MyDataCloudDataSource implements DataSource<MyData> {
    @Override
    public MyData getData() {
        return new MyData(1, "Описание один");
    }

}
