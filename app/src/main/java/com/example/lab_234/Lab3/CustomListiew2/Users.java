package com.example.lab_234.Lab3.CustomListiew2;

public class Users {
    private int avatar;
    private int flag;
    private String name;
    private String description;

    public Users(int avatar, int flag, String name, String description) {
        this.avatar = avatar;
        this.flag = flag;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
