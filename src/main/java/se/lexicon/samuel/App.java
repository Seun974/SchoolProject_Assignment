package se.lexicon.samuel;


import java.time.LocalDate;

public class App
{
    public static void main( String[] args ) {
    Course course = new Course(1, "Biology", LocalDate.parse("2000-12-10"), 10);
        System.out.println("Course ID is " + course.getId() + ", course name: " + course.getCourseName() + ", course start date: "
                        + course.getStartDate() + " for duration " + course.getWeekDuration() + " weeks.");
    Student student = new Student(100, "Sam", "sade@gmail.com", "vxj, Sweden");
        System.out.println("Student ID " + student.getId() + "; Name: " + student.getName() + "; Email add: "
                + student.getEmail() + "with student address: " + student.getAddress());


    course.register(student);
        System.out.println(course.getCourseName());




    }
}
