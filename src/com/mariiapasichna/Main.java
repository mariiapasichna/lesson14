package com.mariiapasichna;

import java.text.ParseException;
import java.time.LocalDate;

public class Main {


	public static void main(String[] args) throws ParseException {
		Student smitt = new Student("Smitt");
		Student black = new Student("Black");
		Student snow = new Student("Snow");
		Student parker = new Student("Parker");
		Student simpson = new Student("Simpson");
		Student klinton = new Student("Klinton");

		Group java = new Group("Java", LocalDate.of(2020,3,12), 16, 2);
		Group frontEnd = new Group("FrontEnd",LocalDate.of(2020,2,21), 32, 2);
		Group pyton = new Group("Pyton", LocalDate.of(2020,8,23), 20, 2);

		frontEnd.addStudent(parker);
		frontEnd.addStudent(simpson);
		frontEnd.addStudent(klinton);
		frontEnd.addStudent(snow);
		frontEnd.printGroup();

		System.out.println();

		System.out.println(" ");

		java.addStudent(smitt);
		java.addStudent(black);
		java.addStudent(snow);
		java.addStudent(simpson);
		java.printGroup();
		System.out.println();

		java.removeStudent(snow);
		java.printGroup();
		System.out.println();

		java.removeStudent(1);
		java.printGroup();
		System.out.println();

		System.out.println(" ");

		java.removeStudent(snow);
		java.printGroup();
		System.out.println(" ");

		java.removeStudent(1);
		java.printGroup();
		System.out.println(" ");

		System.out.println(java.containsStudent(smitt));

		System.out.println(snow.getGroups());

		System.out.println(Group.getGroupName("Java", "12.03.2020"));
		System.out.println(java.getLastWeekCourse());
		System.out.println(frontEnd.getLastWeekCourse());
	}
}