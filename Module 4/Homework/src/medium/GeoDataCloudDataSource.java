package medium;

public class GeoDataCloudDataSource implements DataSource<GeoData> {

    @Override
    public GeoData getData() {
        return new GeoData(2, 10.2, 20.0);
    }

}
