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

	private void showBoard() {
		int index = 1;
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

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToeGame ticTacToe = new TicTacToeGame();
		ticTacToe.board = ticTacToe.createBoard();
		char playerChoice = ticTacToe.getPlayerChoice();
		System.out.println("Player selected = " + playerChoice);
		ticTacToe.showBoard();
	}
}
