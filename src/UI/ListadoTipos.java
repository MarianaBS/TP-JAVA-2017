package UI;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

import java.awt.Color;

import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;

import controlers.CtrlABMTipoElemento;
import entity.Tipo_Elemento;

import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListadoTipos extends JInternalFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private ArrayList<Tipo_Elemento> ti;
CtrlABMTipoElemento ctrl= new CtrlABMTipoElemento();
	
private JTable table;

public ListadoTipos() {
	setTitle("Listado de Tipos de Elementos");
	setClosable(true);
	setBounds(100, 100, 507, 300);
	JScrollPane scrollPane = new JScrollPane();
 	JButton btnEditar = new JButton("Editar");
 	btnEditar.addMouseListener(new MouseAdapter() {
 	@Override
 	public void mouseClicked(MouseEvent arg0) {
 			btnEditarClick();
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
 this.ti=ctrl.getAll();
 		} catch (Exception e){
 JOptionPane.showMessageDialog(this,e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
 
 }
 initDataBindings();
 }
 protected void btnEditarClick() {
 int indexTipo=table.convertRowIndexToModel(table.getSelectedRow());
 
 ABMCTipoElemento tip= new ABMCTipoElemento();
 tip.showTipo(this.ti.get(indexTipo));
 
 this.getDesktopPane().add(tip);
 tip.setVisible(true);
 		
 }
 protected void initDataBindings() {
 JTableBinding<Tipo_Elemento, List<Tipo_Elemento>, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, ti, table);
 BeanProperty<Tipo_Elemento, String> tipoBeanProperty = BeanProperty.create("nombre_tipo");
jTableBinding.addColumnBinding(tipoBeanProperty).setColumnName("Nombre").setEditable(false);
BeanProperty<Tipo_Elemento, String> tipoBeanProperty_1 = BeanProperty.create("cant_max");
jTableBinding.addColumnBinding(tipoBeanProperty_1).setColumnName("Cantidad maxima").setEditable(false);

BeanProperty<Tipo_Elemento, String> tipoBeanProperty_2 = BeanProperty.create("lim_tiempo");
jTableBinding.addColumnBinding(tipoBeanProperty_2).setColumnName("Limite de Tiempo").setEditable(false);
BeanProperty<Tipo_Elemento, String> tipoBeanProperty_3 = BeanProperty.create("dias_anticip");
jTableBinding.addColumnBinding(tipoBeanProperty_3).setColumnName("Dias Anticipación").setEditable(false);

jTableBinding.setEditable(false);
jTableBinding.bind();
}
}


