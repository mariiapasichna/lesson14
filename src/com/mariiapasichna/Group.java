package com.mariiapasichna;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.*;

public class Group {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private String courseName;
    private LocalDate dateStart;
    private int totalClasses;
    private int classesPerWeek;
    private List<Student> group = new ArrayList<>();

    public Group(String courseName, LocalDate dateStart, int totalClasses, int classesPerWeek) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.totalClasses = totalClasses;
        this.classesPerWeek = classesPerWeek;
    }

    public Group(String courseName, LocalDate dateStart, int totalClasses, int classesPerWeek, List<Student> group) {
        this.courseName = courseName;
        this.dateStart = dateStart;
        this.totalClasses = totalClasses;
        this.classesPerWeek = classesPerWeek;
        this.group = group;
    }

    public String getLastWeekCourse() {
        TemporalField field = WeekFields.of(Locale.GERMANY).dayOfWeek();
        int daysOfCourse = totalClasses / classesPerWeek * 7 - 7;
        LocalDate dateLastWeekCourse = dateStart.plusDays(daysOfCourse).with(field, 1);
        return dateLastWeekCourse.format(FORMATTER);
    }

    public static String getGroupName(String courseName, String dateStart) {
        return courseName + "/" + dateStart;
    }

    public void addStudent(Student student) {
        this.group.add(student);
        student.addGroup(this);
    }

    public void removeStudent(Student student) {
        group.remove(student);
    }

    public void removeStudent(int index) {
        checkIndex(index);
        group.remove(index-1);
    }

    public boolean containsStudent(Student student) {
        return group.contains(student);
    }

    public void printGroup() {
        for (int i = 0; i < group.size(); i++) {
            System.out.println(i + 1 + ". " + group.get(i));
        }
    }

    @Override
    public String toString() {
        return courseName;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > group.size()) {
            System.out.println("Index out of range");
        }
    }
}