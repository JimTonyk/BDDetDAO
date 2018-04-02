package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImp extends DaoJdbc implements StudentDao {

	@Override
	public String getStudentGrade(String ssn, String courseId) {
		String result = "";

		Connection c = null;
		PreparedStatement stat = null;
		ResultSet rs = null;

		try {
			c = getConnection();
			stat = c.prepareStatement("Select grade note from enrollment where ssn=? and courseId=?");
			stat.setString(1, ssn);
			stat.setString(2, courseId);

			rs = stat.executeQuery();
			while (rs.next()) {
				result = rs.getString("note");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.getStackTrace();
		}

		finally {
			close(c, stat, rs);
		}

		return result;
	}

}
