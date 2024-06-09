package cn.edu.hit.entity;

public class User {
    private String username;
    private String pwd;
    private String gender;
    private String face;

    public User() {
        super();
    }
    public User(String username, String pwd, String gender, String face) {
        super();
        this.username = username;
        this.pwd = pwd;
        this.gender = gender;
        this.face = face;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getFace() {
        return face;
    }
    public void setFace(String face) {
        this.face = face;
    }

}
