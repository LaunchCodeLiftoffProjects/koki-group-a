package com.example.BillTracker;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.BillTracker.models.*;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BillTrackerApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void emptyTest() {
		assertEquals(10,10,001);
	}

	Bill test_bill;

//	@Before
//	public void createBillObject() {
//		Bill test_bill = new Bill(45.00, "Dr. Otter's", "January 1, 2021", "Pet");
//	}


	//TODO: constructor sets Bill model properly
	@Test
	public void testSetBill() {
		Bill test_bill = new Bill(45.00, "Dr. Otter's", "January 1, 2021", "Pet");
		assertNotNull(test_bill);
	}

	//TODO: constructor sets User model properly
//	@Test
//	public void testSetUser() {
//		User test_user = new User("John", "Smith", "js111@email.com");
//		assertNotNull(test_user);
//	}


}
