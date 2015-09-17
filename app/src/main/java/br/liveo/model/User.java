package br.liveo.model;

import java.io.Serializable;

/**
 * Author       :   Mohsin Khan
 * Designation  :   Android Developer
 * E-mail       :   khan.square@gmail.com
 * Company      :   Parasme Softwares & Technology
 * Date         :   September 08 , 2015
 * Purpose      :   User Model
 * Description  :   Detailed Description...
 */

public class User implements Serializable {
    private String username;
    private String email;
    private String picUrl;
    private int usertype;

    public User() {
        this.username = "";
        this.email = "";
        this.picUrl = "";
        this.usertype = UserType.STUDENT;
    }

    public User(String username, String email, String picUrl, int usertype) {
        this.username = username;
        this.email = email;
        this.picUrl = picUrl;
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
}