package Project2;

public class main {
    public static void main(String[] args){
        UserDao userDao = new UserDaoForArray();
        Application app = new Application(userDao);
        app.registe();
        app.login();
    }
}
