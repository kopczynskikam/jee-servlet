package pl.coderslab.java_ee_servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RequestDAO {
    private static final String CREATE_REQUEST_QUERY = "INSERT INTO requests (userAgent,queryDateTime,queryTime) VALUES(?,?,?);";
    private static final String CREATE_REQUEST_PARAMS_QUERY = "INSERT INTO requestsParams(request_id, paramName, paramValue) VALUES(?,?,?);";

    public static Request createRequest(Request newRequest) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(CREATE_REQUEST_QUERY, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, newRequest.getUserAgent());
            statement.setString(2, newRequest.getQueryDateTime());
            statement.setString(3, String.valueOf(newRequest.getQueryTime()));
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                newRequest.setId(rs.getInt(1));
            }
            PreparedStatement statement2 = conn.prepareStatement(CREATE_REQUEST_PARAMS_QUERY);
            for (String paramName : newRequest.getAllRequestParams().keySet()) {
                statement2.setString(1, String.valueOf(newRequest.getId()));
                statement2.setString(2, paramName);
                statement2.setString(3, newRequest.getAllRequestParams().get(paramName));
                statement2.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newRequest;
    }
}
