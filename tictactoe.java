package collection;

import java.util.ArrayList;
import java.util.Scanner;

public class tictactoe {

	private static final int ROWS = 3;
	// privat this will make datatype to be present in same class  
	// final will make it the constant it cannot be changed

	private static final int COLUMNS = 3;

	private static ArrayList<Character> board = new ArrayList<>();
	//Array list was introduced from JDK 1.2
	//array list has four specification of the list interface is followed by arraylist.List ,RandomAcess, Cloneable,Seializable
	//the initial capacity of array list is 10

	private static char currentPlayer = 'X';
	//private datatype which can be accessed by the same class only and the type of data stored is char primitive

	public static void main(String[] args) {
		initBoard();
		playGame();
	}
	//the main function is the only one which will be excecuted is having the two mwthods inside it
	//1]initBoard()
	//2]playGame() 

	private static void initBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				board.add(' ');
			}
		}
	}
	//we call the initBoard method in private and static means it can be accesed by only the same class and and it is static can be called anywhere inside the class 
	//here the for loop is used where the 3x3 2dimensional array is created
	//here where the refrence we called for arraylist board here in board the empty character is added


	private static void playGame() {
		Scanner scanner = new Scanner(System.in);
		//we will implement the method playGame which is private and static
		//Scanner sc will be implemented

		while (true) {
			//this while loop will be always running because it will always be true.
			printBoard();
			//we will call another method peintBoard() which willl be called

			System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
			//this will print player x or O enter move 1-9

			int move = scanner.nextInt();
			//the input number is given to the move

			if (move < 1 || move > 9) {
				// if the entered number is less than 1 or greater than 9 than it will prnt invalid
				System.out.println("Invalid move.");
				continue;
			}

			if (board.get(move - 1) != ' ') {
				// if the entered value is already given before this if statement is used 
				System.out.println("The cell is already occupied.");
				continue;
			}

			board.set(move - 1, currentPlayer);
			// if the above if conditions are false then this statement will be excecuted 
			// where it will set the board value

			if (checkWinner()) {
				// after setting the value inside the board it will see if the above method is true or false
				// if it is true then it will break the while loop
				break;
			}

			currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			// the ternaary operator if the current operator is x then the operator will be 0 
			//if the current operator is 0 then the operator is x
		}

		printBoard();
		// the another method printBoard is called named as printBoard()
		if (currentPlayer == 'X') {
			System.out.println("Player X wins!");
			//if currentplayer ==x it will print 0 wins
		} else {
			System.out.println("Player O wins!");
			//if currentplayer ==y it will print x wins
		}
	}

	private static boolean checkWinner() {
		//here the method will return the boolean values
		for (int i = 0; i < ROWS; i++) {
			if (board.get(i * COLUMNS) == board.get(i * COLUMNS + 1) &&
					board.get(i * COLUMNS + 1) == board.get(i * COLUMNS + 2) &&
					board.get(i * COLUMNS) != ' ') {
				return true;
			}
		}
		// if we value column wise winner 

		for (int i = 0; i < COLUMNS; i++) {
			if (board.get(i) == board.get(i + ROWS) &&
					board.get(i + ROWS) == board.get(i + 2 * ROWS) &&
					board.get(i) != ' ') {
				return true;
			}
		}

		if (board.get(0) == board.get(4) &&
				board.get(4) == board.get(8) &&
				board.get(0) != ' ') {
			return true;
		}

		if (board.get(2) == board.get(4) &&
				board.get(4) == board.get(6) &&
				board.get(2) != ' ') {
			return true;
		}

		return false;
	}

	private static void printBoard() {
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLUMNS; j++) {
				System.out.print(board.get(i * COLUMNS + j) + " ");

			}
			System.out.println();
			// 0 1 2 
			// 3 4 5
			// 6 7 8
		}
	}

}