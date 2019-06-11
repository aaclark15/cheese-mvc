package org.launchcode.cheesemvc.models;

import java.util.ArrayList;

//this class handles storage and access to our data - won't use with databases
public class UserData {

    static ArrayList<User> users = new ArrayList<User>(); //creates a new list

    //getAll
    public static ArrayList<User> getAll() {
        return users;
    }

    //add
    public static void add(User newUser) {
        users.add(newUser);
    }

    //remove
//    public static void remove(int id) {
//        Cheese cheeseToRemove = getById(id); //uses method to remove cheese by id and not name
//        cheeses.remove(cheeseToRemove);
//    }

    //getById
    public static User getById(int id) {
        User theUser = null; //initializes the var to return null if nothing is found

        for (User candidateUser : users) {
            if (candidateUser.getUserId() == id) {
                theUser = candidateUser;
            }
        }
        return theUser; //returning User obj
    }

}
