package medium;

public class UserRepository extends Repository<UserData>{

    public UserRepository(
            MutableDataSource<UserData> cachedDataSource, DataSource<UserData> cloudDataSource) {
        super(cachedDataSource, cloudDataSource);
    }
}
