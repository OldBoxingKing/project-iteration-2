package cn.edu.hit.entity;

public class Remark {
    private int srcid;
    private int id;
    private String username;
    private String content;
    private String time;
    public Remark() {
        super();
    }

    public Remark(int id, String username, String content, String time) {
        super();
        this.id = id;
        this.username = username;
        this.content = content;
        this.time = time;
    }

    public Remark(int srcid,int id, String username, String content, String time) {
        super();
        this.srcid = srcid;
        this.id = id;
        this.username = username;
        this.content = content;
        this.time = time;
    }

    public int getSrcid() {
        return srcid;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
