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

}
