package se.lexicon.samuel.data_access;

import se.lexicon.samuel.Course;
import se.lexicon.samuel.Student;
import se.lexicon.samuel.data_access.CourseDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao {
    private static List <Course> courses;
    boolean isCourseRemoved = false;

    @Override
    public Course saveCourse(Course course) {
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        Course searchCourse = new Course(0, null, null,0);
        for (Course course : courses){
            if(course.getId() == id){
                searchCourse.setCourseName(course.getCourseName());
                searchCourse.setId(course.getId());
                searchCourse.setStartDate(course.getStartDate());
                searchCourse.setWeekDuration(course.getWeekDuration());

            }
        }
        return searchCourse;
    }

    @Override
    public List<Course> findByName(String name) {
        List<Course> searchCourse = new ArrayList<>();
        for (Course course: courses){
            if(course.getCourseName() == name){
                searchCourse.add(course);
            }
        }
        return searchCourse;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        List<Course> searchCourse = new ArrayList<>();
        for (Course course: courses){
            if(course.getStartDate() == date){
                searchCourse.add(course);
            }
        }
        return searchCourse;
    }

    @Override
    public List<Course> findAll() {
        return courses;
    }

    @Override
    public boolean removeCourse(Course course) {
        isCourseRemoved = false;
        if(courses.contains(course)){
            courses.remove(course);
            isCourseRemoved = true;
        }
        return isCourseRemoved;
    }
}
