//Angie Vo

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class Board extends JFrame {
	private JButton resetButton;
	private JButton exitButton;
	private JButton tournament;
	private static int gridSize = 3;
	public boolean turn = true;
	public static ArrayList<String> list = new ArrayList<String>();
	public static ArrayList<String> master = new ArrayList<String>();
	public static ArrayList<JButton> buttons = new ArrayList<JButton>();
	public static int count = 0;
	public static int fCount = 0;
	public boolean on = false;
	public int a = 0;
	public static boolean tMode = false;
	public static int xScore = 0;
	public static int oScore = 0;

	public Board() {
		super("Tic Tac Nine");
	}

	public void createAndDisplayGUI() {

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel contentPane = new JPanel();
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));

		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		resetButton = new JButton("Restart");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				dispose();
				list.clear();
				master.clear();
				buttons.clear();
				count = 0;
				Board board = new Board();
				board.createAndDisplayGUI();
			}
		});

		leftPanel.add(resetButton);

		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				setVisible(false);
				dispose();
				list.clear();
				master.clear();
				buttons.clear();
				count = 0;
			}
		});

		leftPanel.add(exitButton);
		
		if (xScore == 0 && oScore == 0) {

		tournament = new JButton("Tournament mode: Best of 3");
		tournament.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (tMode == false) {
					tMode = true;
					setSize(1000, 1000);
					setLocationRelativeTo(null);
					setDefaultCloseOperation(EXIT_ON_CLOSE);
					setVisible(true);
				}
			}
		});

		leftPanel.add(tournament);
		
		}

		contentPane.add(leftPanel);

		JPanel buttonPanel = new JPanel();

		buttonPanel.setLayout(new GridLayout(gridSize, gridSize, 0, 0));
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				JButton button = new JButton();
				if (i == 0 && j == 0) {
					button.setName(String.valueOf("1"));
				}
				if (i == 0 && j == 1) {
					button.setName(String.valueOf("2"));
				}
				if (i == 0 && j == 2) {
					button.setName(String.valueOf("3"));
				}
				if (i == 1 && j == 0) {
					button.setName(String.valueOf("4"));
				}
				if (i == 1 && j == 1) {
					button.setName(String.valueOf("5"));
				}
				if (i == 1 && j == 2) {
					button.setName(String.valueOf("6"));
				}
				if (i == 2 && j == 0) {
					button.setName(String.valueOf("7"));
				}
				if (i == 2 && j == 1) {
					button.setName(String.valueOf("8"));
				}
				if (i == 2 && j == 2) {
					button.setName(String.valueOf("9"));
				}
				button.setEnabled(true);
				button.setPreferredSize(new Dimension(250, 250));
				button.setBackground(Color.pink);
				button.setFont(new Font("Lucida Handwriting", Font.BOLD, 275));
				button.setActionCommand(i + "," + j);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						if (tMode == false) {
							leftPanel.remove(tournament);
							leftPanel.revalidate();
							leftPanel.repaint();
						}
						if (on == false && button.getText() == "") {
							on = true;
							buttons.add(button);
							list.add(button.getName());
							System.out.println(list);
							ArrayList<String> moves = new ArrayList<String>();
							setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							JPanel buttonPanel = new JPanel();
							buttonPanel.setLayout(new GridLayout(gridSize, gridSize, 0, 0));
							for (int i = 0; i < gridSize; i++) {
								for (int j = 0; j < gridSize; j++) {
									JButton button = new JButton();
									if (i == 0 && j == 0) {
										button.setName(String.valueOf("1"));
									}
									if (i == 0 && j == 1) {
										button.setName(String.valueOf("2"));
									}
									if (i == 0 && j == 2) {
										button.setName(String.valueOf("3"));
									}
									if (i == 1 && j == 0) {
										button.setName(String.valueOf("4"));
									}
									if (i == 1 && j == 1) {
										button.setName(String.valueOf("5"));
									}
									if (i == 1 && j == 2) {
										button.setName(String.valueOf("6"));
									}
									if (i == 2 && j == 0) {
										button.setName(String.valueOf("7"));
									}
									if (i == 2 && j == 1) {
										button.setName(String.valueOf("8"));
									}
									if (i == 2 && j == 2) {
										button.setName(String.valueOf("9"));
									}
									button.setEnabled(true);
									button.setPreferredSize(new Dimension(200, 200));
									button.setBackground(Color.pink);
									button.setFont(new Font("Century", Font.BOLD, 200));
									button.addActionListener(new ActionListener() {
										public void actionPerformed(ActionEvent ae) {

											if (turn == true && !button.getText().equals("X")
													&& !button.getText().equals("O")) {
												button.setText("X");
												turn = false;
											} else if (!button.getText().equals("X") && !button.getText().equals("O")) {
												button.setText("O");
												turn = true;
											}

											moves.add(button.getName() + ", " + button.getText());

											if (moves.contains("1, X") && moves.contains("2, X")
													&& moves.contains("3, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;

												if (master.contains("(1, O)") && master.contains("(2, O)")
														&& master.contains("(3, O)")) {
													oWins();
												} else if (master.contains("(4, O)") && master.contains("(5, O)")
														&& master.contains("(6, O)")) {
													oWins();
												} else if (master.contains("(7, O)") && master.contains("(8, O)")
														&& master.contains("(9, O)")) {
													oWins();
												} else if (master.contains("(1, O)") && master.contains("(4, O)")
														&& master.contains("(7, O)")) {
													oWins();
												} else if (master.contains("(2, O)") && master.contains("(5, O)")
														&& master.contains("(8, O)")) {
													oWins();
												} else if (master.contains("(3, O)") && master.contains("(6, O)")
														&& master.contains("(9, O)")) {
													oWins();
												} else if (master.contains("(1, O)") && master.contains("(5, O)")
														&& master.contains("(9, O)")) {
													oWins();
												} else if (master.contains("(3, O)") && master.contains("(5, O)")
														&& master.contains("(7, O)")) {
													oWins();
												} else if (master.contains("(1, X)") && master.contains("(2, X)")
														&& master.contains("(3, X)")) {
													xWins();
												} else if (master.contains("(4, X)") && master.contains("(5, X)")
														&& master.contains("(6, X)")) {
													xWins();
												} else if (master.contains("(7, X)") && master.contains("(8, X)")
														&& master.contains("(9, X)")) {
													xWins();
												} else if (master.contains("(1, X)") && master.contains("(4, X)")
														&& master.contains("(7, X)")) {
													xWins();
												} else if (master.contains("(2, X)") && master.contains("(5, X)")
														&& master.contains("(8, X)")) {
													xWins();
												} else if (master.contains("(3, X)") && master.contains("(6, X)")
														&& master.contains("(9, X)")) {
													xWins();
												} else if (master.contains("(1, X)") && master.contains("(5, X)")
														&& master.contains("(9, X)")) {
													xWins();
												} else if (master.contains("(3, X)") && master.contains("(5, X)")
														&& master.contains("(7, X)")) {
													xWins();
												} else {
													fCount++;
													if (fCount % 9 == 0) {
														JFrame frame = new JFrame("Tie");
														JLabel label = new JLabel("It's a tie!", JLabel.CENTER);
														frame.setSize(900, 900);
														label.setFont(new Font("Comic Sans", Font.PLAIN, 200));
														frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
														frame.add(label);
														frame.pack();
														frame.setLocationRelativeTo(null);
														frame.setVisible(true);
													}
												}

											} else if (moves.contains("4, X") && moves.contains("5, X")
													&& moves.contains("6, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("7, X") && moves.contains("8, X")
													&& moves.contains("9, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("1, X") && moves.contains("4, X")
													&& moves.contains("7, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("2, X") && moves.contains("5, X")
													&& moves.contains("8, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("3, X") && moves.contains("6, X")
													&& moves.contains("9, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("1, X") && moves.contains("5, X")
													&& moves.contains("9, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("3, X") && moves.contains("5, X")
													&& moves.contains("7, X")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("X");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("1, O") && moves.contains("2, O")
													&& moves.contains("3, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("4, O") && moves.contains("5, O")
													&& moves.contains("6, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("7, O") && moves.contains("8, O")
													&& moves.contains("9, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("1, O") && moves.contains("4, O")
													&& moves.contains("7, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("2, O") && moves.contains("5, O")
													&& moves.contains("8, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("3, O") && moves.contains("6, O")
													&& moves.contains("9, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("1, O") && moves.contains("5, O")
													&& moves.contains("9, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else if (moves.contains("3, O") && moves.contains("5, O")
													&& moves.contains("7, O")) {
												count = 0;
												buttons.get(buttons.size() - 1).setText("O");
												master.add("(" + list.get(list.size() - 1) + ", " + button.getText()
														+ ")");
												System.out.println(master);
												contentPane.remove(buttonPanel);
												contentPane.revalidate();
												contentPane.repaint();
												turn = true;
												on = false;
												Board.checkWin();
											} else {
												count++;
												if (count % 9 == 0) {
													contentPane.remove(buttonPanel);
													contentPane.revalidate();
													contentPane.repaint();
													turn = true;
													on = false;
												}
											}
										}
									});

									buttonPanel.add(button);
								}
							}
							contentPane.add(buttonPanel);
							setContentPane(contentPane);
							pack();
							setVisible(true);

						}
					}
				});
				buttonPanel.add(button);

			}
		}
		contentPane.add(buttonPanel);

		setContentPane(contentPane);
		pack();
		setLocationByPlatform(true);
		setVisible(true);
	}

	public static void checkWin() {

		if (master.contains("(1, O)") && master.contains("(2, O)") && master.contains("(3, O)")) {
			oWins();
		} else if (master.contains("(4, O)") && master.contains("(5, O)") && master.contains("(6, O)")) {
			oWins();
		} else if (master.contains("(7, O)") && master.contains("(8, O)") && master.contains("(9, O)")) {
			oWins();
		} else if (master.contains("(1, O)") && master.contains("(4, O)") && master.contains("(7, O)")) {
			oWins();
		} else if (master.contains("(2, O)") && master.contains("(5, O)") && master.contains("(8, O)")) {
			oWins();
		} else if (master.contains("(3, O)") && master.contains("(6, O)") && master.contains("(9, O)")) {
			oWins();
		} else if (master.contains("(1, O)") && master.contains("(5, O)") && master.contains("(9, O)")) {
			oWins();
		} else if (master.contains("(3, O)") && master.contains("(5, O)") && master.contains("(7, O)")) {
			oWins();
		} else if (master.contains("(1, X)") && master.contains("(2, X)") && master.contains("(3, X)")) {
			xWins();
		} else if (master.contains("(4, X)") && master.contains("(5, X)") && master.contains("(6, X)")) {
			xWins();
		} else if (master.contains("(7, X)") && master.contains("(8, X)") && master.contains("(9, X)")) {
			xWins();
		} else if (master.contains("(1, X)") && master.contains("(4, X)") && master.contains("(7, X)")) {
			xWins();
		} else if (master.contains("(2, X)") && master.contains("(5, X)") && master.contains("(8, X)")) {
			xWins();
		} else if (master.contains("(3, X)") && master.contains("(6, X)") && master.contains("(9, X)")) {
			xWins();
		} else if (master.contains("(1, X)") && master.contains("(5, X)") && master.contains("(9, X)")) {
			xWins();
		} else if (master.contains("(3, X)") && master.contains("(5, X)") && master.contains("(7, X)")) {
			xWins();
		} else {
			fCount++;
			if (fCount % 9 == 0) {
				JFrame frame = new JFrame("Tie");
				JLabel label = new JLabel("It's a tie!", JLabel.CENTER);
				frame.setSize(900, 900);
				label.setFont(new Font("Comic Sans", Font.PLAIN, 200));
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				frame.add(label);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		}
	}

	public static void xWins() {
		if (tMode == false || xScore == 1) {
			JFrame frame = new JFrame("Winner");
			JLabel label = new JLabel("X Wins!", JLabel.CENTER);
			frame.setSize(900, 900);
			label.setFont(new Font("Comic Sans", Font.PLAIN, 200));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(label);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} else if (tMode == true && xScore != 2) {
			xScore++;
			list.clear();
			master.clear();
			buttons.clear();
			count = 0;
			Board board = new Board();
			board.createAndDisplayGUI();
		}
	}

	public static void oWins() {
		if (tMode == false || oScore == 1) {
			JFrame frame = new JFrame("Winner");
			JLabel label = new JLabel("O Wins!", JLabel.CENTER);
			frame.setSize(900, 900);
			label.setFont(new Font("Comic Sans", Font.PLAIN, 200));
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.add(label);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} else if (tMode == true && oScore != 2) {
			oScore++;
			list.clear();
			master.clear();
			buttons.clear();
			count = 0;
			Board board = new Board();
			board.createAndDisplayGUI();
		}
	}

	public static void main(String[] args) {

		if (args.length > 0) {
			gridSize = Integer.parseInt(args[0]);
		}
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Board board = new Board();
				board.createAndDisplayGUI();
			}
		});

	}
}
