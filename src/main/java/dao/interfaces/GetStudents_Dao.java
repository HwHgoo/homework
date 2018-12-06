package dao.interfaces;

import entities.Student;

import java.util.ArrayList;

public interface GetStudents_Dao {
    public ArrayList<Student> getStudents(String tableName);
}
