package medium.datasources.userdata;

import medium.datasources.MutableDataSource;
import medium.models.UserData;

import java.util.*;

public class UserCashedDataSource implements MutableDataSource<UserData> {

    private final Map<String, UserData> userDataMap = new HashMap<>();

    public Map<String, UserData> getUserDataMap() {
        return userDataMap;
    }

    @Override
    public List<UserData> getAllData() {
        return List.copyOf(userDataMap.values());
    }

    @Override
    public void saveData(UserData userData) {
        userDataMap.put(userData.getId().toString(), userData);
    }
}
