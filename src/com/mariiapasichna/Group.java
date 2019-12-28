package com.mariiapasichna;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Group {
    private String courseName;
    private String dateStart;
    private int totalClasses;
    private int classesPerWeek;
    private List<Student> group = new ArrayList<>();

    public Group(String courseName, String dateStart, int totalClasses, int classesPerWeek) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.totalClasses = totalClasses;
        this.classesPerWeek = classesPerWeek;
    }

    public Group(String courseName, String dateStart, int totalClasses, int classesPerWeek, List<Student> group) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.totalClasses = totalClasses;
        this.classesPerWeek = classesPerWeek;
        this.group = group;
    }

    public String getLastWeekCourse(String courseName, String dateStart) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dateStart1 = dateFormat.parse(dateStart);
        Calendar calendar = new GregorianCalendar(dateStart1.getYear() + 1900, dateStart1.getMonth(), dateStart1.getDay() + 8);
        calendar.add(Calendar.WEEK_OF_YEAR, totalClasses / classesPerWeek - 1);
        return dateFormat.format(calendar.getTime());
    }

    public static String getGroupName(String courseName, String dateStart) {
        return courseName + "/" + dateStart;
    }

    public void addStudent(Student student, Group group) {
        this.group.add(student);
        student.addGroup(group);
    }

    public void removeStudent(Student student) {
        group.remove(student);
    }

    public void removeStudentByIndex(int index) {
        checkIndex(index);
        group.remove(index);
    }

    public boolean containsStudent(Student student) {
        return group.contains(student);
    }

    public List<Student> getGroup() {
        for (int i = 0; i < group.size(); i++) {
            System.out.println(i + 1 + " " + group.get(i));
        }
        return group;
    }

    @Override
    public String toString() {
        return "Group{" +
                "courseName='" + courseName + '\'' +
                '}';
    }

    private void checkIndex(int index) {
        if (index < 0 || index > group.size()) {
            System.out.println("Index out of range");
        }
    }
}