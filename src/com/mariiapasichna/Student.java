package com.mariiapasichna;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Group> groups = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", groups=" + groups +
                '}';
    }
}