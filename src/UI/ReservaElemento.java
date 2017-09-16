package UI;

import entity.Categoria;
import entity.Elemento;
import entity.Persona;
import entity.Tipo_Elemento;
import entity.Reserva;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JTextField;

//import com.toedter.calendar.JDateChooser;


import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import controlers.CtrlReserva;

import javax.swing.JEditorPane;
import javax.swing.JLayeredPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class ReservaElemento extends JInternalFrame {
	
	private CtrlReserva ctrl=new CtrlReserva();

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField txtDetalle;
	private JTextField txtId;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JComboBox cboTipos;
	private JComboBox cboElementos;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservaElemento frame = new ReservaElemento();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public ReservaElemento() {
		setClosable(true);
		setTitle("Reserva de Elemento");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 347, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		JLabel lblTipoDeElemento = new JLabel("Tipo de Elemento");
		
		cboTipos = new JComboBox();
		
		JLabel lblFecha = new JLabel("Fecha(aaaammdd)");
		
		JLabel lblHora = new JLabel("Hora(hhmm)");
		
		JLabel lblElementos = new JLabel("Elemento");
		
		JLabel lblDetalle = new JLabel("Detalle");
		
		cboElementos = new JComboBox();
		
		JTextArea txtDetalle = new JTextArea();
		txtDetalle.setRows(2);
		txtDetalle.setLineWrap(true);
		
		JButton btnBuscar = new JButton("Buscar");
			
		btnBuscar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				buscarClick();
 			}

			
 		});
		
		JButton btnAceptar = new JButton("Aceptar");
			btnAceptar.addMouseListener(new MouseAdapter() {
 			@Override
 			public void mouseClicked(MouseEvent e) {
 				try {
					aceptarClick();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 			}

 		});
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
 			public void mouseClicked(MouseEvent e) {
 				cancelarClick();
 			}

			private void cancelarClick() {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		
		JLabel lblIdReserva = new JLabel("Id Reserva");
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setColumns(10);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		
		txtHora = new JTextField();
		txtHora.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblHora)
						.addComponent(lblFecha)
						.addComponent(lblTipoDeElemento)
						.addComponent(lblIdReserva)
						.addComponent(lblDetalle)
						.addComponent(lblElementos))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
							.addComponent(txtId)
							.addComponent(cboTipos, 0, 116, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtHora, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(txtFecha, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnBuscar)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnAceptar)
								.addGap(18)
								.addComponent(btnCancelar)))
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(txtDetalle, Alignment.LEADING)
							.addComponent(cboElementos, Alignment.LEADING, 0, 117, Short.MAX_VALUE)))
					.addGap(61))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblIdReserva)
						.addComponent(txtId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTipoDeElemento)
						.addComponent(cboTipos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFecha)
								.addComponent(txtFecha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHora)
								.addComponent(txtHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(26)
							.addComponent(btnBuscar)))
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblElementos)
						.addComponent(cboElementos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDetalle)
						.addComponent(txtDetalle, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnCancelar))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		loadLists();
	}
	
	 public void loadLists() {
		 	try {
		 		this.cboTipos.setModel(new DefaultComboBoxModel<Object>(this.ctrl.getTipos().toArray()));
		 		this.cboTipos.setSelectedIndex(-1);
		 	} catch (Exception e) {
		 JOptionPane.showMessageDialog(this, "Error recuperando Tipos de Elementos");
		 }
	 }
	
	 private void buscarClick() {
		 try {
		 Tipo_Elemento te=new Tipo_Elemento();
		 if (cboTipos.getSelectedIndex() != -1){
 			 te=(Tipo_Elemento)cboTipos.getSelectedItem();
 					 
			this.cboElementos.setModel(new DefaultComboBoxModel<Object>(this.ctrl.getElementos(te).toArray()));
			this.cboElementos.setSelectedIndex(-1);
		} } 
		 catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Error recuperando Elementos");
	 		
		}
		 }
			

		private void aceptarClick() throws Exception {
			// TODO Auto-generated method stub
			Reserva r=this.mapearDeForm();
	 		try{
	 			ctrl.add(r);
	 			} catch (Exception e) {
	 			JOptionPane.showMessageDialog(this, "No se pudo guardar");
	 			}
	 			this.txtId.setText(String.valueOf(r.getId_reserva()));
	 			 		
	 			 	}
		
		private Reserva mapearDeForm() throws Exception {
			// TODO Auto-generated method stub
			Reserva r=new Reserva();
	 		if(!this.txtId.getText().isEmpty()){
	 			r.setId_reserva(Integer.parseInt(this.txtId.getText()));
	 		}
	 		
	 		
	 		 java.sql.Date fecha = convertirFecha(this.txtFecha.getText());
	         r.setFecha(fecha);

	 		
	         java.sql.Time hora = convertirHora(this.txtHora.getText());
   	 		 r.setHora(hora);
	 		
	 		//java.sql.Date fecha = Date.valueOf(this.txtFecha.getText());
	 		//java.sql.Time hora = Time.valueOf(this.txtHora.getText());
	 		
	 		//r.setFecha(fecha);
	 		//r.setHora(hora);
	 		
	 		CtrlABMPersona cper=new CtrlABMPersona();
	 		 		
	 		r.setPersona(cper.getByDni("987654"));
	 		
	 		if (cboElementos.getSelectedIndex() != -1){
	 			 r.setElemento((Elemento)cboElementos.getSelectedItem());
	 			 }
	 		return r;
			
			
	 		}
		private java.sql.Date convertirFecha(String f) throws ParseException {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	         java.util.Date parsed = format.parse(f);
	         java.sql.Date fecha = new java.sql.Date(parsed.getTime());
			return fecha;
		}
		
		private java.sql.Time convertirHora(String h) throws ParseException {
			SimpleDateFormat f = new SimpleDateFormat("HHmm");
	        java.util.Date pars = f.parse(h);
	        java.sql.Time hora = new java.sql.Time(pars.getTime());
			return hora;
		}
}

