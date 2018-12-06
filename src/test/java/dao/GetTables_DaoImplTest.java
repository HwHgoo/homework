package dao;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetTables_DaoImplTest {

    @Test
    public void getTables() {
        new GetTables_DaoImpl().getTables();
    }
}