package com.sistema.venta.jdbc.views;

import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.border.LineBorder;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIngreseSuNombre;
	private JPasswordField txtContrasena;
	int xMause, yMause;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel background = new JPanel();
		background.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - xMause, y - yMause);
			}
		});
		background.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xMause = e.getX();
				yMause = e.getY();
				
			}
		});
		background.setBackground(Color.WHITE);
		background.setForeground(Color.WHITE);
		background.setBounds(0, 0, 600, 350);
		contentPane.add(background);
		background.setLayout(null);
		
		ImageIcon imgLogo = new ImageIcon("C:\\\\Users\\\\Melvin Gutierrez\\\\3D Objects\\\\Sistema_venta\\\\Img\\MI LOGO.png");
		ImageIcon imgLogo2 = new ImageIcon(imgLogo.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(imgLogo2);
		lblLogo.setBounds(426, 64, 125, 125);
		background.add(lblLogo);
		
		JLabel nombreEmpres = new JLabel("Sistema venta");
		nombreEmpres.setFont(new Font("Roboto Medium", Font.BOLD, 25));
		nombreEmpres.setForeground(new Color(255, 218, 185));
		nombreEmpres.setHorizontalAlignment(SwingConstants.CENTER);
		nombreEmpres.setBounds(383, 187, 217, 28);
		background.add(nombreEmpres);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\login.jpg"));
		lblNewLabel.setBounds(373, 0, 227, 366);
		background.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("LOGO");
		lblNewLabel_2.setFont(new Font("Roboto Medium", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\iniciar.png"));
		lblNewLabel_2.setBounds(33, 11, 166, 71);
		background.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("INICIAR SESION");
		lblNewLabel_3.setFont(new Font("Roboto Medium", Font.BOLD, 16));
		lblNewLabel_3.setBounds(33, 92, 126, 38);
		background.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("USUARIO");
		lblNewLabel_4.setFont(new Font("Roboto Light", Font.BOLD, 14));
		lblNewLabel_4.setBounds(33, 141, 154, 21);
		background.add(lblNewLabel_4);
		
		txtIngreseSuNombre = new JTextField();
		txtIngreseSuNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtIngreseSuNombre.setText("");
				txtIngreseSuNombre.setForeground(Color.black);
				
			}
		});
		txtIngreseSuNombre.setBackground(Color.WHITE);
		txtIngreseSuNombre.setForeground(SystemColor.controlHighlight);
		txtIngreseSuNombre.setFont(new Font("Roboto", Font.BOLD, 12));
		txtIngreseSuNombre.setBorder(null);
		txtIngreseSuNombre.setText("Ingrese su nombre de usuario");
		txtIngreseSuNombre.setBounds(33, 166, 290, 28);
		background.add(txtIngreseSuNombre);
		txtIngreseSuNombre.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(33, 198, 290, 10);
		background.add(separator);
		
		JLabel lblNewLabel_5 = new JLabel("CONTRSENA");
		lblNewLabel_5.setFont(new Font("Roboto Light", Font.BOLD, 12));
		lblNewLabel_5.setBounds(33, 213, 79, 14);
		background.add(lblNewLabel_5);
		
		txtContrasena = new JPasswordField();
		txtContrasena.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtContrasena.setText("");
				txtContrasena.setForeground(Color.black);
			}
		});
		txtContrasena.setText("********");
		txtContrasena.setToolTipText("");
		txtContrasena.setFont(new Font("Roboto", Font.BOLD, 12));
		txtContrasena.setBorder(null);
		txtContrasena.setBounds(33, 235, 290, 21);
		background.add(txtContrasena);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 265, 290, 10);
		background.add(separator_1);
		
		JLabel lblNewLabel_6 = new JLabel("INGRESAR");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ingresar();
			}
		});
		lblNewLabel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(143, 286, 85, 28);
		background.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Roboto Condensed", Font.BOLD, 14));
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBackground(new Color(138, 43, 226));
		panelBoton.setBounds(143, 286, 85, 28);
		background.add(panelBoton);
		
		JLabel lblCerrar = new JLabel("X");
		lblCerrar.setBackground(Color.white);
		lblCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		background.add(lblCerrar);
		lblCerrar.setBounds(0, 0, 25, 25);
		lblCerrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		
		lblCerrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrar.setFont(new Font("Roboto Condensed Black", Font.BOLD, 20));
		lblCerrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblCerrar.setBounds(0, 0, 27, 27);
		
		JLabel lblNewLabel_7 = new JLabel("Siguenos en:");
		lblNewLabel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_7.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\facebook.png"));
		lblNewLabel_7.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_7.setBounds(0, 325, 139, 25);
		background.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Siguenos en:");
		lblNewLabel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_8.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_8.setHorizontalTextPosition(SwingConstants.LEFT);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Roboto", Font.BOLD, 14));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Melvin Gutierrez\\3D Objects\\Sistema_venta\\Img\\instagram.png"));
		lblNewLabel_8.setBounds(213, 325, 139, 25);
		background.add(lblNewLabel_8);
		
	}
	
protected void Ingresar() {
		
		String Usuario = txtIngreseSuNombre.getText();
		String contrasena = String.valueOf(txtContrasena.getPassword());
		
		com.sistema.venta.jdbc.dao.LoginDAO usua = new com.sistema.venta.jdbc.dao.LoginDAO();
		
		com.sistema.venta.jdbc.modelo.Usuario usuario2 = new com.sistema.venta.jdbc.modelo.Usuario();
		
		usuario2.setNombre(Usuario);
		usuario2.setPass(contrasena);
		
		com.sistema.venta.jdbc.modelo.Usuario usu = usua.obtenerUsuario(usuario2);
		
		this.dispose();
		
		if (usu != null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido " + Usuario);
			sPRINCIPAL menu = new sPRINCIPAL();
			menu.setVisible(true);
			menu.setLocationRelativeTo(null);
			
		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos invalidos", "Error", JOptionPane.ERROR_MESSAGE);
			Login login = new Login();
			login.setVisible(true);
			login.setLocationRelativeTo(null);
		}
		
	}
}
