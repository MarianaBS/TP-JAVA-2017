package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import controlers.CtrlABMElemento;
import entity.Elemento;
import entity.Tipo_Elemento;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ABMCElementos extends JInternalFrame {
	private CtrlABMElemento ctrl=new CtrlABMElemento();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JComboBox cboTipos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCElementos frame = new ABMCElementos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ABMCElementos() {
		setClosable(true);
		setTitle("ABMCElemento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 402, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("ID");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		
		txtNombre.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo Elemento");
		
		cboTipos = new JComboBox<Object>();
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				buscarClick();
 			}
 		});
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				agregarClick();
 			}
 		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				borrarClick();
 			}
 		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				modificarClick();
 			}
 		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTipo)
									.addGap(18)
									.addComponent(cboTipos, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblId)
										.addComponent(lblNombre))
									.addGap(48)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtId)
										.addComponent(txtNombre, GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
							.addGap(35)
							.addComponent(btnBuscar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(btnAgregar)
							.addGap(18)
							.addComponent(btnBorrar)
							.addGap(18)
							.addComponent(btnModificar)))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipo)
						.addComponent(cboTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		loadLists();
	}
	
	 public void loadLists() {
		 	try {
		 		this.cboTipos.setModel(new DefaultComboBoxModel(this.ctrl.getTipos().toArray()));
		 		this.cboTipos.setSelectedIndex(-1);
		 	} catch (Exception e) {
		 JOptionPane.showMessageDialog(this, "Error recuperando Tipos de Elementos", "Error",JOptionPane.ERROR_MESSAGE);
		 }
		 }
	 
	 protected void buscarClick() {
	 		try {
	 			this.mapearAForm(ctrl.getByNombre(this.txtNombre.getText()));
	 			}
	 		catch (Exception e) {
	 			JOptionPane.showMessageDialog(this, "No se encontró el elemento");
	 			}
	 			 	}
	 	protected void agregarClick() {
	 		Elemento el = this.mapearDeForm();
	 		try{
	 			ctrl.add(el);
	 			JOptionPane.showMessageDialog(this, "El elemento fue registrado");
	 			} catch (Exception e) {
	 			JOptionPane.showMessageDialog(this, "No se pudo guardar");
	 			}
	 			this.txtId.setText(String.valueOf(el.getIdelemento()));
	 			 		
	 			 	}
	 	protected void borrarClick(){
	 		try{
	 			ctrl.delete(this.mapearDeForm());
	 			JOptionPane.showMessageDialog(this, "El elemento fue eliminado");
	 			} catch (Exception e) {
	 			JOptionPane.showMessageDialog(this, e.getMessage());
	 			}
	 			 	}
	 	protected void modificarClick(){
	 		try{
	 			ctrl.update(this.mapearDeForm());
	 			JOptionPane.showMessageDialog(this, "Los datos del elemento fueron modificados");
	 			} catch (Exception e) {
	 			JOptionPane.showMessageDialog(this, e.getMessage());
	 			}
	 			 	}

	 	private void mapearAForm(Elemento e){
	 		this.txtNombre.setText(e.getNombre());
	 		this.txtId.setText(String.valueOf(e.getIdelemento()));
	 		if (e.getTipo_Elem() !=null){
	 			this.cboTipos.setSelectedItem(e.getTipo_Elem());
	 			};
	 	}
	 	
	 	private Elemento mapearDeForm(){
	 		Elemento e=new Elemento();
	 		if(!this.txtId.getText().isEmpty()){
	 			e.setIdelemento(Integer.parseInt(this.txtId.getText()));
	 		}
	 		e.setNombre(this.txtNombre.getText());
	 		if (cboTipos.getSelectedIndex() != -1){
	 			 e.setTipo_Elem((Tipo_Elemento)cboTipos.getSelectedItem());
	 			 }
	 		return e;
	 	}
	 	public void showElemento(Elemento e){
	 		 this.mapearAForm(e);
	 		 	
	 		 }
}
