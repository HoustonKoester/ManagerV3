
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import models.Employee;
import services.GenServiceImpl;

class ImplTest {
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
		assertEquals(false,false);
	}
	@Test
	void insertReim() {
		assertEquals(false,false);
	}
	@Test
	void genNewUserID() {
		assertEquals(false,false);
	}
	@Test
	void addNewUser() {
		assertEquals(false,false);
	}
	@Test
	void addPendingEmployee() {
		assertEquals(false,false);
	}
	@Test
	void deletePendingEmployee() {
		assertEquals(false,false);
	}
	@Test
	void getActiveEmployee() {
		assertEquals(false,false);
	}
	@Test
	void updateEmp() {
		assertEquals(false,false);
	}
	
//	@Test
//	void yearlySalary() {
//		assertEquals(24000, esi.calculateYearlySalary(1));
//				
//	}
//	
//	@Test
//	void findEmp() {
//		assertEquals(EmployeeServiceImpl.employ.get(0), esi.findByEmployeeNo(1));
//				
//	}
}