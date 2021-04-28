package game_of_life;
/**
 * 
 * @author Omer Zano
 * class to take in previous board, apply rules and return next board
 *
 */
/*
 *   Any live cell with two or three live neighbours survives.
 *   Any dead cell with three live neighbours becomes a live cell.
 *	 All other live cells die in the next generation. Similarly, all other dead cells stay dead.
 */
public class GoL_Rule implements CA_Rule
{
	private static final int NEIGHBORS = 3;
	private static final int DEAD = 0, ALIVE = 1;

	
	
	public void ImplementRule(int i, int j, GoL_Board prev, GoL_Board next)
	{
		// apply rules for cell [i,j] on next board
		int[][] prevBoard = prev.getBoard();
		int liveNeighbors = 0;
		int count = 0;
		// count live neighbors
		for (int k = i - 1; k < i - 1 + NEIGHBORS; k++) {
			for (int k2 = j - 1; k2 < j - 1 + NEIGHBORS; k2++) {
				try {

					if (k == i && k2 == j){ // ignore the cell itself
						continue;
					}

					int val = prevBoard[k][k2];
					if (val == 1)
						liveNeighbors++;
	
				} catch (IndexOutOfBoundsException e)
				{
					// handle cases where the index exceeds the matrix
					
				}

			}
		}
	
		// rule set
		if (prevBoard[i][j] == 1) { // alive
			if (liveNeighbors < 2 || liveNeighbors > 3) {
				// kill off cells with not enough neighbors
				// or too many neighbors
				next.setCell(i, j, DEAD);
			}
		}
		else { // dead
			if (liveNeighbors == 3) // revive the cell
				next.setCell(i, j, ALIVE);
		}
	}

}
