import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Display extends JPanel {

	public int j;
	public int k;
	public Graphics g;
	public BufferedImage img;
	public String file;

	public Display() {
	}
	
	public void draw() {
		repaint();
	}

	public void load(String file) {
		try {
			img = ImageIO.read(new File(file));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		load("gameboard.png");
		paint(g, 0, 0);	
		

	}

	public void paint(Graphics g, int j, int k) {
		g.drawImage(img, j, k, null);
	}

}