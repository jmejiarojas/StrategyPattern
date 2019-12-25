package pe.jmejia.pattern.strategy.impl;

import pe.jmejia.pattern.strategy.util.MySQLDBAdapter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlAuthStrategy implements IAuthStrategy {

  @Override
  public Principal authenticate(String username, String password) {
    MySQLDBAdapter adapter = new MySQLDBAdapter();
    Connection connection = adapter.getConnection();
    // En vez de esto ser recomienda usar PreparedStatement
    String queryString = "select * from users where userName = '%s' and password = '%s' ";
    String query = String.format(queryString, username, password);
    Statement statement;
    try {
      statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(query);

      if (resultSet.next()) {
        return new Principal(resultSet.getString("userName"), resultSet.getString("rol"));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
