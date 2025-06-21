package medium;

public class Main {
    public static void main(String[] args) {
        DataSource<MyData> myDataDataSource = new Repository<>(
                new CachedDataSource<>(), new MyDataCloudDataSource());

        DataSource<GeoData> geoDataDataSource = new GeoRepository(
                new CachedDataSource<>(), new GeoDataCloudDataSource());

        DataSource<UserData> userDataDataSource = new UserRepository(
                new CachedDataSource<>(), new UserDataCloudDataSource());

        MyData myData = myDataDataSource.getData();
        GeoData geoData = geoDataDataSource.getData();
        System.out.println(myData.toString());
        System.out.println(geoData.toString());

        UserData userData = userDataDataSource.getData();
        System.out.println(userData.toString());
        UserData userData1 = userDataDataSource.getData();
        System.out.println(userData1.toString());
    }
}