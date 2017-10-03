package UI;

import javax.swing.JInternalFrame;

import UI.MainWindow;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import controlers.CtrlLogin;
import data.DataLogin;
import entity.Persona;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends javax.swing.JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField password;
	private CtrlLogin ctrl=new CtrlLogin();
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
			
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public Login() {
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//setClosable(false);
		setTitle("Login");
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 376, 273);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		
		JLabel lblBienvenidosAlSistema = new JLabel("\u00A1Bienvenido al Sistema de Reservas! ");
		
		JLabel lblIngreseSusDatos = new JLabel("Por favor, ingrese sus datos");
		
		JLabel lblUsuario = new JLabel("Usuario");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				aceptarClick();
			}
		});
		
		password = new JPasswordField();
		
		JLabel lblOlvidMiClave = new JLabel("Olvidé mi clave");
		lblOlvidMiClave.setForeground(Color.BLUE);
		lblOlvidMiClave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showMessageDialog(rootPane ,"Es Ud. muy descuidado. ¡Haga memoria!", "Mensaje", JOptionPane.WARNING_MESSAGE);}
 			
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(82)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblContrasea)
								.addComponent(lblUsuario))
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(password)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))
						.addComponent(lblBienvenidosAlSistema)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblOlvidMiClave)
							.addGap(18)
							.addComponent(btnAceptar)))
					.addContainerGap(87, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(110, Short.MAX_VALUE)
					.addComponent(lblIngreseSusDatos)
					.addGap(104))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(lblBienvenidosAlSistema)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIngreseSusDatos)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblUsuario)
							.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(47)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblContrasea)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(lblOlvidMiClave))
					.addContainerGap(42, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	protected void aceptarClick() {
 		try {
 			Persona u = mapearUsuario();
 			if(u!=null) {
 				if(u.getHabilitado()){
 				UI.MainWindow.usuarioAct=u;
 				UI.MainWindow.habilitarMenu();
 				JOptionPane.showMessageDialog(this, "Bienvenido/a "+ u.getNombre());
 				this.dispose();
 				}
 				else {JOptionPane.showMessageDialog(this ,"Usuario inhabilitado", "Error", JOptionPane.WARNING_MESSAGE);}
 				}
 				
 			
 			else {JOptionPane.showMessageDialog(this ,"Usuario y/o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);}
 			
 			
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, "Error al obtener el ususario");
 			}}


	public Persona mapearUsuario() throws Exception {
		String usu= this.txtUsuario.getText();
		String clave = String.valueOf(this.password.getPassword());
		DataLogin dl= new DataLogin();
		Persona usu2= new Persona();
		usu2.setUsuario(usu);
		usu2.setContrasenia(clave);
		Persona u= new Persona();
		u= dl.getUsuario(usu2);
		return u;
	}
 			 	
	
 		


	}
