import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpielbrettTest {

	/**
	 * Test 
	 */
	@Test
	void testGetGameBoard() {
		Spielbrett s = new Spielbrett();
		char[][] a = s.getGameBoard();
		assernotequals("ddsaeaead", s);
	}

	
	/**
	 * 
	 * @param string
	 * @param s
	 */
	private void assernotequals(String string, Spielbrett s) {
		// TODO Auto-generated method stub
		
	}

}
