import java.util.*;

/**
 * Spiel Starten: Das ist die Main Klasse, hier wird alles gestartet
 * Test: In der Testklassen wurden Junit Tests ausgeführt
 * @author nate
 * @Date 20.05.2022
 * @Version 1.0
 */






public class TicTacToe {

	/**
	 * Erstellt Statische Variablen für die Objekten.
	 */
	
	
	static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

	static CPU computer;
	static Spieler spiel;
	static String spielername;

	public static void main(String[] args) {

		/**
		 * Begrüssung und Titelseite des nutzer
		 */
		
		System.out.println(".___________. __    ______ .___________.    ___       ______ .___________.  ______    _______ \n"
				+ "|           ||  |  /      ||           |   /   \\     /      ||           | /  __  \\  |   ____|\n"
				+ "`---|  |----`|  | |  ,----'`---|  |----`  /  ^  \\   |  ,----'`---|  |----`|  |  |  | |  |__   \n"
				+ "    |  |     |  | |  |         |  |      /  /_\\  \\  |  |         |  |     |  |  |  | |   __|  \n"
				+ "    |  |     |  | |  `----.    |  |     /  _____  \\ |  `----.    |  |     |  `--'  | |  |____ \n"
				+ "    |__|     |__|  \\______|    |__|    /__/     \\__\\ \\______|    |__|      \\______/  |_______|\n"
				+ "                                                                                              ");
		System.out.println("***Logo*** TicTacToe- Made by Natthaphon");
		
		/**
		 * Scanner für den Spielername
		 */
		
		Scanner eingabe = new Scanner(System.in);
		

		/**
		 * Aufforderung vom Name,Anleitung und Impressum
		 */
		
		System.out.println("Bitte geben Sie Ihren Namen ein: ");
		spielername = eingabe.nextLine();

		/**
		 * Objekt wurde erstellt, und Klasse Spieler nimmt spielername als Wert
		 */
		
		computer = new CPU();
		spiel = new Spieler(spielername);

		
		System.out.println("Bräuchten Sie eine Anleitung & Impressum? JA oder NEIN:");
		
		Scanner sc = new Scanner(System.in);
		
		
		String anleit = eingabe.nextLine();
		
		
		/**
		 * Ausgabe von Anleitung, und Impressum
		 */
		
		
		if(anleit.equals("JA")){
			System.out.println("Ziel des Spiels ist es für den Spieler abwechslungsweise vor dem Computer 3 Symbole nebeneinander oder Diagonal zu setzen, "
					+ "erfüllt man das Ziel, hat man die Runde gewonnen.\n\n"
					+ "Falls der Computer 3 Symbole diagonal oder nebeneinander als 1. Setzt dann verliert der Spieler.\n"
					+"\n"
					+ "Falls alle 9 Felder belegt sind und weder Spieler noch Computer die Symbole richtig aneinandersetzen konnte, gilt die Runde als unentschieden.\n");
			
		}
		
		
		if(anleit.equals("JA")){
			System.out.println("Impressum\n"
					+ "Topomedics AG\n"
					+ "Musterstrasse 1\n"
					+ "8000 Zürich\n"
					+ "Schweiz\n"
					+ "E-Mail info@topomedics.ch\n"
					+ "Telefon +41 41 123 11 00\n\n");
			
		}
		
		

		/**
		 * Ausgabe von Spielbrett
		 */
		
		
		Spielbrett brett = new Spielbrett();

		printGameBoard(brett.getGameBoard());
		System.out.println(""
				+ "");

		
		
		

		
		
		
		

			
		
		
        while(true) {
            Scanner scan = new Scanner(System.in);
            /**
             * Erstellt Playerpos ausserhalb von Loop 
             */
            int playerPos;
            /**
             * loop zum checken ob innerhalb zwischen 1 und 9
             * Error Catcher, nur Zahlen möglich zwischen 1 - 9 und keine Buchstaben
             */
            while(true){
                System.out.println("\n ***Logo*** TOPOMEDICS: TicTacToe made by- Natthaphon Version: 1.0\n Bitte geben Sie eine Zahl zwischen (1-9) ein");

                String playerPosString = scan.nextLine();

                try{
                    playerPos = Integer.parseInt(playerPosString);
                } catch (Exception e){
                    System.out.println("\n ***Logo*** TOPOMEDICS: TicTacToe made by- Natthaphon Version: 1.0\n Bitte geben Sie eine Nummer ein");
                    continue;
                }

                if (playerPos > 9 || playerPos < 1){
                    System.out.println("\n ***Logo*** TOPOMEDICS: TicTacToe made by- Natthaphon Version: 1.0\n Bitte gebe eine Zahl zwischen 1 und 9 ein!");
                } else {
                    break;
                }
            }
			
			/**
			 * While Schleife für Position
			 */
			while (playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)) {
				System.out.println("Position schon belegt, nehmen Sie eine andere Position");
				playerPos = scan.nextInt();
			}

			placePiece(brett.getGameBoard(), playerPos, "player");
			String result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			while (playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
				cpuPos = rand.nextInt(9) + 1;
			}
			placePiece(brett.getGameBoard(), cpuPos, "cpu");
			printGameBoard(brett.getGameBoard());
			result = checkWinner();
			if (result.length() > 0) {
				System.out.println(result);
				break;
			}
        }

		}

	

	/**
	 * 
	 * @param gameBoard
	 */
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}

	/**
	 * Platzierung von Piece's
	 */
	
	public static void placePiece(char[][] gameBoard, int pos, String user) {

		char symbol = ' ';

		if (user.equals("player")) {
			symbol = 'X';
			playerPosition.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPosition.add(pos);
		}

		switch (pos) {
		case 1:
			gameBoard[0][0] = symbol;
			break;
		case 2:
			gameBoard[0][2] = symbol;
			break;
		case 3:
			gameBoard[0][4] = symbol;
			break;
		case 4:
			gameBoard[2][0] = symbol;
			break;
		case 5:
			gameBoard[2][2] = symbol;
			break;
		case 6:
			gameBoard[2][4] = symbol;
			break;
		case 7:
			gameBoard[4][0] = symbol;
			break;
		case 8:
			gameBoard[4][2] = symbol;
			break;
		case 9:
			gameBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}

	
	/**
	 * Definnierung der Gewinnkondition
	 * @return Ausgabe von Strings
	 */
	
	
	
	public static String checkWinner() {

		List topRow = Arrays.asList(1, 2, 3);
		List midRow = Arrays.asList(4, 5, 6);
		List botRow = Arrays.asList(7, 8, 9);
		List leftCol = Arrays.asList(1, 4, 7);
		List midCol = Arrays.asList(2, 5, 8);
		List rightCol = Arrays.asList(3, 6, 9);
		List cross1 = Arrays.asList(1, 5, 9);
		List cross2 = Arrays.asList(3, 5, 7);

		List<List> winConditions = new ArrayList<List>();
		winConditions.add(topRow);
		winConditions.add(midRow);
		winConditions.add(botRow);
		winConditions.add(leftCol);
		winConditions.add(midCol);
		winConditions.add(rightCol);
		winConditions.add(cross1);
		winConditions.add(cross2);

		for (List l : winConditions) {
			if (playerPosition.containsAll(l)) 
			
				/**
				 * Ausgabe von Gewinner glückwunsch Spieler
				 * Sorry CPU hat gewonnen
				 * Unentschieden
				 */
			{
				return "Glückwunsch " + spiel.getName() + " Sie haben gewonnen!";
			} else if (cpuPosition.containsAll(l)) {
				return "CPU hat gewonnen! Sorry :(";
			} else if (playerPosition.size() + cpuPosition.size() == 9) {
				return "Unentschieden";
			}
		}

		return "";
	}
}
