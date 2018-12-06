package utils;

import entities.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DaoUtils {
    public static Connection getConnection(){
        String driverName = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String pswd = "YBJ_gds777";
        String url = "jdbc:mysql://localhost:3306/datamining";
        Connection connection = null;
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,username,pswd);
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

    public static String insertStudents(List<Student> students, String fileName){
        List<String> columnNames = new LinkedList<>();
        Map<String, Object> example = students.get(0).getAttributes();
        for (Map.Entry<String, Object> entry : example.entrySet()){
            columnNames.add(entry.getKey());
        }
        String result ="";
        String col = "INSERT INTO " + fileName + "( id";
        for(String str : columnNames){
            col += ","+str;
        }
        col +=" ) VALUES( ";
        for (Student student : students){
            result += col + " " + student.getId();
            for (String str : columnNames){
                result += "," + student.getAttributes().get(str);
            }
            result += " )\n";
        }
        return result;
    }
}
