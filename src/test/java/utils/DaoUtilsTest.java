package utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class DaoUtilsTest {

    @Test
    public void getConnection() {
        System.out.println(DaoUtils.getConnection());
    }
}