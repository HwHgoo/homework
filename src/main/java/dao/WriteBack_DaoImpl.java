package dao;

import dao.interfaces.WriteBack_Dao;
import entities.Student;
import utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class WriteBack_DaoImpl implements WriteBack_Dao {
    @Override
    public void writeBack(List<Student> students, String fileName) {
        Connection connection;
        try {
            connection = DaoUtils.getConnection();
            String sql = DaoUtils.insertStudents(students,fileName);
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.execute();
        }catch (Exception e){

        }
    }
}
