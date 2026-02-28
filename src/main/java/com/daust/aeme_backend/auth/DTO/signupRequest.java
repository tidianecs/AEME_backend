package com.daust.aeme_backend.auth.DTO;

public class signupRequest {
    private String username;
    private String email;
    private String password;

    public signupRequest(){}

    public signupRequest(String username, String email, String password){
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUserName(){
        return username;
    }
    public void setUserName(String userName){
        this.username = userName;
    }

    public String getUserEmail(){
        return email;
    }
    public void setUserEmail(String userEmail){
        this.email = userEmail;
    }

    public void setUserPassword(String password){
        this.password = password;
    }
    public String getUserPassword(){
        return password;
    }
}
