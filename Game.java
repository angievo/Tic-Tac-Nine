import java.awt.Graphics;

import javax.swing.JFrame;

public class Game extends JFrame {

	public int m;
	public int n;
	public Graphics g;
	public int select;
	public Game game;

	public Game(int m, int n) {

		if (m < 170 && n < 196) {
			select = 1;
		}
		if (m >= 170 && m < 336 && n < 196) {
			select = 2;
		}
		if (m >= 336 && n < 196) {
			select = 3;
		}
		if (m < 170 && n >= 196 && n < 362) {
			select = 4;
		}
		if (m >= 170 && m < 336 && n >= 196 && n < 362) {
			select = 5;
		}
		if (m >= 336 && n >= 196 && n < 362) {
			select = 6;
		}
		if (m < 170 && n >= 196 && n >= 362) {
			select = 7;
		}
		if (m >= 170 && m < 336 && n >= 362) {
			select = 8;
		}
		if (m >= 336 && n >= 196 && n >= 362) {
			select = 9;
		}

	}

	public int getSelect(){
		return select;
	}

}