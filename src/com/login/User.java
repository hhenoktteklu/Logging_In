package com.login;

import java.util.List;

public class User {
    private static int count = 110;
    private static long id;
    private String username;
    private String password;
    private List<Role> role;

    public User(String username, String password, List<Role> role) {
        this.username = username;
        this.password = password;
        this.role = role;
        id =count++;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

   // public void addRole(Role role){
   //     role.addRole(role);
   // }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
