package com.mariiapasichna;

import java.text.ParseException;

public class Main {

    /*Написать класс "Группа", для отображения учебной группы в Hillel, который содержит поля:
- название курса
- дата старта занятий
- суммарное количество занятий
- количество занятий в неделю
- список учащихся типа Person
Написать методы:
- метод который выдает название группы на основе даты старта и названия курса
- метод который выдает дату старта последней недели курса
- печатает список студентов с порядковыми номерами
- добавить студента
- узнать если ли студент с такой фамилией в группе
- удалить студента по фамилии или по номеру
1.2* У студента есть список групп в которых он учится.
При добавлении студента в группу у него прописывается эта группа в списке.*/

	public static void main(String[] args) throws ParseException {
		Student smitt = new Student("Smitt");
		Student black = new Student("Black");
		Student snow = new Student("Snow");
		Student parker = new Student("Parker");
		Student simpson = new Student("Simpson");
		Student klinton = new Student("Klinton");

		Group java = new Group("Java", "12.03.2020", 16, 2);
		Group frontEnd = new Group("FrontEnd", "21.05.2020", 32, 2);
		Group pyton = new Group("Pyton", "03.07.2020", 20, 2);

		frontEnd.addStudent(parker, frontEnd);
		frontEnd.addStudent(simpson, frontEnd);
		frontEnd.addStudent(klinton, frontEnd);
		frontEnd.addStudent(snow, frontEnd);
		System.out.println(frontEnd.getGroup());

		java.addStudent(smitt, java);
		java.addStudent(black, java);
		java.addStudent(snow, java);
		System.out.println(java.getGroup());

		java.removeStudent(snow);
		System.out.println(java.getGroup());

		java.removeStudentByIndex(1);
		System.out.println(java.getGroup());

		System.out.println(java.containsStudent(smitt));

		System.out.println(snow.getGroups());

		System.out.println(Group.getGroupName("Java", "12.03.2020"));
		System.out.println(java.getLastWeekCourse("Java", "12.03.2020"));
	}
}