package org.student;

import java.util.ArrayList;

public class StudentList {

    ArrayList<Student> studentList;

    public StudentList() {
        studentList = new ArrayList<Student>();
    }

    public void addStudentToList(Student student) {
        studentList.add(student);
    }

    //add more than one student to list
    public void addStudentsToList(ArrayList<Student> students) {
        studentList.addAll(students);
    }

    public Student getStudent(int index) {
        return studentList.get(index);
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public int getTotalStudentSize() {
        return studentList.size();
    }

    public void removeStudentFromList(Student student) {
        studentList.remove(student);
    }

}
