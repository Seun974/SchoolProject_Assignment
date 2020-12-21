package se.lexicon.samuel.data_access;

import se.lexicon.samuel.Student;
import se.lexicon.samuel.data_access.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao {
    private static List <Student> students;
    boolean isStudentDeleted = false;

    @Override
    public Student saveStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        Student searchStudents = new Student(0, null, null, null);
        for (Student student : students) {

            if (student.getEmail() == email) {
                searchStudents.setEmail(student.getEmail());
                searchStudents.setAddress(student.getAddress());
                searchStudents.setId(student.getId());
                searchStudents.setName(student.getName());
            }

        }
        return searchStudents;
    }

        @Override
    public List<Student> findByName(String name) {
            List <Student> searchStudents = new ArrayList<>();
            for (Student student : students) {

                if (student.getName() == name) {
                   searchStudents.add(student);
                }

            }
            return searchStudents;
    }

    @Override
    public Student findById(int id) {
        Student searchStudents = new Student(0, null, null, null);
        for (Student student: students) {
            if(student.getId() == id){
                searchStudents.setName(student.getName());
                searchStudents.setId(student.getId());
                searchStudents.setAddress(student.getAddress());
                searchStudents.setEmail(student.getEmail());
            }

        }

        return searchStudents;
    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public boolean deleteStudent(Student student) {
        isStudentDeleted = false;
        if(students.contains(student)) {
            students.remove(student);
            isStudentDeleted = true;
        }
        return isStudentDeleted;
    }

}
