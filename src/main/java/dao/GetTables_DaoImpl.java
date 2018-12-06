package dao;

import dao.interfaces.GetTables_Dao;
import utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.LinkedList;
import java.util.List;

public class GetTables_DaoImpl implements GetTables_Dao {
    @Override
    public List getTables() {
        List<String> tables = new LinkedList<>();
        Connection connection = null;
        String sql = null;
        try {
            connection = DaoUtils.getConnection();
            sql = "select table_name from information_schema.tables " +
                    "where table_schema = 'datamining'";
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet rs = psmt.executeQuery();
            while (rs.next()){
                ResultSetMetaData rsMetaData = rs.getMetaData();
                tables.add(rs.getString(1));
            }
        }catch (Exception E){
            E.printStackTrace();
        }
        return tables;
    }
}
