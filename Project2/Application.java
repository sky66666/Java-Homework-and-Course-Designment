package Project2;

import java.util.Scanner;

public class Application {
    private UserDao userDao;
    public Application(UserDao userDao){
        this.userDao=userDao;
    }
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    public void registe(){
        String username,password,password1;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("******注册用户******");
            System.out.println("请输入用户名:");
            username = in.next();
            System.out.println("请输入密码:");
            password = in.next();
            System.out.println("请重新输入密码:");
            password1 = in.next();
            if(password.equals(password1)){
                User user = new User(username,password);
                userDao.addUser(user);
                System.out.println(username+"注册成功!");
                return;
            }else{
                System.out.println("两次输入的密码不一致，请重新输入!");
            }
        }
    }
    public void login(){
        String username,password;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.println("******用户登录******");
            System.out.println("请输入用户名:");
            username = in.next();
            System.out.println("请输入密码:");
            password = in.next();
            User user=userDao.getUser(username,password);
            if(user==null){
                System.out.println("用户不存在或密码错误!");
            }else{
                System.out.println(username+"已登录!");
                return;
            }
        }
    }
}
