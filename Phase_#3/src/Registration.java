import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Registration {

	private JFrame frame;
	private JFrame lastpage;
	private boolean isTeacher;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
	public Registration(JFrame f, boolean z) {
		lastpage = f;
		isTeacher = z;
		main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Game For All");
		frame.setLocation(100, 100);
        frame.setSize(1050, 600);
		frame.getContentPane().setLayout(null);

		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        frame.setSize(1050, 600);
		textField = new JTextField();
		textField.setBounds(150, 62, 124, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(150, 118, 124, 20);
		frame.getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(150, 176, 124, 20);
		frame.getContentPane().add(textField_2);

		textField_3 = new JPasswordField();
		textField_3.setColumns(10);
		textField_3.setBounds(150, 235, 124, 20);
		frame.getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(150, 296, 124, 20);
		frame.getContentPane().add(textField_4);

		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setBounds(150, 355, 116, 20);
		frame.getContentPane().add(comboBox);
		comboBox.addItem("M");
		comboBox.addItem("F");

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 17));
		btnBack.setBounds(21, 479, 106, 48);
		frame.getContentPane().add(btnBack);

		JButton btnSignup = new JButton("SignUp");
		btnSignup.setForeground(Color.BLACK);
		btnSignup.setFont(new Font("Dialog", Font.BOLD, 17));
		btnSignup.setBounds(261, 479, 106, 48);
		frame.getContentPane().add(btnSignup);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(42, 53, 85, 30);
		frame.getContentPane().add(lblName);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(42, 105, 85, 38);
		frame.getContentPane().add(lblEmail);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(42, 283, 74, 38);
		frame.getContentPane().add(lblAge);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(42, 226, 97, 30);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(42, 149, 111, 66);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Gender");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(42, 328, 106, 66);
		frame.getContentPane().add(lblNewLabel_2);

		if (isTeacher) {
			JLabel lblNewLabel_3 = new JLabel("School Name");
			lblNewLabel_3.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_3.setForeground(Color.WHITE);
			lblNewLabel_3.setBounds(336, 37, 150, 66);
			frame.getContentPane().add(lblNewLabel_3);

			textField_5 = new JTextField();
			textField_5.setBounds(500, 118, 124, 20);
			frame.getContentPane().add(textField_5);
			textField_5.setColumns(10);

			textField_6 = new JTextField();
			textField_6.setBounds(500, 62, 124, 20);
			frame.getContentPane().add(textField_6);
			textField_6.setColumns(10);

			JLabel lblNewLabel_4 = new JLabel("School Address");
			lblNewLabel_4.setFont(new Font("Dialog", Font.PLAIN, 20));
			lblNewLabel_4.setForeground(Color.WHITE);
			lblNewLabel_4.setBounds(336, 91, 150, 66);
			frame.getContentPane().add(lblNewLabel_4);
		}

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				lastpage.setVisible(true);
			}
		});

		btnSignup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isTeacher) {
					if (textField.getText().toString().equals("") || textField_1.getText().toString().equals("")
							|| textField_2.getText().toString().equals("")
							|| textField_3.getText().toString().equals("")
							|| textField_4.getText().toString().equals("")
							|| textField_5.getText().toString().equals("")
							|| textField_6.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all Data Plz");
					} else {
						Teacher teacher = new Teacher();
						teacher.setName(textField.getText().toString());
						teacher.setEmail(textField_1.getText().toString());
						teacher.setUserName(textField_2.getText().toString());
						teacher.setPassword(textField_3.getText().toString());
						int age = 0;
						if (!textField_4.getText().toString().equals("")) {
							age = Integer.parseInt(textField_4.getText().toString());
						}
						teacher.setAge(age);
						teacher.setGender(comboBox.getSelectedItem().toString().charAt(0));
						teacher.setSchoolAddress(textField_5.getText().toString());
						teacher.setSchoolName(textField_6.getText().toString());
						Controller controller = new Controller();
						if (!controller.CheckTeacherprimaryKey(teacher.getUserName())) {
							controller.SaveTeacherData(teacher);
							frame.setVisible(false);
							new ActionGame(lastpage, isTeacher, textField.getText().toString());
						} else {
							JOptionPane.showMessageDialog(null, textField_2.getText().toString() + "  are in Database");

						}
					}
				} else {
					if (textField.getText().toString().equals("") || textField_1.getText().toString().equals("")
							|| textField_2.getText().toString().equals("")
							|| textField_3.getText().toString().equals("")
							|| textField_4.getText().toString().equals("")) {
						JOptionPane.showMessageDialog(null, "Fill all Fildes Plz");
					}
					Student student = new Student();
					student.setName(textField.getText().toString());
					student.setEmail(textField_1.getText().toString());
					student.setUserName(textField_2.getText().toString());
					student.setPassword(textField_3.getText().toString());
					int age = Integer.parseInt(textField_4.getText().toString());
					student.setAge(age);
					student.setGender(comboBox.getSelectedItem().toString().charAt(0));
					Controller controller = new Controller();
					if (!controller.CheckStudentprimaryKey(student.getUserName())) {
						controller.SaveStudentData(student);
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Success Sign Up And Welcome");
						new ActionGame(lastpage, isTeacher, textField.getText().toString());
					} else {
						JOptionPane.showMessageDialog(null, textField_2.getText().toString() + "  are in Database");
					}
				}
			}
		});

	}
}
