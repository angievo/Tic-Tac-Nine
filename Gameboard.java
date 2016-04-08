import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

class Gameboard extends JFrame {

	public int clickX = 0;
	public int clickY = 0;
	public Graphics g;

	public static void main(String[] args) {
		Gameboard gameboard = new Gameboard();
	}

	public Gameboard() {
		this.setTitle("Tic Tac Nine");
		this.setResizable(false);
		this.setSize(505, 528);
		this.setVisible(true);
		
		Grid grid = new Grid();

		this.setContentPane(grid);

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				int clickX = e.getX();
				int clickY = e.getY();

				System.out.println("(" + clickX + ", " + clickY + ")");

				Game game = new Game(clickX, clickY);

				System.out.println("Box " + game.getSelect());

			}

		});

	}
}