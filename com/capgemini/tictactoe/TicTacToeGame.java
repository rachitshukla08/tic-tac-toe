package com.capgemini.tictactoe;

import java.util.Scanner;

public class TicTacToeGame {

	/**
	 * UC1
	 * 
	 * @return boardElement array with empty board
	 */
	private char[] createBoard() {
		char[] board = new char[10];
		for (int index = 1; index < board.length; index++) {
			board[index] = ' ';
		}
		return board;
	}

	/**
	 * UC2
	 * 
	 * @return Whether input is by player or computer
	 */
	private String getInput() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter X or O");
		char input = scanner.nextLine().charAt(0);
		scanner.close();
		if (input == 'X')
			return "Input is entered by player";
		else if (input == 'O')
			return "Input is entered by computer";
		else
			return "Invalid Input";
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToeGame ticTacToe = new TicTacToeGame();
		char[] board = ticTacToe.createBoard();
		String inputIsBy = ticTacToe.getInput();
		System.out.println(inputIsBy);
	}
}
