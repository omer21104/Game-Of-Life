package game_of_life;

public class Runner {
	private static Reader reader = null;
	private final static String foldPath = System.getProperty("user.dir");
	private static String fileName = "\\GliderGunSmall.txt";
	private static int TICKRATE = 1000; // rate of update
	
	public static void main(String[] args) {

		reader = new Reader(foldPath+fileName);
		int rows, cols;
		rows = reader.getRows();
		cols = reader.getCols();
		
		// first init
		GoL_Board current = new GoL_Board(rows, cols);
		current.SetBoard(Reader.getMatrix());
		while(true) {			
			current.show();
			GoL_Board next = current.nextIteration();
			System.out.println();
			current = next;
			try {
				Thread.sleep(TICKRATE);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
