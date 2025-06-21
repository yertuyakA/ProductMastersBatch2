package medium;

public class UserDataCloudDataSource implements DataSource<UserData>{

    @Override
    public UserData getData() {
        return new UserData(2, "Said", "email@gmail.com");
    }
public class UserDataCloudDataSource {

}
