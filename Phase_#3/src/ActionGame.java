import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ActionGame {

	private JFrame frame;
	private JFrame lastPage;
	private boolean isTeacher;
	private String username;

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
	public ActionGame(JFrame f, boolean z, String userName) {
		lastPage = f;
		isTeacher = z;
		username = userName;
		main();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.PLAIN, 17));
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1050, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("back.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		frame.setSize(1050, 600);
		
		frame.getContentPane().setLayout(null);

		JButton btnPlay = new JButton("Play Game");
		btnPlay.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnPlay.setBounds(223, 218, 233, 78);
		frame.getContentPane().add(btnPlay);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.setForeground(new Color(0, 0, 0));
		btnBack.setBounds(29, 483, 158, 56);
		frame.getContentPane().add(btnBack);

		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblWelcome.setBounds(154, 55, 572, 71);
		frame.getContentPane().add(lblWelcome);
		JButton btnCreate = new JButton("Create Game");
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCreate.setBounds(223, 350, 233, 78);

		if (isTeacher) {
			frame.getContentPane().add(btnCreate);
		}
		JLabel lblUsername = new JLabel();
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Times New Roman", Font.BOLD, 50));
		lblUsername.setBounds(372, 72, 403, 36);
		frame.getContentPane().add(lblUsername);
		lblUsername.setText(username);

		btnCreate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new Test(frame, isTeacher, username, true);
			}
		});

		btnBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				lastPage.setVisible(true);
			}
		});
		btnPlay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				new playtest(frame, isTeacher, username);
			}
		});

	}
}
