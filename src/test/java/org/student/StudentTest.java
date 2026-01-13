package org.student;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentTest {

    private StudentList studentList;

    @BeforeMethod
    public void setUp() {
        studentList = new StudentList();
    }

    @Test
    public void testAddStudentToList() {
        Student thirdGradeStudent = new Student(593, "John Doe", 3);
        studentList.addStudentToList(thirdGradeStudent);
        Assert.assertTrue(studentList.getStudentList().contains(thirdGradeStudent),
                "Student should be added to the list.");
    }

    @Test
    public void testGetTotalStudentSize() {
        Student firstGradeStudent = new Student(591, "Jane Smith", 1);
        Student secondGradeStudent = new Student(592, "Mike Johnson", 2);
        studentList.addStudentsToList(new ArrayList<>() {
            {
                add(firstGradeStudent);
                add(secondGradeStudent);
            }
        });
        int first = studentList.getTotalStudentSize();
        Student thirdGradeStudent = new Student(593, "John Doe", 3);
        studentList.addStudentToList(thirdGradeStudent);
        int last = studentList.getTotalStudentSize();
        Assert.assertEquals(first + 1, last, "Total student size should increase by 1 after adding a student.");

    }

    @Test
    public void testRemoveStudentFromList() {
        Student fourthGradeStudent = new Student(594, "Emily Davis", 4);
        studentList.addStudentToList(fourthGradeStudent);
        Student fifthGradeStudent = new Student(595, "Chris Brown", 5);
        studentList.addStudentToList(fifthGradeStudent);
        Assert.assertTrue(studentList.getStudentList().contains(fourthGradeStudent),
                "Student should be in the list before removal.");
        studentList.removeStudentFromList(fourthGradeStudent);
        Assert.assertFalse(studentList.getStudentList().contains(fourthGradeStudent),
                "Student should not be in the list after removal.");
    }

    @Test
    public void testGetStudent() {
        Student fifthGradeStudent = new Student(595, "Chris Brown", 5);
        Student sixthGradeStudent = new Student(596, "Jane Smith", 6);
        Student seventhGradeStudent = new Student(597, "Tom Wilson", 7);
        Student eighthGradeStudent = new Student(598, "Sara Lee", 8);
        studentList.addStudentsToList(new ArrayList<>() {
            {
                add(fifthGradeStudent);
                add(sixthGradeStudent);
                add(seventhGradeStudent);
                add(eighthGradeStudent);
            }
        });
        System.out.println(studentList.getStudentList());

        // Validate that all added students are correctly retrieved in order
        Assert.assertEquals(studentList.getStudentList(), Arrays.asList(
                fifthGradeStudent,
                sixthGradeStudent,
                seventhGradeStudent,
                eighthGradeStudent), "The student list should match the added students in order.");
    }

}
