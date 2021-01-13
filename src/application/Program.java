package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DBException;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getconnection();
				st = conn.createStatement();
				
				rs = st.executeQuery("SELECT * FROM department");
				
				while(rs.next()) {
					System.out.println("ID:" + rs.getInt("id") + ", NAME:" + rs.getString("name") );
				}
			DB.closeConnection();
			
		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
			DB.closeConnection();
		}
	}

}
