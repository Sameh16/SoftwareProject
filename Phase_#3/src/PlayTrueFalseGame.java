import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PlayTrueFalseGame {

	private JFrame frame;
	private JFrame lastpage;
	private Game game;
	int level;
	private String UserName;
	private Controller controller;
	private ArrayList<TFQuestion> list;
	private int index;
	private int numofCorrect;
	private int numOfWrong;
	private int Achievement;
	private boolean isTeacher;

	/**
	 * Launch the application.
	 */
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @param lastPage
	 * @param isTeacher
	 * @param a 
	 */
	public PlayTrueFalseGame(Game game, String UserName, JFrame lastPage, boolean isTeacher, int a) {
		main();
		this.UserName = UserName;
		numOfWrong = 0;
		numofCorrect = 0;
		this.lastpage = lastPage;
		this.game = game;
		level = 1;
		index = 0;
		Achievement = a;
		this.isTeacher = isTeacher;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1126, 634);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		frame.setSize(1050, 600);
		frame.getContentPane().setLayout(null);

		JRadioButton truee = new JRadioButton("True");
		truee.setBackground(new Color(0, 0, 0));
		truee.setForeground(new Color(255, 255, 255));
		truee.setSelected(true);
		truee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		truee.setBounds(164, 324, 127, 46);
		frame.getContentPane().add(truee);

		JRadioButton faslee = new JRadioButton("False");
		faslee.setBackground(new Color(0, 0, 0));
		faslee.setForeground(new Color(255, 255, 255));
		faslee.setFont(new Font("Tahoma", Font.PLAIN, 20));
		faslee.setBounds(328, 328, 127, 38);
		frame.getContentPane().add(faslee);

		JLabel label = new JLabel("Question :");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		label.setBounds(42, 38, 214, 60);
		frame.getContentPane().add(label);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(141, 109, 492, 162);
		frame.getContentPane().add(lblNewLabel);

		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				boolean answer = list.get(index).getAnswer();
				if (truee.isSelected() && answer || faslee.isSelected() && !answer) {
					JOptionPane.showMessageDialog(null, "Corrcet answer");
					Achievement += 10;
					numofCorrect++;

				} else {
					JOptionPane.showMessageDialog(null, " wrong answer");
					Achievement -= 5;
					numOfWrong++;
				}

				index++;
				if (index < list.size()) {
					lblNewLabel.setText(list.get(index).getQuestion().toString());
				} else {

					// calc achif

					index = 0;
					level++;
					numOfWrong = 0;
					numofCorrect = 0;

					list = controller.LoadTFQuestion(game.getGameName().toString(), level);
					if (list == null) {
						JOptionPane.showMessageDialog(null, " congratulations!!!!!!");
						frame.setVisible(false);
						if (!isTeacher) {
							JOptionPane.showMessageDialog(null, "Your Achievement = " + Achievement);
							new FeedBack(UserName, game.getGameName(), lastpage, Achievement);
						} else
							lastpage.setVisible(true);
						return;
					}
					lblNewLabel.setText(list.get(index).getQuestion().toString());

				}
			}
		});

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(truee);
		buttonGroup.add(faslee);
		Submit.setFont(new Font("Tahoma", Font.BOLD, 17));
		Submit.setBounds(233, 443, 133, 55);
		frame.getContentPane().add(Submit);

		truee.hide();
		faslee.hide();
		label.hide();
		lblNewLabel.hide();
		Submit.hide();

		JButton btnStartPlay = new JButton("Start Play");
		btnStartPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				truee.show();
				faslee.show();
				label.show();
				lblNewLabel.show();
				Submit.show();
				//lblLevelNumber.show();
				//LLevel.show();
				//corr.show();
				//wrong.show();
				//lblWrongAnser.show();
				//lblCorrcetAnswer.show();

				btnStartPlay.hide();
				controller = new Controller();

				list = controller.LoadTFQuestion(game.getGameName().toString(), level);
				lblNewLabel.setText(list.get(index).getQuestion().toString());
				

			}
		});
		btnStartPlay.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnStartPlay.setBounds(164, 219, 294, 170);
		frame.getContentPane().add(btnStartPlay);

	}
}
