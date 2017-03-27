import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PlayMultipleChoiceGame {

	private JFrame frame;
	private JFrame lastpage;
	private Game game;
	private String Username;
	private int Levels;
	private int start;
	private int startQ;
	private ArrayList<MCQQuestion> Questions;
	private JButton btnA1;
	private JButton btnA2;
	private JButton btnA3;
	private JButton btnA4;
	private JLabel lblNewLabel;
	private JLabel lblQuestioni;
	private int Achievement;
	private boolean isTeacher;
	private int Truecount;
	private int Falsecount;


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
	 * @param isTeacher
	 * @param a 
	 */
	public PlayMultipleChoiceGame(Game game, String username, JFrame f, boolean isTeacher, int a) {
		main();
		lastpage = f;
		this.game = game;
		this.Username = username;
		start = 1;
		startQ = 0;
		this.isTeacher = isTeacher;
		Achievement=a;
		Truecount=0;
		Falsecount=0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1087, 613);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		frame.setSize(1050, 600);
		frame.getContentPane().setLayout(null);

		lblQuestioni = new JLabel("Question  :");
		lblQuestioni.setForeground(new Color(255, 255, 255));
		lblQuestioni.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQuestioni.setBounds(39, 27, 133, 34);
		frame.getContentPane().add(lblQuestioni);

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(137, 85, 545, 154);
		frame.getContentPane().add(lblNewLabel);
		

		btnA1 = new JButton("A1");
		btnA1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnA1.setBounds(76, 273, 189, 40);
		frame.getContentPane().add(btnA1);

		btnA2 = new JButton("New button");
		btnA2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnA2.setBounds(76, 353, 189, 40);
		frame.getContentPane().add(btnA2);

		btnA3 = new JButton("New button");
		btnA3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnA3.setBounds(388, 273, 189, 40);
		frame.getContentPane().add(btnA3);

		btnA4 = new JButton("New button");
		btnA4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnA4.setBounds(388, 353, 189, 40);
		frame.getContentPane().add(btnA4);

		lblNewLabel.hide();
		lblQuestioni.hide();
		btnA1.hide();
		btnA2.hide();
		btnA3.hide();
		btnA4.hide();

		JButton btnStartPlay = new JButton("Start Play ");

		btnStartPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				lblNewLabel.show();
				lblQuestioni.show();
				btnA1.show();
				btnA2.show();
				btnA3.show();
				btnA4.show();
				btnStartPlay.hide();
				Controller controller = new Controller();
				Levels = controller.loadMSQQuestionLevel(game.getGameName());
				Questions = controller.loadMSQQuestion(game.getGameName(), start);
				lblNewLabel.setText(Questions.get(startQ).getQuestion_());
				btnA1.setText(Questions.get(startQ).getAnswer_1());
				btnA2.setText(Questions.get(startQ).getAnswer_2());
				btnA3.setText(Questions.get(startQ).getAnswer_3());
				btnA4.setText(Questions.get(startQ).getAnswer_4());

			}
		});

		btnStartPlay.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnStartPlay.setBounds(156, 197, 266, 119);
		frame.getContentPane().add(btnStartPlay);

		btnA1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				action(btnA1);

			}
		});

		btnA2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				action(btnA2);

			}
		});
		btnA3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				action(btnA3);

			}
		});
		btnA4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				action(btnA4);
			}
		});

	}

	public void action(JButton button) {
		Controller controller = new Controller();
		if (start == Levels && startQ + 1 == Questions.size()) {
			if (button.getText().equals(Questions.get(startQ).getCorrecranswer_())) {
				JOptionPane.showMessageDialog(null, "Corect Answer !! ");
				Truecount++;
				Achievement += 10;
			} else {
				JOptionPane.showMessageDialog(null, "Wrong Answer !! ");
				Falsecount++;
				Achievement -= 5;
			}
			frame.setVisible(false);
			if (!isTeacher) {
				JOptionPane.showMessageDialog(null, "Your Achievement = " + Achievement);
				new FeedBack(Username, game.getGameName(), lastpage, Achievement);
			}
			lastpage.setVisible(true);
		} else {
			if (startQ + 1 == Questions.size()) {

				if (button.getText().equals(Questions.get(startQ).getCorrecranswer_())) {
					JOptionPane.showMessageDialog(null, "Corect Answer !! ");
					Truecount++;
					Achievement += 10;
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Answer !! ");
					Falsecount++;
					Achievement -= 5;
				}
				start++;
				Questions = controller.loadMSQQuestion(game.getGameName(), start);
				startQ = 0;
			} else {
				startQ++;
				if (button.getText().equals(Questions.get(startQ - 1).getCorrecranswer_())) {
					JOptionPane.showMessageDialog(null, "Corect Answer !! ");
					Truecount++;
					Achievement += 10;
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Answer !! ");
					Falsecount++;
					Achievement -= 5;
				}
			}
		}
		lblNewLabel.setText(Questions.get(startQ).getQuestion_());
		btnA1.setText(Questions.get(startQ).getAnswer_1());
		btnA2.setText(Questions.get(startQ).getAnswer_2());
		btnA3.setText(Questions.get(startQ).getAnswer_3());
		btnA4.setText(Questions.get(startQ).getAnswer_4());
	}

}
