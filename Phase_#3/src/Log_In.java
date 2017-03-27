import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

public class Log_In {

	private JFrame frame;
	private JFrame lastPage;
	private boolean isTeacher;
	private JTextField textField;
	private JTextField textField_1;

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
	public Log_In(JFrame f, boolean z) {
		lastPage = f;
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setSize(1050, 600);

		JButton btnNewButton = new JButton("Log In");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(185, 267, 180, 39);
		frame.getContentPane().add(btnNewButton);

		textField = new JTextField();
		textField.setBounds(185, 105, 240, 30);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JPasswordField();
		textField_1.setBounds(185, 173, 240, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JButton btnNewButton_1 = new JButton("Registration");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_1.setBounds(185, 339, 180, 39);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton_2.setBounds(25, 485, 131, 47);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserName.setBounds(70, 72, 105, 90);
		frame.getContentPane().add(lblUserName);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(70, 174, 105, 22);
		frame.getContentPane().add(lblPassword);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				if (textField.getText().toString().equals("") || textField_1.getText().toString().equals("")) {
					JOptionPane.showMessageDialog(null, "Fill all Data Plz");
				} else {
					Controller controller = new Controller();
					boolean loged = controller.CheckValidUser(textField.getText().toString(),
							textField_1.getText().toString(), isTeacher);
					if (loged) {
						frame.setVisible(false);
						JOptionPane.showMessageDialog(null, "Success Log In");
						new ActionGame(lastPage, isTeacher, textField.getText().toString());

					} else {
						JOptionPane.showMessageDialog(null, "Wrong UserName or Password");
					}
				}
			}
		});

		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				lastPage.setVisible(true);

			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Registration(lastPage, isTeacher);

			}
		});
	}
}
