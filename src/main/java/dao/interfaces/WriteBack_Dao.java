package dao.interfaces;

import entities.Student;

import java.util.List;

public interface WriteBack_Dao {
    public void writeBack(List<Student> students, String fileName);
}
