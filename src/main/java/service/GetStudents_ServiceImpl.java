package service;

import dao.GetStudents_DaoImpl;
import entities.Student;

import java.util.ArrayList;

public class GetStudents_ServiceImpl implements GetStudents_Service {
    @Override
    public ArrayList<Student> getStudents(String tableName) {
        return new GetStudents_DaoImpl().getStudents(tableName);
    }
}
