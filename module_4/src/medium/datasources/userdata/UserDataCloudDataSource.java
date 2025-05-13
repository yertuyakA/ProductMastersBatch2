package medium.datasources.userdata;

import medium.datasources.DataSource;
import medium.models.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserDataCloudDataSource implements DataSource<UserData> {

    private final List<UserData> userDataList;

    public UserDataCloudDataSource(List<UserData> userDataList) {
        this.userDataList = userDataList;
    }

    public UserDataCloudDataSource() {
        userDataList = new ArrayList<>();
    }

    public List<UserData> getUserDataList() {
        return userDataList;
    }

    @Override
    public List<UserData> getAllData() {
        return userDataList;
    }
}
