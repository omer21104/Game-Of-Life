package game_of_life;

/**
 * 	@author Omer Zano
 *  class to handle initial read from file and convert to a matrix
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	private static FileReader r = null;
	private static int rows;
	private static int cols;

	
	public Reader(String path) {
		try {
			File f = new File(path);
			
			r = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int[] dimension = getDimension();
		rows = dimension[0];
		cols = dimension[1];
		
	}

	public static int[][] getMatrix() {
		int[][] matrix = new int[rows][cols];
		int id,i = 0,j = 0;
		
		try {
			while ((id=r.read()) != -1) {
				if ((char)id == '*') {
					matrix[i][j] = 1;
					j++;
				}
				else if ((char)id == ' ') {
					matrix[i][j] = 0;
					j++;
				}
				if ((char)id == '\n') {
					j = 0;
					i++;
				}
			}
				
		} catch (IOException e) {
			e.printStackTrace();
		}
		return matrix;
	}
	public static int[] getDimension() {
		// expect first line to contain dimensions in the form of n,m
		String out = "";
		int i;
		try {
			while ((i=r.read()) != (int)'\n') {
				out += (char)i;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		out = out.strip();
		int[] dimension = new int[2];
		dimension[0] = Integer.valueOf(out.substring(0, out.indexOf(',')));
		dimension[1] = Integer.valueOf(out.substring(out.indexOf(',') + 1));
		return dimension;
	}
	
	public int getRows() { return rows; }
	public int getCols() { return cols; }
}
