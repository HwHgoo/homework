package dao;

import dao.interfaces.MergeTable_Dao;
import entities.Student;
import utils.AssignUtil;
import utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class MergeTable_DaoImpl implements MergeTable_Dao {
    @Override
    public List<Student> getStudents(String table_name1, String table_name2) {
        List<Student> students = null;
        Connection connection = null;
        String mergeSql = null;
        String dropSql = null;
        String getSql = null;
        try {
            connection = DaoUtils.getConnection();
            String newTable = table_name1 + "_" + table_name2;
            mergeSql = "create table " + newTable+
                    " select * from "+ table_name1 +" inner join "+ table_name2 +
                    " using(id)";
            dropSql = "drop table if exists " + newTable;
            getSql = "select * from " + newTable;
            //删除已存在的合并表
            PreparedStatement psmt = connection.prepareStatement(dropSql);
            psmt.execute();
            //合并表
            psmt = connection.prepareStatement(mergeSql);
            psmt.execute();
            //获取表内容
            psmt = connection.prepareStatement(getSql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                Student student = new Student();
                AssignUtil.assign(student, rs);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
