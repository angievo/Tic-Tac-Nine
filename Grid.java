import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Grid extends JPanel{

	public Grid() {
		
	}
	
	public void drawGrid() {
		repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.fill3DRect(55, 20, 3, 130, true);
		g.fill3DRect(105, 20, 3, 130, true);
		g.fill3DRect(15, 55, 130, 3, true);
		g.fill3DRect(15, 105, 130, 3, true);
		
	}

}

//public void createAndDisplayGUI2() {
//	ArrayList<String> moves = new ArrayList<String>();
//	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//
//	JPanel contentPane = new JPanel();
//	contentPane.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
//
//	JPanel leftPanel = new JPanel();
//	leftPanel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
//	leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
//	JPanel labelPanel = new JPanel();
//	JPanel buttonLeftPanel = new JPanel();
//	resetButton = new JButton("Reset");
//	resetButton.addActionListener(new ActionListener() {
//		public void actionPerformed(ActionEvent ae) {
//
//		}
//	});
//	buttonLeftPanel.add(resetButton);
//	leftPanel.add(labelPanel);
//	leftPanel.add(buttonLeftPanel);
//	contentPane.add(leftPanel);
//	JPanel buttonPanel = new JPanel();
//	buttonPanel.setLayout(new GridLayout(gridSize, gridSize, 0, 0));
//	for (int i = 0; i < gridSize; i++) {
//		for (int j = 0; j < gridSize; j++) {
//			JButton button = new JButton();
//			if (i == 0 && j == 0) {
//				button.setName(String.valueOf("1"));
//			}
//			if (i == 0 && j == 1) {
//				button.setName(String.valueOf("2"));
//			}
//			if (i == 0 && j == 2) {
//				button.setName(String.valueOf("3"));
//			}
//			if (i == 1 && j == 0) {
//				button.setName(String.valueOf("4"));
//			}
//			if (i == 1 && j == 1) {
//				button.setName(String.valueOf("5"));
//			}
//			if (i == 1 && j == 2) {
//				button.setName(String.valueOf("6"));
//			}
//			if (i == 2 && j == 0) {
//				button.setName(String.valueOf("7"));
//			}
//			if (i == 2 && j == 1) {
//				button.setName(String.valueOf("8"));
//			}
//			if (i == 2 && j == 2) {
//				button.setName(String.valueOf("9"));
//			}
//			button.setEnabled(true);
//			button.setPreferredSize(new Dimension(50, 50));
//			button.setBackground(Color.pink);
//			button.setFont(new Font("Lucida Calligraphy", Font.BOLD, 50));
//			button.setActionCommand(i + "," + j);
//			button.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent ae) {
//					if (turn == true && !button.getText().equals("X") && !button.getText().equals("O")) {
//						button.setText("X");
//						System.out.println(button.getName());
//						turn = false;
//					} else if (!button.getText().equals("X") && !button.getText().equals("O")) {
//						button.setText("O");
//						System.out.println(button.getName());
//						turn = true;
//					}
//
//					moves.add(button.getName() + ", " + button.getText());
//
//					if (moves.contains("1, X") && moves.contains("2, X") && moves.contains("3, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} 
//					if (moves.contains("4, X") && moves.contains("5, X") && moves.contains("6, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} if (moves.contains("7, X") && moves.contains("8, X") && moves.contains("9, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} if (moves.contains("1, X") && moves.contains("4, X") && moves.contains("7, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} if (moves.contains("2, X") && moves.contains("5, X") && moves.contains("8, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} if (moves.contains("3, X") && moves.contains("6, X") && moves.contains("9, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} if (moves.contains("1, X") && moves.contains("5, X") && moves.contains("9, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} if (moves.contains("3, X") && moves.contains("5, X") && moves.contains("7, X")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//
//					}
//					if (moves.contains("1, O") && moves.contains("2, O") && moves.contains("3, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("4, O") && moves.contains("5, O") && moves.contains("6, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("7, O") && moves.contains("8, O") && moves.contains("9, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("1, O") && moves.contains("4, O") && moves.contains("7, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("2, O") && moves.contains("5, O") && moves.contains("8, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("3, O") && moves.contains("6, O") && moves.contains("9, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("1, O") && moves.contains("5, O") && moves.contains("9, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//					} else if (moves.contains("3, O") && moves.contains("5, O") && moves.contains("7, O")) {
//						setVisible(false);
//						dispose();
//						list.add(button.getText());
//						System.out.println(list);
//
//					}
//				}
//			});
//
//			buttonPanel.add(button);
//		}
//	}
//	contentPane.add(buttonPanel);
//	setContentPane(contentPane);
//	pack();
//	setLocationByPlatform(true);
//	setVisible(true);
//}



