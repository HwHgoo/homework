package dao;

import org.junit.Test;
import utils.DaoUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.junit.Assert.*;

public class MergeTable_DaoImplTest {

    @Test
    public void getStudents() {
        new MergeTable_DaoImpl().getStudents("reportcard1","reportcard2");
    }
}