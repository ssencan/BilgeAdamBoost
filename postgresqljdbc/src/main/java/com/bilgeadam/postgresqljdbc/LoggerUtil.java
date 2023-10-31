package com.bilgeadam.postgresqljdbc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LoggerUtil {
	
	public static void logToDatabase(Exception e) {
        try {
            Connection con = Constants.getConnection();
            PreparedStatement pstmt = con.prepareStatement("INSERT INTO LOG_TABLE (ERROR_MESSAGE, STACK_TRACE) VALUES (?, ?)");
            pstmt.setString(1, e.getMessage());
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            pstmt.setString(2, stackTrace);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
