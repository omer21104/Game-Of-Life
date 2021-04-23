package taskB;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
	private static FileReader r = null;
	private static int rows;
	private static int cols;
	
	public static void main(String[] args) {
//		String test = "    32,3  ";
//		test = test.strip();
//		System.out.println(test);
//		int[] dimension = new int[2];
//		dimension[0] = Integer.valueOf(test.substring(0, test.indexOf(',')));
//		dimension[1] = Integer.valueOf(test.substring(test.indexOf(',') + 1));
//		System.out.println("[" + dimension[0] + "," + dimension[1] + "]");
//		Reader reader = new Reader("C:\\Users\\ASUS\\Dropbox\\Java\\Game Of Life\\src\\taskB\\GliderGunSmall.txt");
//		int[] dimension = getDimension();
//		System.out.println("[" + dimension[0] + "," + dimension[1] + "]");
//		String out = getStringOutput();
//		System.out.println(out);
	
	}
	
	public Reader(String path) {
		try {
			File f = new File(path);
			
			r = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] dimension = getDimension();
		rows = dimension[0];
		cols = dimension[1];
		
	}

	public static int[][] getMatrix() {
//		String out = "";
//		int i;
//		try {
//			while ((i=r.read()) != -1) {
//				out += (char)i;
//			}
//			System.out.println(out);
//				
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return out;
//		int[][] matrix = new int[rows][cols];
//		for (int i = 0; i < rows; i++) {
//			for (int j = 0; j < cols; j++) {
//				
//				int id;
//				try {
//					id = r.read();
//					System.out.print((char)id);
//					if (id != -1) {
//						//System.out.println("check");
//						if ((char)id == '*')
//							matrix[i][j] = 1;
//						else if ((char)id == ' ')
//							matrix[i][j] = 0;
//					}
//						
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
//		}
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
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out = out.strip();
		int[] dimension = new int[2];
		dimension[0] = Integer.valueOf(out.substring(0, out.indexOf(',')));
		dimension[1] = Integer.valueOf(out.substring(out.indexOf(',') + 1));
		return dimension;
	}
	
	public String getString() {
		String out = "";
		int i;
		try {
			while ((i=r.read()) != -1) {
				out += (char)i;
			}
				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public int getRows() { return rows; }
	public int getCols() { return cols; }
}
