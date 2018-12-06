package dao;

import entities.Student;
import org.junit.Test;

import java.util.ArrayList;

public class GetStudents_DaoImplTest {

    @Test
    public void test() {
        ArrayList<Student> students = new  GetStudents_DaoImpl().getStudents("reportcard1");
    }
}