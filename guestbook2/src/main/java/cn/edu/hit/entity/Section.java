package cn.edu.hit.entity;

public class Section {
    private int sid;
    private String section;

    public Section(String section) {
        super();
        this.section = section;
    }

    public Section(int sid, String section) {
        super();
        this.sid = sid;
        this.section = section;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

}
