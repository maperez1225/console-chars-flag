package model;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class FlagColorPrinter {
	public final static String ESC   = "\u001b[";
	public final static String DOWN  = ESC+"B";
	private int color;
	private int position;
	private int width;
	private int height;
	private int sleep;
	private int x;
	private BufferedWriter bw;
	public FlagColorPrinter(int c, int p, int w, int h, int s) {
		color = c;
		position = p;
		width = w;
		height = h;
		sleep = s;
		x=1;
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void initialize() throws InterruptedException, IOException {
		while (x < width) {
			printColumn();
			x++;
		}
	}
	public void printColumn() throws InterruptedException, IOException {
		for (int i = 0; i < height; i++) {
				printBox(i);
				Thread.sleep(sleep);
		}
	}
	public void printBox(int i) throws IOException{
		bw.write(ESC+(position+i)+";"+x+"f");
		bw.write(ESC+color+"m ");
		bw.flush();
	}
}