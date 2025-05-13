package medium.repositories;


import medium.models.UserData;

import java.util.List;

public interface UserRepository {
    List<UserData> getAllUsersData();
    UserData getUserDataById(Integer id);
    void save(UserData userData);
}
