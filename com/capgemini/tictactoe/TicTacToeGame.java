package com.capgemini.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {
	private char[] board = new char[10];
	private char computerChoice;
	private char playerChoice;

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
		scanner.close();
		return playerChoice;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToeGame ticTacToe = new TicTacToeGame();
		ticTacToe.board = ticTacToe.createBoard();
		char playerChoice = ticTacToe.getPlayerChoice();
		System.out.println("Player selected = " + playerChoice);
	}
}
