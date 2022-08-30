package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textLU;
	private JTextField textApellido;
	private JTextField textNombre;
	private JTextField textEmail;
	private JTextField textGithubUrl;
	private JLabel lblNewLabel;
	private JLabel lblDate;

	public SimplePresentationScreen(Student studentData) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SimplePresentationScreen.class.getResource("/images/tdp.png")));
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(617, 278));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 201);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 100));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(12, 13, 56, 16);
		tabInformation.add(lblLU);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 42, 56, 16);
		tabInformation.add(lblApellido);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 71, 56, 16);
		tabInformation.add(lblNombre);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(12, 100, 56, 16);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("GitHub URL");
		lblGithubUrl.setBounds(12, 129, 70, 16);
		tabInformation.add(lblGithubUrl);
		
		
		lblNewLabel = new JLabel("");
		ImageIcon icon = new ImageIcon(SimplePresentationScreen.class.getResource(studentData.getPathPhoto()));
		Image scaleImage = icon.getImage().getScaledInstance(140, 140,Image.SCALE_SMOOTH);
		icon = new ImageIcon(scaleImage);
		lblNewLabel.setIcon(icon);
		lblNewLabel.setBounds(447, 44, 140, 140);
		contentPane.add(lblNewLabel);
		
		lblDate = new JLabel("");
		lblDate.setBounds(15, 210, 401, 16);
		contentPane.add(lblDate);
		DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		lblDate.setText("Esta ventana fue generada el "+date.format(now)+" a las "+time.format(now));
		
		textLU = new JTextField();
		textLU.setBounds(149, 10, 264, 22);
		tabInformation.add(textLU);
		textLU.setColumns(10);
		textLU.setText(String.valueOf(studentData.getId()));
		textLU.setEditable(false);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(149, 39, 264, 22);
		tabInformation.add(textApellido);
		textApellido.setText(studentData.getLastName());
		textApellido.setEditable(false);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(149, 68, 264, 22);
		tabInformation.add(textNombre);
		textNombre.setText(studentData.getFirstName());
		textNombre.setEditable(false);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(149, 97, 264, 22);
		tabInformation.add(textEmail);
		textEmail.setText(studentData.getMail());
		textEmail.setEditable(false);
		
		textGithubUrl = new JTextField();
		textGithubUrl.setColumns(10);
		textGithubUrl.setBounds(149, 126, 264, 22);
		tabInformation.add(textGithubUrl);
		contentPane.add(tabbedPane);
		textGithubUrl.setText(studentData.getGithubURL());
		textGithubUrl.setEditable(false);
		
		
		
		
		
		
	}
}
