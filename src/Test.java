import static org.junit.jupiter.api.Assertions.*;

import DAO.StudentDao;
import DAO.StudentDaoImp;

class Test {

	@org.junit.jupiter.api.Test
	void testIfReturnedGradeIsA() {
		StudentDao service = new StudentDaoImp();

		String grade = "a";
		String result = service.getStudentGrade("ssn", "1");
		assertEquals(grade, result);
	}

}
