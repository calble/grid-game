package com.manual.gridgame;

/**
 * This defines a contract that both the sender of the event and the receiver of the event will use to send messages.
 * @author Noah Eltzroth
 *
 */
public interface GridGameListener {
	/**
	 * When a user clicks on a grid position this method is called to inform you where they clicked.
	 * @param row
	 * @param column
	 */
	public void onClick(int row, int column);
}
