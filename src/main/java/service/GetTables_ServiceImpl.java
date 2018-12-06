package service;

import dao.GetTables_DaoImpl;

import java.util.List;

public class GetTables_ServiceImpl implements GetTables_Service {
    @Override
    public List<String> getTables() {
        List<String> list = new GetTables_DaoImpl().getTables();
        return list;
    }
}
