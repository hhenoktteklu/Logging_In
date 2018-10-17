package com.login;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Role> roles = new ArrayList<Role>();


        roles.add(new Role("admin"));
        roles.add(new Role("editor"));
        roles.add(new Role("contributor"));
        Scanner keyboard = new Scanner(System.in);


        do {
            System.out.println("\nSelect an option number to continue:\n  1.Sign up\n  2.Add Role\n  3.List of Roles\n  4.Assign role ");
            int input = keyboard.nextInt();

            switch (input) {
                case 1:
                    keyboard.nextLine();
                    System.out.println("Creat new user: ");
                    String username = "";
                    String password = "";
                    String role = "";

                    System.out.print("Enter username: ");
                    username = keyboard.nextLine();
                    System.out.print("Enter password: ");
                    password = keyboard.nextLine();
                    System.out.println();
                    System.out.println("////ROLES//// ");
                    for (Role eachRole : roles) {
                        System.out.println(eachRole.getName());
                    }
                    System.out.println();

                    boolean moreRoles = false;
                    ArrayList<Role> roleAdded = new ArrayList<>();
                    System.out.println("ADD ROLE: ");
                    do {
                        role = keyboard.nextLine();
                        Role roleObj = findRole(role,roles);

                        if (roleObj != null) {
                            roleAdded.add(roleObj);
                            System.out.println("*Role successfully added* ");
                            System.out.print("Do you want to add more? (y/n)");
                            String check = keyboard.nextLine();
                            if (check.equalsIgnoreCase("y")) {
                                moreRoles = true;
                                System.out.print("add more role here: ");
                            } else {
                                moreRoles = false;
                            }
                        } else {
                            System.out.println("Role doesn't exist");
                        }
                    } while (moreRoles);

                        User user = new User(username,password,roleAdded);
                        users.add(user);
                    System.out.println(user.getId());
                        break;
                case 2:
                    keyboard.nextLine();
                    System.out.println("Add new role: ");
                    String name = "";
                    System.out.print("Enter new role here: ");
                    name = keyboard.nextLine();
                    if (findRole(name, roles) == null) {
                        roles.add(new Role(name));
                        System.out.println("*Role successfully added* ");
                    } else {
                        System.out.println("Role already exist! ");
                    }

                    break;  //optional
                case 3:
                    keyboard.nextLine();
                    System.out.println("List of Roles: ");
                    for (Role eachRole : roles) {
                        System.out.println(eachRole.getId() + " " + eachRole.getName());
                    }

                    break;  //optional
                case 4:
                    System.out.println("Assigning role");
                    System.out.print("Enter user id here: ");
                    long idSearch = keyboard.nextLong();
                    keyboard.nextLine();
                    User userFound = findUser(idSearch,users);
                    if(userFound!=null){
                        System.out.print(userFound.getUsername()+"->");
                        for (Role eachRole:userFound.getRole()) {
                            System.out.print(eachRole.getName()+" ");
                        }
                    }

                    System.out.println("\nAssign role, type here: ");
                    String assignRole = keyboard.nextLine();
                    for (Role eachRole: userFound.getRole()) {
                        if(userFound.getRole().contains(assignRole)){
                            
                        }
                        if(eachRole.getName().equalsIgnoreCase(assignRole)){
                            System.out.println("This role is already assigned to this user ");
                        }
                        userFound.getRole().add(new Role(assignRole));
                        System.out.println("Role added");
                    }
                    break;  //optional
                default:

            }
        } while (true);

    }

    public static Role findRole(String name, ArrayList<Role> roles) {
        Role roleFound = null;
        for (Role eachRole : roles) {
            if (eachRole.getName().equalsIgnoreCase(name)) {
                roleFound = eachRole;
            }
        }
        return roleFound;
    }
    public static User findUser(long id, ArrayList<User> users) {
        User userFound = null;
        for (User eachUser : users) {
            if (eachUser.getId()==id) {
                userFound = eachUser;
            }
        }
        return userFound;
    }
}
