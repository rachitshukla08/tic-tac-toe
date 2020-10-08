package com.capgemini.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	public static final int HEAD = 0;
	public static final int TAIL = 1;
	private char[] board = new char[10];
	private char computerChoice;
	private char playerChoice;
	private int totalMoves = 0;

	public static enum Player {
		Player, Computer
	}

	/**
	 * UC1
	 * 
	 * @return boardElement array with empty board
	 */
	private char[] createBoard() {
		for (int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
		return board;
	}

	/**
	 * UC2
	 * 
	 * @return Player Choice
	 */
	private char getPlayerChoice() {
		Scanner scanner = new Scanner(System.in);
		char choice = 0;
		while (choice != 'X' && choice != 'O') {
			System.out.println("Do you want to play as X or O?");
			choice = scanner.nextLine().charAt(0);
			playerChoice = choice == 'X' ? 'X' : 'O';
			computerChoice = choice == 'X' ? 'O' : 'X';
		}
		return playerChoice;
	}

	/**
	 * UC3 Display the current state of board
	 */
	private void showBoard() {
		int index = 1;
		System.out.println("Current board:");
		System.out.println(" -------------");
		for (int rows = 1; rows <= 3; rows++) {
			for (int columns = 1; columns <= 3; columns++) {
				System.out.print(" | ");
				System.out.print(board[index]);
				index++;
			}
			System.out.print(" | ");
			System.out.println("\n -------------");
		}
	}

	/**
	 * UC7 Move and check for winner
	 * 
	 * @param player
	 * @return position
	 */
	public int makeAMove(Player player) {
		Scanner scanner = new Scanner(System.in);
		int position = 0;
		Player winner = null;
		while (winner == null && totalMoves < 9) {
			if (player.equals(Player.Player)) {
				System.out.println("Enter the position for PLAYER at which you want to make a move on the board:");
				while (true) {
					position = Integer.parseInt(scanner.nextLine());
					if ((position > 0) && (position < 10) && board[position] == ' ') {
						board[position] = playerChoice;
						player = Player.Computer;
						totalMoves++;
						System.out.println("Total moves: " + totalMoves);
						showBoard();
						winner = determineWinner();
						break;
					} else
						System.out
								.println("Invalid position or position already occupied. Please Re-Enter the position");
				}
			} else if (player.equals(Player.Computer)) {
				System.out.println("Computer's Turn:");
				playComputerMove();
				totalMoves++;
				System.out.println("Total moves: " + totalMoves);
				showBoard();
				winner = determineWinner();
				player = Player.Player;
			}
		}
		if (totalMoves == 9)
			System.out.println("Match tied");
		else
			System.out.println(winner + " has won");
		return 0;
	}

	public void playComputerMove() {

		/*
		 * WIN rows row1
		 */
		if (board[1] == computerChoice && board[2] == computerChoice && board[3] == ' ')
			board[3] = computerChoice;
		else if (board[1] == computerChoice && board[3] == computerChoice && board[2] == ' ')
			board[2] = computerChoice;
		else if (board[2] == computerChoice && board[3] == computerChoice && board[1] == ' ')
			board[1] = computerChoice;
		// row2
		else if (board[4] == computerChoice && board[5] == computerChoice && board[6] == ' ')
			board[6] = computerChoice;
		else if (board[5] == computerChoice && board[6] == computerChoice && board[4] == ' ')
			board[4] = computerChoice;
		else if (board[4] == computerChoice && board[6] == computerChoice && board[5] == ' ')
			board[5] = computerChoice;
		// row3
		else if (board[7] == computerChoice && board[8] == computerChoice && board[9] == ' ')
			board[9] = computerChoice;
		else if (board[8] == computerChoice && board[9] == computerChoice && board[7] == ' ')
			board[7] = computerChoice;
		else if (board[7] == computerChoice && board[9] == computerChoice && board[8] == ' ')
			board[8] = computerChoice;
		// columns:
		// column1:
		else if (board[1] == computerChoice && board[4] == computerChoice && board[7] == ' ')
			board[7] = computerChoice;
		else if (board[1] == computerChoice && board[7] == computerChoice && board[4] == ' ')
			board[4] = computerChoice;
		else if (board[4] == computerChoice && board[7] == computerChoice && board[1] == ' ')
			board[1] = computerChoice;
		// column2
		else if (board[2] == computerChoice && board[5] == computerChoice && board[8] == ' ')
			board[8] = computerChoice;
		else if (board[2] == computerChoice && board[8] == computerChoice && board[5] == ' ')
			board[5] = computerChoice;
		else if (board[5] == computerChoice && board[8] == computerChoice && board[2] == ' ')
			board[2] = computerChoice;
		// column3
		else if (board[3] == computerChoice && board[6] == computerChoice && board[9] == ' ')
			board[9] = computerChoice;
		else if (board[3] == computerChoice && board[9] == computerChoice && board[6] == ' ')
			board[6] = computerChoice;
		else if (board[6] == computerChoice && board[9] == computerChoice && board[3] == ' ')
			board[3] = computerChoice;
		// diagonals
		// diagonal1
		else if (board[1] == computerChoice && board[5] == computerChoice && board[9] == ' ')
			board[9] = computerChoice;
		else if (board[1] == computerChoice && board[9] == computerChoice && board[5] == ' ')
			board[5] = computerChoice;
		else if (board[5] == computerChoice && board[9] == computerChoice && board[1] == ' ')
			board[1] = computerChoice;
		// diagonal2
		else if (board[3] == computerChoice && board[5] == computerChoice && board[7] == ' ')
			board[7] = computerChoice;
		else if (board[3] == computerChoice && board[7] == computerChoice && board[5] == ' ')
			board[5] = computerChoice;
		else if (board[5] == computerChoice && board[7] == computerChoice && board[3] == ' ')
			board[3] = computerChoice;
		// BLOCK player from winning
		// row1
		else if (board[1] == playerChoice && board[2] == playerChoice && board[3] == ' ')
			board[3] = computerChoice;
		else if (board[1] == playerChoice && board[3] == playerChoice && board[2] == ' ')
			board[2] = computerChoice;
		else if (board[2] == playerChoice && board[3] == playerChoice && board[1] == ' ')
			board[1] = computerChoice;
		// row2
		else if (board[4] == playerChoice && board[5] == playerChoice && board[6] == ' ')
			board[6] = computerChoice;
		else if (board[5] == playerChoice && board[6] == playerChoice && board[4] == ' ')
			board[4] = computerChoice;
		else if (board[4] == playerChoice && board[6] == playerChoice && board[5] == ' ')
			board[5] = computerChoice;
		// row3
		else if (board[7] == playerChoice && board[8] == playerChoice && board[9] == ' ')
			board[9] = computerChoice;
		else if (board[8] == playerChoice && board[9] == playerChoice && board[7] == ' ')
			board[7] = computerChoice;
		else if (board[7] == playerChoice && board[9] == playerChoice && board[8] == ' ')
			board[8] = computerChoice;
		// columns:
		// column1:
		else if (board[1] == playerChoice && board[4] == playerChoice && board[7] == ' ')
			board[7] = computerChoice;
		else if (board[1] == playerChoice && board[7] == playerChoice && board[4] == ' ')
			board[4] = computerChoice;
		else if (board[4] == playerChoice && board[7] == playerChoice && board[1] == ' ')
			board[1] = computerChoice;
		// column2
		else if (board[2] == playerChoice && board[5] == playerChoice && board[8] == ' ')
			board[8] = computerChoice;
		else if (board[2] == playerChoice && board[8] == playerChoice && board[5] == ' ')
			board[5] = computerChoice;
		else if (board[5] == playerChoice && board[8] == playerChoice && board[2] == ' ')
			board[2] = computerChoice;
		// column3
		else if (board[3] == playerChoice && board[6] == playerChoice && board[9] == ' ')
			board[9] = computerChoice;
		else if (board[3] == playerChoice && board[9] == playerChoice && board[6] == ' ')
			board[6] = computerChoice;
		else if (board[6] == playerChoice && board[9] == playerChoice && board[3] == ' ')
			board[3] = computerChoice;
		// diagonals
		// diagonal1
		else if (board[1] == playerChoice && board[5] == playerChoice && board[9] == ' ')
			board[9] = computerChoice;
		else if (board[1] == playerChoice && board[9] == playerChoice && board[5] == ' ')
			board[5] = computerChoice;
		else if (board[5] == playerChoice && board[9] == playerChoice && board[1] == ' ')
			board[1] = computerChoice;
		// diagonal2
		else if (board[3] == playerChoice && board[5] == playerChoice && board[7] == ' ')
			board[7] = computerChoice;
		else if (board[3] == playerChoice && board[7] == playerChoice && board[5] == ' ')
			board[5] = computerChoice;
		else if (board[5] == playerChoice && board[7] == playerChoice && board[3] == ' ')
			board[3] = computerChoice;
		else
			placeRandomly();

	}

	/**
	 * Allowing computer to place randomly at any corner if none of the players is
	 * winning
	 */
	public void placeRandomly() {
		int computerTurn = 0;
		if (board[1] == ' ' || board[3] == ' ' || board[7] == ' ' || board[9] == ' ') {
			while (true) {
				computerTurn = (int) Math.floor((Math.random() * 10)) % 4;
				System.out.println("Computer turn : "+computerTurn);
				if (computerTurn == 0 && board[1] == ' ') {
					board[1] = computerChoice;
					break;
				} else if (computerTurn == 1 && board[3] == ' ') {
					board[3] = computerChoice;
					break;
				} else if (computerTurn == 2 && board[7] == ' ') {
					board[7] = computerChoice;
					break;
				} else if (computerTurn == 3 && board[9] == ' ') {
					board[9] = computerChoice;
					break;
				}
			}
		} 
		else {
			while (true) {
				computerTurn = 1 + (int) Math.floor((Math.random() * 10)) % 9;
				if (board[computerTurn] == ' ') {
					board[computerTurn] = computerChoice;
					break;
				}
			}
		}

	}

	public Player toss() {
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		return toss == HEAD ? Player.Player : Player.Computer;
	}

	public Player determineWinner() {
		if ((board[1] == playerChoice && board[2] == playerChoice && board[3] == playerChoice)
				|| (board[4] == playerChoice && board[5] == playerChoice && board[6] == playerChoice)
				|| (board[7] == playerChoice && board[8] == playerChoice && board[9] == playerChoice)
				|| (board[1] == playerChoice && board[4] == playerChoice && board[7] == playerChoice)
				|| (board[2] == playerChoice && board[5] == playerChoice && board[8] == playerChoice)
				|| (board[3] == playerChoice && board[6] == playerChoice && board[9] == playerChoice)
				|| (board[1] == playerChoice && board[5] == playerChoice && board[9] == playerChoice)
				|| (board[3] == playerChoice && board[5] == playerChoice && board[7] == playerChoice)) {
			return Player.Player;
		} else if ((board[1] == computerChoice && board[2] == computerChoice && board[3] == computerChoice)
				|| (board[4] == computerChoice && board[5] == computerChoice && board[6] == computerChoice)
				|| (board[7] == computerChoice && board[8] == computerChoice && board[9] == computerChoice)
				|| (board[1] == computerChoice && board[4] == computerChoice && board[7] == computerChoice)
				|| (board[2] == computerChoice && board[5] == computerChoice && board[8] == computerChoice)
				|| (board[3] == computerChoice && board[6] == computerChoice && board[9] == computerChoice)
				|| (board[1] == computerChoice && board[5] == computerChoice && board[9] == computerChoice)
				|| (board[3] == computerChoice && board[5] == computerChoice && board[7] == computerChoice)) {
			return Player.Computer;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToeGame ticTacToe = new TicTacToeGame();
		ticTacToe.board = ticTacToe.createBoard();
		ticTacToe.showBoard();
		Player player = ticTacToe.toss();
		if (player.equals(Player.Player)) {
			System.out.println("Player Plays First");
			char playerChoice = ticTacToe.getPlayerChoice();
			System.out.println("Player selected = " + playerChoice);
			if (playerChoice == 'X')
				ticTacToe.computerChoice = 'O';
			else
				ticTacToe.computerChoice = 'X';
			int position = 1;
			while (position != 0) {
				position = ticTacToe.makeAMove(player);
				ticTacToe.showBoard();
			}
		} else {
			System.out.println("Computer Plays First");
			int position = 1;
			ticTacToe.computerChoice = 'X';
			System.out.println("Computer selected: " + ticTacToe.computerChoice);
			ticTacToe.playerChoice = 'O';
			while (position != 0) {
				position = ticTacToe.makeAMove(player);
				ticTacToe.showBoard();
			}
		}
	}
}
