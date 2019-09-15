package com.example.pokedex;

public class Users {
    String userName;
    String userPhone;
    String userEmail;
    String animalDesc;

    public Users(){

    }

    public Users(String email, String username,String userphone,String Desc) {
        this.userEmail = email;
        this.userName = username;
        this.userPhone=userphone;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
