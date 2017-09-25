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

import controlers.CtrlABMPersona;
import controlers.CtrlReserva;
import entity.Persona;
import entity.Reserva;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.ScrollPaneConstants;

public class ReservasPendientes extends JInternalFrame {
	public ReservasPendientes() {
		setTitle("Listado de Reservas Pendientes");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setHorizontalAlignment(SwingConstants.TRAILING);
		getContentPane().add(btnNewButton, BorderLayout.SOUTH);
		
	}
	private static final long serialVersionUID = 1L;

	private ArrayList<Reserva> res;
	CtrlReserva ctrl= new CtrlReserva();
		
	private JTable table;

	public void ListadoReservasPendientes() {
		setTitle("Listado de reservas pendientes");
		setClosable(true);
		setBounds(100, 100, 507, 300);
		JScrollPane scrollPane = new JScrollPane();
	 	JButton btnEditar = new JButton("Editar");
	 	btnEditar.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent arg0) {
//	 			btnEditarClick();
	 			}
	 		});
	 	GroupLayout groupLayout = new GroupLayout(getContentPane());
	 	groupLayout.setHorizontalGroup(
	 	groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
	 	.addGroup(groupLayout.createSequentialGroup().addContainerGap(368, Short.MAX_VALUE)
	 	.addComponent(btnEditar).addContainerGap())
	 	);
	 	groupLayout.setVerticalGroup(
	 	groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
	 .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
	 .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEditar)
	 .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	 	);
	 		
	 table = new JTable();
	 scrollPane.setViewportView(table);
	 table.setBackground(Color.LIGHT_GRAY);
	 getContentPane().setLayout(groupLayout);
	 try{
	 this.res=ctrl.getReservas();
	 		} catch (Exception e){
	 JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	 
	 		}

   }
	}



