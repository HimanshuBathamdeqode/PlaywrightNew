package TestCases.PlaywrightSessions;

import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DbManager.setMysqlDbConnection();
    }
}
