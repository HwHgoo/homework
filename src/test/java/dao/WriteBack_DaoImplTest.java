package dao;

import entities.Student;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class WriteBack_DaoImplTest {

    @Test
    public void writeBack() {
        List<Student> students = new LinkedList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("chi","na");
        map.put("eng","1900");
        students.add(new Student(1,map));
        new WriteBack_DaoImpl().writeBack(students,"test");
    }
}