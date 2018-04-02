package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DaoJdbc {

	public Connection getConnection() throws ClassNotFoundException, SQLException {

		// Attributes
		String user = "root";
		String password = "";
		Connection cnx = null;

		// Getting connection to DataBase servor
		Class.forName("com.mysql.jdbc.Driver");
		cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/formation", user, password);
		System.out.println("Connection established");

		return cnx;
	}

	protected void close(Connection c, PreparedStatement stat, ResultSet rs) {
		try {
			if (c != null) {
				c.close();
			}
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {

			if (stat != null) {
				stat.close();
			}
		}

		catch (SQLException ex) {
			ex.printStackTrace();
		}

		try {
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		System.out.println("All ressources cleared !");

	}
}
