package vn.edu.vtn.demo_mvp_splash.db.model;

import java.io.Serializable;

public class Info implements Serializable {
    private String name;
    private String old;
    private String hometown;
    private String work;

    public Info() {
    }

    public Info(String name, String old, String hometown, String work) {
        this.name = name;
        this.old = old;
        this.hometown = hometown;
        this.work = work;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOld() {
        return old;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
