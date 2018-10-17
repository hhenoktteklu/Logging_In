package com.login;

import java.util.List;

public class Role {
    private static int count = 10010;
    private long id;
    private String name;
    private List<User> user;

    public Role(String name) {
        this.name = name;
        id =count++;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Role{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
