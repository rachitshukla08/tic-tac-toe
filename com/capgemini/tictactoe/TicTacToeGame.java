package com.capgemini.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	public static final int HEAD = 0;
	public static final int TAIL = 1;
	private char[] board = new char[10];
	private char computerChoice;
	private char playerChoice;

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

	public int makeAMove() {
		Scanner scanner = new Scanner(System.in);
		int position = 0;
		Player winner = determineWinner();
		if(winner==null)
		{
			System.out.println("Enter the position at which you want to make a move on the board:");
			while (true) {
				position = Integer.parseInt(scanner.nextLine());
				if ((position > 0) && (position < 10) && board[position] == ' ') {
					board[position] = playerChoice;
					return position;
				} else
					System.out.println("Invalid position or position already occupied. Please Re-Enter the position");
			}
		}
		else 
			System.out.println(winner+ " has won");
		return 0;
	}

	public boolean toss() {
		int toss = (int) Math.floor(Math.random() * 10) % 2;
		return toss == HEAD ? true : false;
	}

	public Player determineWinner() {
		if ((board[1] == playerChoice && board[2] == playerChoice && board[3] == playerChoice)
				|| (board[4] == playerChoice && board[5] == playerChoice && board[6] == playerChoice)
				|| (board[7] == playerChoice && board[8] == playerChoice && board[9] == playerChoice)
				|| (board[1] == playerChoice && board[4] == playerChoice && board[7] == playerChoice)
				|| (board[2] == playerChoice && board[5] == playerChoice && board[8] == playerChoice)
				|| (board[3] == playerChoice && board[6] == playerChoice && board[9] == playerChoice)
				|| (board[1] == playerChoice && board[5] == playerChoice && board[9] == playerChoice)) {
			return Player.Player;
		} else if ((board[1] == computerChoice && board[2] == computerChoice && board[3] == computerChoice)
				|| (board[4] == computerChoice && board[5] == computerChoice && board[6] == computerChoice)
				|| (board[7] == computerChoice && board[8] == computerChoice && board[9] == computerChoice)
				|| (board[1] == computerChoice && board[4] == computerChoice && board[7] == computerChoice)
				|| (board[2] == computerChoice && board[5] == computerChoice && board[8] == computerChoice)
				|| (board[3] == computerChoice && board[6] == computerChoice && board[9] == computerChoice)
				|| (board[1] == computerChoice && board[5] == computerChoice && board[9] == computerChoice)) {
			return Player.Computer;
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToeGame ticTacToe = new TicTacToeGame();
		ticTacToe.board = ticTacToe.createBoard();
		ticTacToe.showBoard();
		boolean isPlayerFirst = ticTacToe.toss();
		if (isPlayerFirst == true) {
			System.out.println("Player Plays First");
			char playerChoice = ticTacToe.getPlayerChoice();
			System.out.println("Player selected = " + playerChoice);
			int position = 1;
			while(position!=0) {
			position = ticTacToe.makeAMove();
			ticTacToe.showBoard();
			}
		} else {
			System.out.println("Computer Plays First");
		}
	}
}
