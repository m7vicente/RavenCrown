package br.com.Bandtec.RavenCrown.Web.Model;

import org.springframework.stereotype.Component;


public class UserModel {

    public String userName;

    public String userEmail;

    public String userPass;

    public Long userId;

    public String getUserName() {
        return userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
