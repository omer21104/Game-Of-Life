package taskB;

import java.util.Iterator;

/**
 * 
 * @author 
 * This class implements a Game of life board
 * 
 */
public class GoL_Board extends CA
{
	/**
	 * @param rows: Number of rows
	 * @param cols: Number of columns
	 * @param board: 2d matrix or int, 1 represents alive, 0 represents dead.
	 * Init new GoL automaton with an empty board
	 */
	
	private int board[][] = null;
	private int rows, cols;
	private static GoL_Rule rule = null;
	
	public GoL_Board(int rows, int cols)
	{
		// init empty board;
		this.rows = rows;
		this.cols = cols;
		board = new int[rows][cols];
		rule = new GoL_Rule();
		
	}
	
	/**
	 * 
	 * @param board: The board to be set.
	 * Set parameter board as current board
	 */
	public void SetBoard(int[][] board)
	{
		if (board.length != this.board.length)
			return;
		// TODO Auto-generated method stub
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				this.board[i][j] = board[i][j];
			}
		}
	}

	/**
	 * @return current CA state as a String 
	 */
	public String CurrentBoardOutput()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	// TODO add methods and fields as needed.
	// method to iterate over the board and apply rules to each cell
	public GoL_Board nextIteration() {
		// generate next board off of this one
		GoL_Board next = new GoL_Board(this.getRows(), this.getCols());
		next.SetBoard(this.board);
		
		for (int i = 0; i < this.board.length; i++) {
			for (int j = 0; j < this.board[i].length; j++) {
				// apply rules
				rule.ImplementRule(i, j, this, next);
			}
		}
		return next;
		
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void initBoard(String boardString) {
		for (int i = 0; i < boardString.length(); i++) {
			
		}
	}
	
	public int getRows() { return rows; }
	public int getCols() { return cols; }
	public int[][] getBoard() { return board; }
	
	public void setCell(int i, int j, int val) {
		board[i][j] = val;
	}
	
	public void show() {
		int[][] board = this.getBoard();
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; j < this.getCols(); j++) {
				if (board[i][j] == 1)
					System.out.print("* ");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
	}
}
