import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FeedBack {

	private JFrame frame;
	private JFrame lastpage;
	private JTextField comment;
	private String GameName;
	private String userName;
	private int Achievement;

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
	 * @param achievement 
	 * @param isTeacher 
	 */
	public FeedBack(String userName, String GameName, JFrame f, int achievement) {

		lastpage = f;
		main();
		this.userName = userName;
		this.GameName = GameName;
		Achievement=achievement;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 892, 675);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		frame.setSize(1050, 600);
		frame.getContentPane().setLayout(null);

		comment = new JTextField();
		comment.setBounds(111, 269, 499, 120);
		frame.getContentPane().add(comment);
		comment.setColumns(10);

		JLabel lblComment = new JLabel("Comment");
		lblComment.setForeground(new Color(255, 255, 255));
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblComment.setBounds(60, 210, 110, 36);
		frame.getContentPane().add(lblComment);

		JRadioButton radioButton = new JRadioButton("1");
		radioButton.setBackground(new Color(0, 0, 0));
		radioButton.setForeground(new Color(255, 255, 255));
		radioButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButton.setBounds(98, 129, 60, 25);
		frame.getContentPane().add(radioButton);

		JRadioButton radioButton_1 = new JRadioButton("2");
		radioButton_1.setBackground(new Color(0, 0, 0));
		radioButton_1.setForeground(new Color(255, 255, 255));
		radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButton_1.setBounds(193, 129, 60, 25);
		frame.getContentPane().add(radioButton_1);

		JRadioButton radioButton_2 = new JRadioButton("3");
		radioButton_2.setBackground(new Color(0, 0, 0));
		radioButton_2.setForeground(new Color(255, 255, 255));
		radioButton_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButton_2.setBounds(275, 129, 60, 25);
		frame.getContentPane().add(radioButton_2);

		JRadioButton radioButton_3 = new JRadioButton("4");
		radioButton_3.setBackground(new Color(0, 0, 0));
		radioButton_3.setForeground(new Color(255, 255, 255));
		radioButton_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButton_3.setBounds(373, 129, 60, 25);
		frame.getContentPane().add(radioButton_3);

		JRadioButton radioButton_4 = new JRadioButton("5");
		radioButton_4.setBackground(new Color(0, 0, 0));
		radioButton_4.setForeground(new Color(255, 255, 255));
		radioButton_4.setSelected(true);
		radioButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		radioButton_4.setBounds(470, 129, 60, 25);
		frame.getContentPane().add(radioButton_4);

		JLabel lblRate = new JLabel("Rate");
		lblRate.setForeground(new Color(255, 255, 255));
		lblRate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblRate.setBounds(60, 59, 110, 25);
		frame.getContentPane().add(lblRate);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String Commentt = comment.getText().toString();
				int rate = 5;
				if (radioButton.isSelected()) {
					rate = 1;
				}
				if (radioButton_1.isSelected()) {
					rate = 2;
				}
				if (radioButton_2.isSelected()) {
					rate = 3;
				}
				if (radioButton_3.isSelected()) {
					rate = 4;
				}
				if (radioButton_4.isSelected()) {
					rate = 5;
				}

				Controller controller = new Controller();
					controller.updateStudentGameData(userName, GameName, rate, Commentt,Achievement);
				frame.setVisible(false);
				lastpage.setVisible(true);

			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnSubmit.setBounds(258, 438, 136, 36);
		frame.getContentPane().add(btnSubmit);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(radioButton);
		buttonGroup.add(radioButton_1);
		buttonGroup.add(radioButton_2);
		buttonGroup.add(radioButton_3);
		buttonGroup.add(radioButton_4);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				lastpage.setVisible(true);
			}
		});
		btnBack.setBounds(21, 493, 110, 36);
		frame.getContentPane().add(btnBack);
	}
}
