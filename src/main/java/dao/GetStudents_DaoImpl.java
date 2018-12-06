package dao;

import dao.interfaces.GetStudents_Dao;
import entities.Student;
import utils.AssignUtil;
import utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GetStudents_DaoImpl implements GetStudents_Dao {
    @Override
    public ArrayList<Student> getStudents(String tableName) {
        ArrayList<Student> students = new ArrayList<>();
        Connection conn = DaoUtils.getConnection();
        String sql = "select * from " + tableName;
        try {
            PreparedStatement psmt = conn.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Student student = new Student();
                student.setId(rs.getInt(1));
                AssignUtil.assign(student,rs);
                students.add(student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }
}
