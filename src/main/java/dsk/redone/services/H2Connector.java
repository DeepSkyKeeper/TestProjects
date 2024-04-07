package dsk.redone.services;

import lombok.SneakyThrows;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

//@ApplicationScoped

public class H2Connector {
    Connection connection;

    /**
     * connect() - opening connection to H2 mem database
     * @throws SQLException
     */
    @SneakyThrows
    public void connect() throws SQLException {
        String driver = "org.h2.Driver";
        String jdbcURL = "jdbc:h2:mem:test";
        Class.forName(driver);
        connection = DriverManager.getConnection(jdbcURL);
        if (connection != null)
            System.out.println("Connected to H2 in-memory database.");
        else
            System.out.println("Can't able connecting to H2 in-memory database");
    }

    /**
     * disconnect() - closing connection to H2 database
     * @throws SQLException
     */
    public void disconnect() throws SQLException {
        connection.close();
    }

    /**
     * insert - insert record into H2 database
     * @param name - currency name
     * @param id - currency id
     */
    @SneakyThrows
    public void insert(String name, String id) {

        String sql = "Insert into currencies (name,ID) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, id);
        int rows = statement.executeUpdate(sql);

        if (rows > 0) {
            System.out.println("Inserted a new row.");
        }
    }

    /**
     * read()- read all records from "currency" H2 database
     * @return HashMap of currency name,id
     */
    @SneakyThrows
    public Map<String, String> read() {
        Map<String, String> curMap = new HashMap<>();
        String sql = "SELECT * FROM Users";

        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);

        while (result.next()) {
            String name = result.getString(1);
            String id = result.getString(2);
            curMap.put(name, id);
        }
        return curMap;
    }
}
