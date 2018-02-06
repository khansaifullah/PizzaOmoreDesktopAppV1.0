package com.PrintUtility;

/**
 * Created by DELL on 1/30/2018.
 */
public class Branch {

    private int id;
    private String title;
    private String address;
    private String post_box;

    public Branch() {
    }

    public Branch(int id, String title, String address, String post_box) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.post_box = post_box;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost_box() {
        return post_box;
    }

    public void setPost_box(String post_box) {
        this.post_box = post_box;
    }
}
