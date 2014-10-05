package com.manual.gridgame;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Float;
import java.util.HashMap;

import javax.swing.JFrame;

/**
 * Grid Game is a class that create a window to be used to create grid based games.
 * 
 * @author Noah Eltzroth
 *
 */
public class GridGame extends JFrame implements MouseListener {
	private int rows;
	private int columns;
	private Space[][] grid;
	private GridGameListener listener;

	
	/**
	 * Initialize a Grid Game Window to contain the specified number of columns and rows along with an attached event listener.
	 * 
	 * @param columns
	 * @param rows
	 * @param listener
	 */
	public GridGame(int columns, int rows, GridGameListener listener){
		this.rows = rows;
		this.columns = columns;
		this.listener = listener;
		
		grid = new Space[rows][columns];
		for(int i=0; i < rows; i++){
			for(int j=0; j<columns; j++){
				grid[i][j] = new Space();
			}
		}
		setSize(600,600);
		setVisible(true);
		addMouseListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	/**
	 * Specify what shape and color should be displayed in the position where the row and column intersect.
	 * 
	 * @param row
	 * @param column
	 * @param shape
	 * @param color
	 */
	public void setPosition(int row, int column, Shape shape, Color color){
		grid[row][column].color = color;
		grid[row][column].shape = shape;
		repaint();
	}
	
	/**
	 * Gets the color of the shape at the specified position.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public Color getPositionColor(int row, int column){
		return grid[row][column].color;
	}
	
	/**
	 * Get the shape at the specified position.
	 * 
	 * @param row
	 * @param column
	 * @return
	 */
	public Shape getPositionShape(int row, int column){
		return grid[row][column].shape;
	}
	
	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, getWidth(), getHeight());
		int width = getWidth();
		int height = getHeight();
		
		int rHeight = height / rows;
		int cWidth = width / columns;
		
		for(int i=0; i < rows; i++){
			for(int j=0; j<columns; j++){
				setColor(g, grid[i][j].color);
				drawShape(g, cWidth, rHeight, i, j, grid[i][j].shape);
			}
		}
		
		g.setColor(java.awt.Color.BLACK);
		for(int i = 0; i < rows;  i++){	
			g.drawLine(0, rHeight * i, width, rHeight * i);
			for(int j=0; j<columns; j++){
				g.drawLine(cWidth * j, 0, cWidth * j, height);
			}
		}
	}

	private void drawShape(Graphics g, int width, int height, int r, int c, Shape shape) {
		switch(shape){
		case CIRCLE:
			g.fillOval(c*width, r * height, width, height);
			break;
		case DIAMOND:
			int x[] = {c*width+width/2, c*width+width, c*width+width/2, c*width};
			int y[] = {r*height, r*height+height/2, r*height + height, r*height+height/2};
			g.fillPolygon(x, y, 4);
			break;
		case SQUARE:
			int x2[] = {c*width, c*width+width, c*width+width, c*width};
			int y2[] = {r*height, r*height, r*height + height, r*height+height};
			g.fillPolygon(x2, y2, 4);
			break;
		case TRIANGLE:
			int x1[] = {c*width+width/2, c*width+width, c*width};
			int y1[] = {r*height,  r*height + height, r*height+height};
			g.fillPolygon(x1, y1, 3);
			break;
		case X:
			Graphics2D g2d = (Graphics2D)g;
			g2d.setStroke(new BasicStroke(10));
			g2d.draw(new Line2D.Float(c*width, r*height, c*width+width, r*height+height));
			g2d.draw(new Line2D.Float(c*width+width, r*height, c*width, r*height+height));
			g2d.setStroke(new BasicStroke(1));
			break;
		}
	}

	private void setColor(Graphics g, Color c){
		switch(c){
		case BLACK:
			g.setColor(java.awt.Color.BLACK);
			break;
		case GREEN:
			g.setColor(java.awt.Color.GREEN);
			break;
		case BLUE:
			g.setColor(java.awt.Color.BLUE);
			break;
		case ORANGE:
			g.setColor(java.awt.Color.ORANGE);
			break;
		case PINK:
			g.setColor(java.awt.Color.PINK);
			break;
		case RED:
			g.setColor(java.awt.Color.RED);
			break;
		case WHITE:
			g.setColor(java.awt.Color.WHITE);
			break;
		case YELLOW:
			g.setColor(java.awt.Color.YELLOW);
			break;
			
		}
	}
	private class Space {
		public Space(){
			shape = Shape.BLANK;
			color = Color.WHITE;
		}
		public Shape shape;
		public Color color;
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		int rHeight = getHeight() / rows;
		int cWidth = getWidth() / columns;
		listener.onClick(arg0.getY()/rHeight, arg0.getX()/cWidth);
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
