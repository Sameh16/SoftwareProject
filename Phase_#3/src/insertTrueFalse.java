import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class insertTrueFalse {

	private JFrame frame;
	private JFrame back;
	private JTextField Question;
	private String GameName;
	private int numberoflevel;
	private JButton insert;
	private JTextField level;
	private JRadioButton truee;
	private JRadioButton falsee;

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
	 */
	public insertTrueFalse(int numberoflevels, String GameName, JFrame frame) {
		this.back = frame;
		this.numberoflevel = numberoflevels;
		this.GameName = GameName;

		main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1039, 693);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
		frame.setSize(1050, 600);
		frame.getContentPane().setLayout(null);

		Question = new JTextField();
		Question.setBounds(116, 164, 551, 145);
		frame.getContentPane().add(Question);
		Question.setColumns(10);

		insert = new JButton("Insert");
		insert.setFont(new Font("Tahoma", Font.BOLD, 17));
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (Question.getText().toString().length() == 0 || level.getText().toString().length() == 0) {
					JOptionPane.showMessageDialog(null, "Can't Insert empty Qustion!!!");
					return;
				}

				numberoflevel--;
				String Question_ = Question.getText().toString();
				boolean checked;
				if (truee.isSelected()) {
					checked = true;
				} else
					checked = false;

				int Level = Integer.parseInt(level.getText().toString());
				Controller controller = new Controller();

				TFQuestion tfQuestion = new TFQuestion();
				tfQuestion.setAnswer(checked);
				tfQuestion.setQuestion(Question_);
				tfQuestion.setLevel(Level);
				if (controller.SaveTFQuestion(tfQuestion)) {
					Question.setText("");
					level.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Can't Insert This Question!!");
				}
				if (numberoflevel <= 0) {

					JOptionPane.showMessageDialog(null, "Done insert Your Questions");
					back.setVisible(true);
					frame.setVisible(false);
					return;// not now
				}

			}
		});
		insert.setBounds(296, 455, 166, 46);
		frame.getContentPane().add(insert);

		truee = new JRadioButton("True");
		truee.setBackground(new Color(0, 0, 0));
		truee.setForeground(Color.WHITE);
		truee.setSelected(true);
		truee.setFont(new Font("Dialog", Font.PLAIN, 20));
		truee.setBounds(234, 369, 74, 46);
		frame.getContentPane().add(truee);

		falsee = new JRadioButton("False");
		falsee.setBackground(new Color(0, 0, 0));
		falsee.setForeground(Color.WHITE);
		falsee.setFont(new Font("Dialog", Font.PLAIN, 20));
		falsee.setBounds(436, 373, 79, 38);
		frame.getContentPane().add(falsee);

		JLabel lblQuestion = new JLabel("Question :");
		lblQuestion.setForeground(Color.WHITE);
		lblQuestion.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblQuestion.setBounds(29, 93, 214, 60);
		frame.getContentPane().add(lblQuestion);

		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(falsee);
		buttonGroup.add(truee);

		JLabel lblLevel = new JLabel("level");
		lblLevel.setForeground(Color.WHITE);
		lblLevel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblLevel.setBounds(29, 40, 56, 16);
		frame.getContentPane().add(lblLevel);

		level = new JTextField();
		level.setBounds(127, 39, 116, 22);
		frame.getContentPane().add(level);
		level.setColumns(10);

	}
}
