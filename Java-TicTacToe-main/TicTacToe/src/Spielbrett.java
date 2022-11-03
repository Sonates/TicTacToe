
public class Spielbrett {

		/**
		 * Spielbrett 3 x 3 Form als 2 Dimmensionales array
		 */
	
    char[][] gameBoard = {
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}
    };
    
    public char[][] getGameBoard(){
    	return gameBoard;
    }
    
	
}
