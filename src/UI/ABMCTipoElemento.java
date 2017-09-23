package UI;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;






import javax.swing.JFrame;

import controlers.CtrlABMTipoElemento;
import entity.Tipo_Elemento;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ABMCTipoElemento extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CtrlABMTipoElemento ctrl=new CtrlABMTipoElemento();

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtNombre;
	private JTextField txtCantMax;
	private JTextField txtLimite;
	private JTextField txtDiasAntic;
	private JCheckBox chkEncargado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ABMCTipoElemento frame = new ABMCTipoElemento();
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
	public ABMCTipoElemento() {
		setClosable(true);
		setTitle("ABMCTipoElemento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 429, 330);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblId = new JLabel("ID");
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
 	             
		          if(Character.isDigit(c)) { 
		              getToolkit().beep(); 
		               ke.consume(); 
		              }
		}
			}
		);
		txtNombre.setColumns(10);
		
		JLabel lblCantmax = new JLabel("Cant.max.");
		
		txtCantMax = new JTextField();
		txtCantMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
 	             
		          if(Character.isLetter(c)) { 
		              getToolkit().beep(); 
		               ke.consume(); 
		              }
		
			}
		});
		txtCantMax.setColumns(10);
		
		JLabel lblTiempoLmite = new JLabel("Tiempo l\u00EDmite");
		
		txtLimite = new JTextField();
		txtLimite.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
	             
		          if(Character.isLetter(c)) { 
		              getToolkit().beep(); 
		               ke.consume(); 
		              }
		
				}
		});
		txtLimite.setColumns(10);
		
		JLabel lblAnticipacindas = new JLabel("Anticipaci\u00F3n (d\u00EDas)");
		
		txtDiasAntic = new JTextField();
		txtDiasAntic.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent ke) {
				char c=ke.getKeyChar(); 
	             
		          if(Character.isLetter(c)) { 
		              getToolkit().beep(); 
		               ke.consume(); 
		              }
		
			
			}
		});
		txtDiasAntic.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				buscarClick();
 			}
 		});
		
		chkEncargado = new JCheckBox("Encargado");
		chkEncargado.setSelected(true);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				agregarClick();
 			}
 		});
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				modificarClick();
 			}
 		});
		
		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				borrarClick();
 			}
 		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNombre)
								.addComponent(lblId, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCantmax)
								.addComponent(lblTiempoLmite))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtNombre)
								.addComponent(txtID, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCantMax))
								.addComponent(txtLimite)))
						.addGroup(Alignment.TRAILING, gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(chkEncargado)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnAgregar)
									.addComponent(lblAnticipacindas))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnBorrar)
										.addGap(18)
										.addComponent(btnModificar))
									.addComponent(txtDiasAntic, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBuscar)
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblId)
						.addComponent(txtID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(txtNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCantmax)
						.addComponent(txtCantMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTiempoLmite)
						.addComponent(txtLimite, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAnticipacindas)
						.addComponent(txtDiasAntic, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chkEncargado)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAgregar)
						.addComponent(btnBorrar)
						.addComponent(btnModificar))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void buscarClick() {
 		try {
 			this.mapearAForm(ctrl.getByNomTipo(this.txtNombre.getText()));
 			} 
 		catch (Exception e) {
 			JOptionPane.showMessageDialog(this, "No se encontro el tipo");
 			}
 			 	}
 	protected void agregarClick() {
 		Tipo_Elemento t = this.mapearDeForm();
 		try{
 			ctrl.add(t);
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, "No se pudo guardar");
 			}
 			this.txtID.setText(String.valueOf(t.getIdtipo_elemento()));
 			 		
 			 	}
 	protected void borrarClick(){
 		try{
 			ctrl.delete(this.mapearDeForm());
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, e.getMessage());
 			}
 			 	}
 	protected void modificarClick(){
 		try{
 			ctrl.update(this.mapearDeForm());
 			} catch (Exception e) {
 			JOptionPane.showMessageDialog(this, e.getMessage());
 			}
 			 	}
 	
 	private void mapearAForm(Tipo_Elemento t){
 		this.txtNombre.setText(t.getNombre_tipo());
 		this.txtCantMax.setText(String.valueOf(t.getCant_max()));
 		this.txtLimite.setText(String.valueOf(t.getLim_tiempo()));
 		this.txtDiasAntic.setText(String.valueOf(t.getDias_anticip()));
 		this.txtID.setText(String.valueOf(t.getIdtipo_elemento()));
 		this.chkEncargado.setSelected(t.getEncargado());
 		
 	}
 	
 	private Tipo_Elemento mapearDeForm(){
 		Tipo_Elemento t=new Tipo_Elemento();
 		if(!this.txtID.getText().isEmpty()){
 			t.setIdtipo_elemento(Integer.parseInt(this.txtID.getText()));
 		}
 		t.setNombre_tipo(this.txtNombre.getText());
 		t.setCant_max(Integer.parseInt(this.txtCantMax.getText()));
 		t.setLim_tiempo(Integer.parseInt(this.txtLimite.getText()));
 		t.setDias_anticip(Integer.parseInt(this.txtDiasAntic.getText()));
 		t.setEncargado(this.chkEncargado.isSelected());
 		
 		return t;
 	}
 	public void showTipo(Tipo_Elemento t){
		 this.mapearAForm(t);
		 	
		 }
}
