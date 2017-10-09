package UI;
 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
 

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;

import controlers.CtrlLogin;
import entity.Categoria;
import entity.Persona;

import java.awt.BorderLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import UI.*;

public class MainWindow {

private static JFrame frmSistemaDeReservas;
private JDesktopPane desktopPane;
public static Persona usuarioAct;
private JMenu mnuPersona;
private JMenu mnuElementos;
private JMenu mnuReservas;
private JMenu mnuTipos;
private JMenu mnuInicio;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {

public void run() {
	try {
		MainWindow window = new MainWindow();
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
			Dimension ventana = window.frmSistemaDeReservas.getSize();
			window.frmSistemaDeReservas.setLocation(Integer.valueOf((pantalla.width-ventana.width)/2), 
					Integer.valueOf(pantalla.height-ventana.height)/2);
			window.frmSistemaDeReservas.setVisible(true);
			Login l=new Login();
			l.pack();

		    Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
		    
		    Dimension v = l.getSize();
		    
		    l.setLocation(
		        (p.width - v.width) / 2,
		        (p.height - v.height) / 2);
		    
		    l.setVisible(true);
		    	   
			
	} catch (Exception e) {
	e.printStackTrace();
	}
}
});
}

public MainWindow() {
	
	initialize();
	//frmSistemaDeReservas.getContentPane().setBackground(Color.green);

	
}

private void initialize() {
frmSistemaDeReservas = new JFrame();
frmSistemaDeReservas.setTitle("Sistema de Reservas");
frmSistemaDeReservas.setBounds(100, 100, 715, 485);
frmSistemaDeReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frmSistemaDeReservas.getContentPane().setLayout(new BorderLayout(0, 0));
desktopPane = new JDesktopPane();
frmSistemaDeReservas.getContentPane().add(desktopPane, BorderLayout.CENTER);


JMenuBar menuBar = new JMenuBar();
frmSistemaDeReservas.setJMenuBar(menuBar);
mnuInicio = new JMenu("Inicio");
menuBar.add(mnuInicio);
JMenuItem mnuCerrarSesion = new JMenuItem("Cerrar Sesi\u00F3n");

mnuCerrarSesion.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		mnuCerrarSesionClick();
	}
});
mnuInicio.add(mnuCerrarSesion);
JMenuItem mnuSalir = new JMenuItem("Salir");
mnuSalir.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		mnuSalirClick();
	}
});
mnuInicio.add(mnuSalir);
mnuPersona = new JMenu("Personas");
menuBar.add(mnuPersona);
JMenuItem mnuABMCPersona = new JMenuItem("ABMCPersonas");
mnuABMCPersona.addComponentListener(new ComponentAdapter() {
});
mnuABMCPersona.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCPersonaClick();
}
});
mnuPersona.add(mnuABMCPersona);

JMenuItem mntmListado = new JMenuItem("Listado");
mntmListado.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoPersonaClick();
}
});
mnuPersona.add(mntmListado);
mnuTipos = new JMenu("Tipos de Elementos");
JMenuItem mnuABMCTipos = new JMenuItem("ABMC Tipos");
mnuTipos.add(mnuABMCTipos);
mnuABMCTipos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCTiposClick();
}
});
menuBar.add(mnuTipos);

JMenuItem mnuListadoTipos = new JMenuItem("Listado");
mnuListadoTipos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoTiposClick();
}
});
mnuTipos.add(mnuListadoTipos);

mnuElementos = new JMenu("Elementos");
menuBar.add(mnuElementos);
JMenuItem mnuABMCElementos = new JMenuItem("ABMC Elementos");
mnuElementos.add(mnuABMCElementos);
mnuABMCElementos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCElementosClick();
}});

JMenuItem mnuListadoElementos = new JMenuItem("Listado ");
mnuElementos.add(mnuListadoElementos);
mnuListadoElementos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoElementosClick();
}});


mnuReservas = new JMenu("Reservas");
menuBar.add(mnuReservas);
JMenuItem mnuReservaElemento = new JMenuItem("Reserva Elemento");
mnuReservas.add(mnuReservaElemento);
mnuReservaElemento.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuReservaElementoClick();
}});

JMenuItem mnuReservasPendientes = new JMenuItem("Reservas pendientes");
mnuReservas.add(mnuReservasPendientes);
mnuReservasPendientes.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuReservasPendientesClick();
}});


}

