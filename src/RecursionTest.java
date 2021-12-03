import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecursionTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		f(5);
	}

	private void f(int a) {
		if(a>3) {
			int b = a-1;
		f(b );
	}
	}
	
	@Test
	void factorialTest() {
		assertEquals(24, Recursion.factorial(4));
		assertEquals(1, Recursion.factorial(0));
		boolean fl = false;
		try {
			Recursion.factorial(-100);
		}catch(IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);
	}
	@Test
	void powTest() {
	
		assertEquals(0,  Recursion.pow(0, 3));
		assertEquals(4,  Recursion.pow(-2, 2));
		assertEquals(4,  Recursion.pow(2, 2));
		assertEquals(-8,  Recursion.pow(-2, 3));
		assertEquals(8,  Recursion.pow(2, 3));
		assertEquals(-32,  Recursion.pow(-2, 5));

		boolean fl = false;
		try {
			Recursion.pow(10,-10);
		}catch(IllegalArgumentException e) {
			fl = true;
		}
		fl = false;
		try {
			Recursion.pow(0,0);
		}catch(IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);
		
		assertEquals(1, Recursion.pow(23, 0));
	}
	@Test
	void arraySumTest() {
		
		assertEquals(10, Recursion.sum(new int[] {30,20,-40}));
		assertEquals(0, Recursion.sum(new int[0]));
	}
	@Test 
	void squereTest() {
		assertEquals(0, Recursion.square(0));
		assertEquals(1, Recursion.square(1));
		assertEquals(4, Recursion.square(2));
		assertEquals(4, Recursion.square(-2));
		assertEquals(100, Recursion.square(10));
		
	}
	@Test
	void isSubstringTest() {
		//assertTrue(Recursion.isSubstring("birthday", "day"));
		assertFalse(Recursion.isSubstring("day", "ai"));
		assertFalse(Recursion.isSubstring("sun", "telephone"));
		assertTrue(Recursion.isSubstring("Elephant", "Elep"));
		assertTrue(Recursion.isSubstring("Elephant", "pha"));
		assertFalse(Recursion.isSubstring("Elephant", "elep"));
		assertTrue(Recursion.isSubstring("birhbird", "bird"));
		assertFalse(Recursion.isSubstring("birthbird", "birds"));
		assertFalse(Recursion.isSubstring("sona", "sna"));
	
		boolean fl = false;
		try {
			Recursion.isSubstring("morning", "");
		}catch(IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);
		 fl = false;
		try {
			Recursion.isSubstring("", "morning");
		}catch(IllegalArgumentException e) {
			fl = true;
		}
		assertTrue(fl);

	}
	
}

