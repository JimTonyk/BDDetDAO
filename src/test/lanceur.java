package test;

import DAO.StudentDao;
import DAO.StudentDaoImp;

public class lanceur {

	public static void main(String[] args) {
		StudentDao service = new StudentDaoImp();

		String note = service.getStudentGrade("ssn", "1");
		System.out.println("Grade is " + note);

	}

}
