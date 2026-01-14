package org.student;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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
        Student a = new Student(595, "Chris Brown", 5);
        Student b = new Student(596, "Jane Smith", 4);
        Student c = new Student(597, "Tom Wilson", 8);
        Student d = new Student(598, "Sara Lee", 8);
        Student e = new Student(599, "David Clark", 3);
        Student f = new Student(600, "Jane Smith", 10);
        studentList.addStudentsToList(new ArrayList<>() {
            {
                add(a);
                add(b);
                add(c);
                add(d);
                add(e);
                add(f);
            }
        });
        System.out.println("first status: " + studentList.getStudentList());

        // Validate that all added students are correctly retrieved in order
        Assert.assertEquals(studentList.getStudentList(), Arrays.asList(a, b, c, d, e, f),
                "The student list should match the added students in order.");

        Collections.sort(studentList.getStudentList());
        System.out.println("after Collections.sort: " + studentList.getStudentList());

        // Diyelim ki bazen isme göre, bazen nota göre sıralamak istiyoruz. Comparable (compareTo) kullandığımızda
        // kuralı sınıfa gömmüş oluruz. Comparator.comparingInt ise bize dışarıdan kural belirleme şansı verir
        studentList.getStudentList().sort(Comparator.comparingInt(Student::getGrade));
        System.out.println("after using Comparator: " + studentList.getStudentList());

        //null verirsek Student classındaki compareTo (Comparable) kuralını kullanır. name'e göre sıralar
        studentList.getStudentList().sort(null);
        System.out.println("after using sort(null): " + studentList.getStudentList());
    }

}
