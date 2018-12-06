package utils;

import entities.Student;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class AssignUtil {
    public static void assign(Student student, ResultSet rs){
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            for(int i = 2; i<=rsmd.getColumnCount(); i++){
                student.getAttributes().put(rsmd.getColumnName(i),rs.getObject(i));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
