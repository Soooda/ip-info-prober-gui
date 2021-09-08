package exam.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseHandlerImpl implements DatabaseHandler {
    private Connection connection;
    private Statement statement;

    public DatabaseHandlerImpl() {
        this.connection = null;
        this.statement = null;

        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/cache.db");
            this.statement = connection.createStatement();
            statement.setQueryTimeout(30);
        } catch(SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean query(String ip) {
        try {
            ResultSet rs = statement.executeQuery("select 1 from cache where ip='" + ip + "'");
            if(rs.next()) return true;
            return false;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean cache(String ip, String json) {
        try {
            /** If the ip is not yet in the table. */
            if(!query(ip)) {
                statement.executeUpdate("insert into cache values('" + ip + "', '" + json + "')");
            } else {
                statement.executeUpdate("update cache set json='" + json + "' where ip='" + ip + "'");
            }
            return true;
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public String get(String ip) {
        try {
            ResultSet rs = statement.executeQuery("select json from cache where ip='" + ip + "'");
            if(!rs.next()) return null;
            return rs.getString("json");
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