protected void mnuReservasPendientesClick() {
	// TODO Auto-generated method stub
	ReservasPendientes rp=new ReservasPendientes();
	MainWindow.centrar(rp);
	desktopPane.add(rp);
	rp.setVisible(true);
}

protected void mnuCerrarSesionClick() {
	// TODO Auto-generated method stub
	Login l=new Login();
	l.pack();

    Dimension p = Toolkit.getDefaultToolkit().getScreenSize();
    
    Dimension v = l.getSize();
    
    l.setLocation(
        (p.width - v.width) / 2,
        (p.height - v.height) / 2);
    
    l.setVisible(true);
}

protected void mnuABMCPersonaClick() {
ABMCPersonaDesktop pd= new ABMCPersonaDesktop();
MainWindow.centrar(pd);
desktopPane.add(pd);
pd.setVisible(true);
}

protected void mnuListadoPersonaClick() {
ListadoPersonas lp= new ListadoPersonas();
MainWindow.centrar(lp);
desktopPane.add(lp);
lp.setVisible(true);
}

protected void mnuABMCTiposClick() {
ABMCTipoElemento td= new ABMCTipoElemento();
MainWindow.centrar(td);
desktopPane.add(td);
td.setVisible(true);
}
protected void mnuListadoTiposClick() {
ListadoTipos lt= new ListadoTipos();
MainWindow.centrar(lt);
desktopPane.add(lt);
lt.setVisible(true);}

protected void mnuABMCElementosClick() {
ABMCElementos ed= new ABMCElementos();
MainWindow.centrar(ed);
desktopPane.add(ed);
ed.setVisible(true);
}


protected void mnuListadoElementosClick() {
ListadoElementos le= new ListadoElementos();
MainWindow.centrar(le);
desktopPane.add(le);
le.setVisible(true);
}

protected void mnuReservaElementoClick() {
	ReservaElemento rel=new ReservaElemento();
	MainWindow.centrar(rel);
	desktopPane.add(rel);
	rel.setVisible(true);
}

protected void mnuSalirClick() {
	// TODO Auto-generated method stub
	System.exit(0);
}


protected static void visibleUsuario()
{
	frmSistemaDeReservas.getJMenuBar().getMenu(0).getModel().setEnabled(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(1).getModel().setEnabled(false);
	frmSistemaDeReservas.getJMenuBar().getMenu(2).getModel().setEnabled(false);;
	frmSistemaDeReservas.getJMenuBar().getMenu(3).getModel().setEnabled(false);
	frmSistemaDeReservas.getJMenuBar().getMenu(4).getModel().setEnabled(true);
	
}


protected static void visibleAdmin()
{
	frmSistemaDeReservas.getJMenuBar().getMenu(0).getModel().setEnabled(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(1).getModel().setEnabled(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(2).getModel().setEnabled(true);;
	frmSistemaDeReservas.getJMenuBar().getMenu(3).getModel().setEnabled(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(4).getModel().setEnabled(true);
	
}

protected static  void visibleEncargado()
{
	frmSistemaDeReservas.getJMenuBar().getMenu(0).getModel().setEnabled(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(1).getModel().setEnabled(false);
	frmSistemaDeReservas.getJMenuBar().getMenu(2).getModel().setEnabled(true);;
	frmSistemaDeReservas.getJMenuBar().getMenu(3).getModel().setEnabled(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(4).getModel().setEnabled(true);
	
}


public static void habilitarMenu(){
		
	   
		switch (usuarioAct.getCategoria().getId_categoria()){
		case 1:
		{
			MainWindow.visibleEncargado();
		}
		break;
		case 2:
		{
			MainWindow.visibleAdmin();
		}
		break;
		
		case 3:
		{
			MainWindow.visibleUsuario();
		}
		break;
		
		default: {JOptionPane.showMessageDialog(frmSistemaDeReservas, "Arruinó el sistema!", "Error", 0);}
			
			
		}
}

public static void centrar (JInternalFrame jf){
jf.pack();

Dimension p = Toolkit.getDefaultToolkit().getScreenSize();

Dimension v = jf.getSize();

jf.setLocation((p.width - v.width) / 8,
			(p.height - v.height) / 10);}

}

