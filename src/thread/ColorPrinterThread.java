package thread;
import java.io.IOException;

import model.FlagColorPrinter;
public class ColorPrinterThread extends Thread{
	private FlagColorPrinter fcp;
	public ColorPrinterThread(int color, int position, int width, int height, int sleep) {
		fcp = new FlagColorPrinter(color, position, width, height, sleep);
	}
	@Override
	public void run() {
		try {
			fcp.initialize();
		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}
}