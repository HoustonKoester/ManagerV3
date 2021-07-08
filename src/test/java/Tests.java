
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import models.Employee;
import services.GenServiceImpl;

class Tests {
	private GenServiceImpl gen;
	@BeforeEach
	void initEach() {
		gen = new GenServiceImpl();
	}
	@Test
	void loginAttempt() {
		assertEquals("Glenn",gen.loginAttempt("Glenn", "dad").getEmpName());
	}
	@Test
	void updateDatabase() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("test");
		assertEquals(false,gen.updateDatabase(info));
	}
	@Test
	void insertReim() {
		assertEquals(false,gen.insertReim("1", "test", "2"));
	}
	@Test
	void genNewUserID() {
		assertNotEquals(0,gen.genNewUserID());
	}
	@Test
	void addNewUser() {
		assertEquals(false,gen.addNewUser(-1, null, null, null, null, null, null, null));
	}
	@Test
	void addPendingEmployee() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("test");
		assertEquals(false,gen.addPendingEmployee(info));
	}
	@Test
	void deletePendingEmployee() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("test");
		assertEquals(false,gen.deletePendingEmployee(info));
	}
	@Test
	void getActiveEmployee() {
		assertEquals(true,gen.getActiveEmployee("Glenn", "dad"));
	}
	@Test
	void updateEmp() {
		ArrayList<String> info = new ArrayList<String>();
		info.add("test");
		assertEquals(false,gen.updateEmp(info));
	}
	

}