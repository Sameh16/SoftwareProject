import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class insertintoMultipleChoice {

	private JFrame frame;
	private JLabel lblQuestion;
	private JTextField Question;
	private JTextField answer1;
	private JTextField answer2;
	private JTextField answer3;
	private JTextField answer4;
	private JLabel lblCorrecrtAnswer;
	private JTextField correctanwer;
	private int numberoflevel;
	private JTextField Level;
	private String GameName;
	private JFrame lastpage;

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
	 */
	public insertintoMultipleChoice(int numberoflevels, String GameName, JFrame lastPage) {
		numberoflevel = numberoflevels;
		this.GameName = GameName;
		this.lastpage = lastPage;
		main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 946, 766);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		frame.setSize(1050, 600);
		
		frame.getContentPane().setLayout(null);

		lblQuestion = new JLabel("Question :");
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblQuestion.setBounds(38, 93, 102, 34);
		frame.getContentPane().add(lblQuestion);

		Question = new JTextField();
		Question.setBounds(129, 136, 480, 98);
		frame.getContentPane().add(Question);
		Question.setColumns(10);

		answer1 = new JTextField();
		answer1.setBounds(126, 273, 262, 40);
		frame.getContentPane().add(answer1);
		answer1.setColumns(10);

		answer2 = new JTextField();
		answer2.setBounds(438, 274, 226, 40);
		frame.getContentPane().add(answer2);
		answer2.setColumns(10);

		answer3 = new JTextField();
		answer3.setBounds(126, 347, 262, 36);
		frame.getContentPane().add(answer3);
		answer3.setColumns(10);

		JButton btnDone = new JButton("insert");
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnDone.setBounds(263, 510, 125, 40);
		frame.getContentPane().add(btnDone);

		JLabel lblAnswers = new JLabel("Answers :");
		lblAnswers.setForeground(Color.WHITE);
		lblAnswers.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAnswers.setBounds(38, 242, 88, 31);
		frame.getContentPane().add(lblAnswers);

		answer4 = new JTextField();
		answer4.setBounds(438, 349, 226, 34);
		frame.getContentPane().add(answer4);
		answer4.setColumns(10);

		lblCorrecrtAnswer = new JLabel("Correcrt answer :");
		lblCorrecrtAnswer.setForeground(Color.WHITE);
		lblCorrecrtAnswer.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCorrecrtAnswer.setBounds(38, 394, 195, 31);
		frame.getContentPane().add(lblCorrecrtAnswer);

		correctanwer = new JTextField();
		correctanwer.setBounds(201, 436, 248, 34);
		frame.getContentPane().add(correctanwer);
		correctanwer.setColumns(10);

		Level = new JTextField();
		Level.setBounds(161, 37, 125, 22);
		frame.getContentPane().add(Level);
		Level.setColumns(10);

		JLabel lblLevel = new JLabel("level");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblLevel.setBounds(38, 36, 56, 16);
		frame.getContentPane().add(lblLevel);
		Controller controller = new Controller();
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Level.getText().toString().length() == 0 || Question.getText().toString().length() == 0
						|| answer1.getText().toString().length() == 0 || answer2.getText().toString().length() == 0
						|| answer3.getText().toString().length() == 0 || answer4.getText().toString().length() == 0
						|| correctanwer.getText().toString().length() == 0)

				{
					JOptionPane.showMessageDialog(null, "fill all fields plz!!!! ");
					return;
				}

				if (correctanwer.getText().toString() != answer1.getText().toString()
						|| correctanwer.getText().toString() != answer2.getText().toString()
						|| correctanwer.getText().toString() != answer3.getText().toString()
						|| correctanwer.getText().toString() != answer4.getText().toString()) {
					JOptionPane.showMessageDialog(null, "Enter valid Correct answer plz!!!! ");
					return;
				}

				numberoflevel--;
				if (numberoflevel <= 0) {
					JOptionPane.showMessageDialog(null, "finish fill Wait for Admin Acception");
					frame.setVisible(false);
					lastpage.setVisible(true);

				}
				MCQQuestion mcqQuestion = new MCQQuestion();
				mcqQuestion.setQuestion_(Question.getText().toString());
				mcqQuestion.setAnswer_1(answer1.getText().toString());
				mcqQuestion.setAnswer_2(answer2.getText().toString());
				mcqQuestion.setAnswer_3(answer3.getText().toString());
				mcqQuestion.setAnswer_4(answer4.getText().toString());
				mcqQuestion.setCorrecranswer_(correctanwer.getText().toString());
				mcqQuestion.setLevel(Integer.parseInt(Level.getText().toString()));

				if (controller.SaveMSQQuestion(GameName, mcqQuestion)) {
					Question.setText("");
					answer1.setText("");
					answer2.setText("");
					answer3.setText("");
					answer4.setText("");
					correctanwer.setText("");
					Level.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Can't Insert This Question!!");
				}

			}
		});
	}
}
