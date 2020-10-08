package com.capgemini.tictactoe;

public class TicTacToeGame {

	/**
	 * @return boardElement array with empty board
	 */
	public char[] createBoard() {
		char[] boardElement = new char[10];
		for (int index = 1; index < boardElement.length; index++) {
			boardElement[index] = ' ';
		}
		return boardElement;
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToe = new TicTacToeGame();
		char[] boardElement = ticTacToe.createBoard();
	}
}
