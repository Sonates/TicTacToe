import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CPUTest {

	
	/**
	 * 
	 */
	@Test
	void testCPU() {
		CPU c = new CPU();
		String a = c.name();
		assertnotequals("CPUsa", a);
	}

	/**
	 * 
	 * @param string
	 * @param a
	 */
	private void assertnotequals(String string, String a) {
		// TODO Auto-generated method stub
		
	}

}
