package ui;
import thread.ColorPrinterThread;
public class Main {
	public static final String ESC   = "\u001b[";
	public static final int YELLOW=43;
	public static final int BLUE=44;
	public static final int RED=41;
	public static void main(String[] args) {
		System.out.print(ESC+"2J");
		ColorPrinterThread yellow = new ColorPrinterThread(YELLOW, 1, 100, 10, 5);
		ColorPrinterThread blue = new ColorPrinterThread(BLUE, 11, 100, 5, 15);
		ColorPrinterThread red = new ColorPrinterThread(RED, 16, 100, 5, 35);
		yellow.start();
		blue.start();
		red.start();
		try {
			yellow.join();
			blue.join();
			red.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}