package pl.coderslab.java_ee_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    private static final String NEWSLETTER_DB_USERNAME = "root";
    private static final String NEWSLETTER_DB_PASSWORD = "coderslab";
    private static final String NEWSLETTER_DB_URL="jdbc:mysql://localhost:3306/newsletter?useSSL=false&characterEncoding=utf8";

    public static Connection getConnection () throws SQLException {
        return DriverManager.getConnection(NEWSLETTER_DB_URL, NEWSLETTER_DB_USERNAME, NEWSLETTER_DB_PASSWORD);
    }
}
