package com.mariiapasichna;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Group> groups = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return name +
                ", groups=" + groups;
    }
}