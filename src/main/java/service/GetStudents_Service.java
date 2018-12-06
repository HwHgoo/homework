package service;

import entities.Student;

import java.util.ArrayList;

public interface GetStudents_Service {
    public ArrayList<Student> getStudents(String tableName);
}
