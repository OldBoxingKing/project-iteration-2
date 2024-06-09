package cn.edu.hit.entity;

public class Message {
    private int id;
    private String username;
    private String gender;
    private String face;
    private String title;
    private String content;
    private String time;
    private int good = 0;
    private String section;
    public Message() {
        super();
    }

    public Message(int id) {
        super();
        this.id = id;
    }

    public Message(String username, String title, String content, String time) {
        super();
        this.username = username;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public Message(String username, String title, String content, String time, String section) {
        super();
        this.username = username;
        this.title = title;
        this.content = content;
        this.time = time;
        this.section = section;
    }
    public Message(int id,String username, String gender, String face, String title, String content, String time,int good) {
        super();
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.face = face;
        this.title = title;
        this.content = content;
        this.time = time;
        this.good = good;
    }
    public Message(int id, String username, String gender, String face, String title, String content, String time,
                   int good, String section) {
        super();
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.face = face;
        this.title = title;
        this.content = content;
        this.time = time;
        this.good = good;
        this.section = section;
    }

    public String getSection() {
        return section;
    }
    public int getGood() {
        return good;
    }
    public int getId() {
        return id;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

}
