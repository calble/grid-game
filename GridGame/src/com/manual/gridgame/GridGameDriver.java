package com.manual.gridgame;

import javax.swing.JOptionPane;

/**
 * Ignore this class, it is used to test the library.
 * @author Noah Eltzroth
 *
 */
public class GridGameDriver implements GridGameListener {
	public static GridGame gg;
	private String currentPlayer = "x";
	
	public static void main(String[] args){
		//Explain the game to the user
		JOptionPane.showMessageDialog(null, "This is a fun game.");
		//Setup the board
		gg = new GridGame(3, 3, new GridGameDriver());
	}

	public void onClick(int row, int column) {
		//Do stuff when the user clicks on the screen
		if(gg.getPositionShape(row, column) == Shape.BLANK){
			if(currentPlayer.equals("x")){
				gg.setPosition(row, column, Shape.SQUARE, Color.RED);
				currentPlayer = "o";
			}else{
				gg.setPosition(row, column, Shape.CIRCLE, Color.BLUE);
				currentPlayer = "x";
			}
		}
		//Check for a winner
		
	}
}

