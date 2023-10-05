package pack;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionTest {
    public static void main(String[] args) {
        // Database connection parameters
        String jdbcUrl = "jdbc:mysql://localhost/bookDB";
        String username = "root";
        String password = "root12345";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);

            // Step 3: Create a statement
            statement = connection.createStatement();

            // Step 4: Execute a query (e.g., a simple SELECT statement)
            String sqlQuery = "SELECT * FROM users";
            resultSet = statement.executeQuery(sqlQuery);

            // Step 5: Process the results
            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                // Print the data to the console
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close resources in a finally block
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
