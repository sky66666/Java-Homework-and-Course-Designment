package Project2;

public interface UserDao {
    public boolean addUser(User user);
    public User getUser(String username,String password);
}
