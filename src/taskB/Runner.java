package taskB;

public class Runner {
	private static Reader reader = null;
	private final static String foldPath = "C:\\Users\\ASUS\\Dropbox\\Java\\Game Of Life\\src\\taskB";
	private static String fileName = "\\GliderGunSmall.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			//next.show();
			current = next;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
