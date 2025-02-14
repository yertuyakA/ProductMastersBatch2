package medium;

public class GeoRepository extends Repository<GeoData> {
    public GeoRepository(
        MutableDataSource<GeoData> cachedDataSource, DataSource<GeoData> cloudDataSource) {
        super(cachedDataSource, cloudDataSource);
    }

}
