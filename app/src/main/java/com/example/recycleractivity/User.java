package com.example.recycleractivity;

import java.util.ArrayList;

public class User {
    private String mName;
    private boolean mInfo;

    public User(String name, boolean info) {
        mName = name;
        mInfo = info;
    }

    public String getName() {
        return mName;
    }

    public boolean isInfo() {
        return mInfo;
    }

    private static int lastContactId = 0;

    public static ArrayList<User> createUserList(int numContacts) {
        ArrayList<User> contacts = new ArrayList<User>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new User("User " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }
}
