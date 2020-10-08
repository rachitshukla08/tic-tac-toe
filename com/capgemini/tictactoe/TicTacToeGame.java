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
		return playerChoice;
	}

	/**
	 * UC3 Display the current state of board
	 */
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
	
	public int makeAMove() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the position at which you want to make a move on the board:");
		int position = Integer.parseInt(scanner.nextLine());
		if((position>0)&&(position<10)&&board[position]==' ')
			return position;
		else 
			return 0;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to TicTacToe game");
		TicTacToeGame ticTacToe = new TicTacToeGame();
		//Create a board
		ticTacToe.board = ticTacToe.createBoard();
		//Get Player Choice
		char playerChoice = ticTacToe.getPlayerChoice();
		System.out.println("Player selected = " + playerChoice);
		System.out.println("Current board:");
		//Display Board
		ticTacToe.showBoard();
		//Check if user entered valid position
		int position = ticTacToe.makeAMove();
		if(position == 0)
			System.out.println("Invalid position or position already occupied");
		else 
			System.out.println("Valid position");
	}
}
