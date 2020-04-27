package Project2;

public class UserDaoForArray implements UserDao {

    private User[] users;
    private int count=0;

    public UserDaoForArray(){
        users = new User[10];
        count = 0;
    }

    @Override
    public boolean addUser(User user) {
        for(int i=0;i<count;++i){
            if(users[i].getUsername().equals(user.getUsername())){
                return false;
            }
        }
        if(count==users.length){
            User[] temp = users;
            users = new User[count*2];
            System.arraycopy(temp, 0, users, 0, count);
        }
        users[count++]=user;
        return true;
    }

    @Override
    public User getUser(String username, String password) {
        for(int i=0;i<count;++i){
            if(users[i].getUsername().equals(username)){
                if(users[i].getPassword().equals((password)))return users[i];
                else return null;
            }
        }
        return null;
    }
}
