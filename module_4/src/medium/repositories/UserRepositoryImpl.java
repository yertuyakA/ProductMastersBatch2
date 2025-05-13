package medium.repositories;

import medium.datasources.DataSource;
import medium.datasources.userdata.UserCashedDataSource;
import medium.models.UserData;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private final UserCashedDataSource cashedUserDataSource;
    private final DataSource<UserData> cloudDataSource;

    public UserRepositoryImpl(UserCashedDataSource cashedUserDataSource, DataSource<UserData> cloudDataSource) {
        this.cashedUserDataSource = cashedUserDataSource;
        this.cloudDataSource = cloudDataSource;
    }

    @Override
    public List<UserData> getAllUsersData() {
        return cloudDataSource.getAllData();
    }

    @Override
    public UserData getUserDataById(Integer id) {
        UserData userDataFromCashSource = cashedUserDataSource.getUserDataMap().get(id.toString());
        if (userDataFromCashSource == null) {
            UserData userData = cloudDataSource.getAllData()
                    .stream()
                    .filter(user -> user.getId().equals(id))
                    .findFirst()
                    .orElse(null);
            cashedUserDataSource.getUserDataMap().put(id.toString(), userData);
            return userData;
        }
        return userDataFromCashSource;
    }

    @Override
    public void save(UserData userData) {
        cashedUserDataSource.saveData(userData);
    }
}
