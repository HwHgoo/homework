package dao.interfaces;

import entities.Student;

import java.util.List;

public interface MergeTable_Dao {
    List<Student> getStudents(String table_name1, String table_name2);
}
