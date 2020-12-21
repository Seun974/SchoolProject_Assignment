package se.lexicon.samuel;


import se.lexicon.samuel.data_access.CourseDaoList;
import se.lexicon.samuel.data_access.StudentDaoList;

import java.time.LocalDate;


public class App {
    public static void main(String[] args) {

        StudentDaoList studentDaoList = new StudentDaoList();
        CourseDaoList courseDaoList = new CourseDaoList();



        Student student1 = new Student(10, "sam", "sam@gmail.com", "vaxjo");
        studentDaoList.saveStudent(student1);

        Student student2 = new Student(20, "dan", "sdj@gmail.com", "lund");
        studentDaoList.saveStudent(student2);


        Course course1 = new Course(1, "Maths", LocalDate.parse("2000-12-10"), 5);
        Course course2 = new Course(2, "English", LocalDate.parse("2000-06-06"), 10);
        Course course3 = new Course(3, "Physics", LocalDate.parse("2000-04-30"), 8);
        Course course4 = new Course(4, "Chemistry", LocalDate.parse("2000-01-01"), 4);

        course1.register(student1);
        course1.register(student2);

        course2.register(student1);
        course2.register(student2);

        course4.register(student1);
        course4.register(student2);


        System.out.println("Student registered" + course1.getStudents());

        courseDaoList.saveCourse(course1);
        courseDaoList.saveCourse(course4);

        course1.register(new Student(1200, "Simon", "simon@test.se", "Vaxjo"));

        System.out.println("Checking DAO list " + courseDaoList.findById(1));
        System.out.println(courseDaoList.findByName("Math"));

        System.out.println(courseDaoList.findByName("Chemistry"));

        System.out.println(studentDaoList.findByEmail("sam@gmail.com"));

        System.out.println(courseDaoList.findAll());


    }
}
