package medium;

import medium.datasources.userdata.UserCashedDataSource;
import medium.datasources.userdata.UserDataCloudDataSource;
import medium.models.UserData;
import medium.repositories.UserRepository;
import medium.repositories.UserRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<UserData> userDataList = new ArrayList<>();
        userDataList.add(new UserData(1, "Nurgali", "nurgali@gmail.com"));
        userDataList.add(new UserData(2, "Ergali", "ergali@gmail.com"));

        UserRepository userRepository = new UserRepositoryImpl(
                new UserCashedDataSource(),
                new UserDataCloudDataSource(userDataList)
        );

        System.out.println(userRepository.getAllUsersData());
        System.out.println(userRepository.getUserDataById(1));
    }
}
