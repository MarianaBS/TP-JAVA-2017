package UI;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import controlers.CtrlReserva;
import entity.Reserva;

import java.sql.*;
import org.jdesktop.beansbinding.ObjectProperty;


public class ReservasPendientes extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private ArrayList <Reserva> res;
	CtrlReserva ctrl=new CtrlReserva();
	
	private JTable table;


	public ReservasPendientes() {
		setTitle("Reservas Pendientes");
		setClosable(true);
		setBounds(100, 100, 507, 300);
		JScrollPane scrollPane = new JScrollPane();
	 	JButton btnCancelarRes = new JButton("Cancelar Reserva");
	 	btnCancelarRes.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent arg0) {
	 			btnCancelarResClick();
	 			}
	 		});
	 	GroupLayout groupLayout = new GroupLayout(getContentPane());
	 	groupLayout.setHorizontalGroup(
	 	groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
	 	.addGroup(groupLayout.createSequentialGroup().addContainerGap(368, Short.MAX_VALUE)
	 	.addComponent(btnCancelarRes).addContainerGap())
	 	);
	 	groupLayout.setVerticalGroup(
	 	groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
	 .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
	 .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnCancelarRes)
	 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	 	);
	 		
	 table = new JTable();
	 scrollPane.setViewportView(table);
	 table.setBackground(Color.LIGHT_GRAY);
	 getContentPane().setLayout(groupLayout);
	 try{
		 if(UI.MainWindow.usuarioAct.getCategoria().getId_categoria()==2){
			 this.res=ctrl.getAllPendientes();
		 }
		 else{//this.res= ctrl.getReservasPendientes();
			 this.res=ctrl.getPendientes();
		 }
	 		} 
	 catch (Exception e){
	 JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	 
	 }
	 initDataBindings();
	 }
	
	 protected void btnCancelarResClick() {
		 int indexReserva=table.convertRowIndexToModel(table.getSelectedRow());
		 if (indexReserva != -1){
		 CtrlReserva ctr=new CtrlReserva();
		 try {
			ctr.update(this.res.get(indexReserva));
			JOptionPane.showMessageDialog(this, "La reserva ha sido cancelada");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
		 else { 
			 JOptionPane.showMessageDialog(this, "Selecione una Reserva"); 
			 }
		}
	protected void initDataBindings() {
		JTableBinding<Reserva, List<Reserva>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, res, table);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_4 = BeanProperty.create("persona.apellido");
		jTableBinding.addColumnBinding(reservaBeanProperty_4).setColumnName("Apellido");
		//
		BeanProperty<Reserva, String> reservaBeanProperty_5 = BeanProperty.create("persona.nombre");
		jTableBinding.addColumnBinding(reservaBeanProperty_5).setColumnName("Nombre");
		//
		BeanProperty<Reserva, String> reservaBeanProperty = BeanProperty.create("elemento.nombre");
		jTableBinding.addColumnBinding(reservaBeanProperty).setColumnName("Elemento").setEditable(false);
		//
		BeanProperty<Reserva, String> reservaBeanProperty_1 = BeanProperty.create("elemento.tipo_Elem.nombre_tipo");
		jTableBinding.addColumnBinding(reservaBeanProperty_1).setColumnName("Tipo").setEditable(false);
		//
		BeanProperty<Reserva, Date> reservaBeanProperty_2 = BeanProperty.create("fecha");
		jTableBinding.addColumnBinding(reservaBeanProperty_2).setColumnName("Fecha").setEditable(false);
		//
		BeanProperty<Reserva, Time> reservaBeanProperty_3 = BeanProperty.create("hora");
		jTableBinding.addColumnBinding(reservaBeanProperty_3).setColumnName("Hora").setEditable(false);
		//
		jTableBinding.setEditable(false);
		jTableBinding.bind();
	}
		}



