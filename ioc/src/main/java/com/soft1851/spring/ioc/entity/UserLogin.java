package com.soft1851.spring.ioc.entity;

/**
 * @ClassName UserLogin
 * @Description TODO
 * @Author yue_fan
 * @Date 2020/3/12
 **/
public class UserLogin {
    private User user;

    public UserLogin(User user) {
        this.user = user;
    }

    public UserLogin() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "user=" + user +
                '}';
    }

    public boolean userLogin(User user){
        if (user.getAccount().equals("admin") && user.getPassword().equals("111")){
            return true;
        }if (user.getAccount().equals("admin") && !user.getPassword().equals("111")){
            return false;
        }if (!user.getAccount().equals("admin")){
            return false;
        }
        return false;
    }
}
