package UI;
 
import java.awt.Dimension;
import java.awt.EventQueue;
 

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;
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

private JFrame frmSistemaDeReservas;
private JDesktopPane desktopPane;
public static Persona usuarioAct;
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
	//habilitarMenu();
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
JMenu mnuInicio = new JMenu("Inicio");
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
JMenu mnuPersona = new JMenu("Personas");
menuBar.add(mnuPersona);
JMenuItem mnuABMCPersona = new JMenuItem("ABMCPersonas");
mnuABMCPersona.addComponentListener(new ComponentAdapter() {
});
//mnuABMCPersona.setVisible(false);
mnuABMCPersona.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCPersonaClick();
}
});
mnuPersona.add(mnuABMCPersona);

JMenuItem mntmListado = new JMenuItem("Listado");
//mntmListado.setVisible(false);
mntmListado.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoPersonaClick();
}
});
mnuPersona.add(mntmListado);
JMenu mnuTipos = new JMenu("Tipos de Elementos");
JMenuItem mnuABMCTipos = new JMenuItem("ABMC Tipos");
mnuTipos.add(mnuABMCTipos);
//mnuABMCTipos.setVisible(false);
mnuABMCTipos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCTiposClick();
}
});
menuBar.add(mnuTipos);

JMenuItem mnuListadoTipos = new JMenuItem("Listado");
//mnuListadoTipos.setVisible(false);
mnuListadoTipos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoTiposClick();
}
});
mnuTipos.add(mnuListadoTipos);

JMenu mnuElementos = new JMenu("Elementos");
menuBar.add(mnuElementos);
JMenuItem mnuABMCElementos = new JMenuItem("ABMC Elementos");
mnuElementos.add(mnuABMCElementos);
//mnuABMCElementos.setVisible(false);
mnuABMCElementos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuABMCElementosClick();
}});

JMenuItem mnuListadoElementos = new JMenuItem("Listado ");
mnuElementos.add(mnuListadoElementos);
//mnuListadoElementos.setVisible(false);
mnuListadoElementos.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuListadoElementosClick();
}});


JMenu mnuReservas = new JMenu("Reservas");
menuBar.add(mnuReservas);
JMenuItem mnuReservaElemento = new JMenuItem("Reserva Elemento");
mnuReservas.add(mnuReservaElemento);
//mnuReservaElemento.setVisible(false);
mnuReservaElemento.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuReservaElementoClick();
}});

JMenuItem mnuReservasPendientes = new JMenuItem("Reservas pendientes");
mnuReservas.add(mnuReservasPendientes);
//mnuReservasPendientes.setVisible(false);
mnuReservasPendientes.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
mnuReservasPendientesClick();
}});


}

protected void mnuReservasPendientesClick() {
	// TODO Auto-generated method stub
	ReservasPendientes rp=new ReservasPendientes();
	desktopPane.add(rp);
	rp.setVisible(true);
}

protected void mnuCerrarSesionClick() {
	// TODO Auto-generated method stub
	Login l=new Login();
	//desktopPane.add(lo);
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
desktopPane.add(pd);
pd.setVisible(true);
}

protected void mnuListadoPersonaClick() {
ListadoPersonas lp= new ListadoPersonas();
desktopPane.add(lp);
lp.setVisible(true);
}

protected void mnuABMCTiposClick() {
ABMCTipoElemento td= new ABMCTipoElemento();
desktopPane.add(td);
td.setVisible(true);
}
protected void mnuListadoTiposClick() {
ListadoTipos lt= new ListadoTipos();
desktopPane.add(lt);
lt.setVisible(true);}

protected void mnuABMCElementosClick() {
ABMCElementos ed= new ABMCElementos();
desktopPane.add(ed);
ed.setVisible(true);
}


protected void mnuListadoElementosClick() {
ListadoElementos le= new ListadoElementos();
desktopPane.add(le);
le.setVisible(true);
}

protected void mnuReservaElementoClick() {
	ReservaElemento rel=new ReservaElemento();
	desktopPane.add(rel);
	rel.setVisible(true);
}

private void mnuSalirClick() {
	// TODO Auto-generated method stub
	frmSistemaDeReservas.dispose();
}


public void visibleUsuario()
{
	frmSistemaDeReservas.getJMenuBar().getMenu(0).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(1).getModel().setEnabled(false);;
	frmSistemaDeReservas.getJMenuBar().getMenu(2).getModel().setEnabled(false);;
	frmSistemaDeReservas.getJMenuBar().getMenu(3).getModel().setEnabled(false);
	frmSistemaDeReservas.getJMenuBar().getMenu(4).setVisible(true);
}


public void visibleAdmin()
{
	frmSistemaDeReservas.getJMenuBar().getMenu(0).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(1).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(2).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(3).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(4).setVisible(true);
}

public  void visibleEncargado()
{
	frmSistemaDeReservas.getJMenuBar().getMenu(0).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(1).setVisible(false);
	frmSistemaDeReservas.getJMenuBar().getMenu(2).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(3).setVisible(true);
	frmSistemaDeReservas.getJMenuBar().getMenu(4).setVisible(true);
}


public void habilitarMenu(){
		
	   
		switch (usuarioAct.getCategoria().getId_categoria()){
		case 1:
		{
			visibleEncargado();
		}
		break;
		
		case 2:
		{
			visibleAdmin();
		}
		break;
		
		case 3:
		{
			visibleUsuario();
		}
		break;
		
		default: {JOptionPane.showMessageDialog(desktopPane, this ,"Arruin� el sistema!", 0);}
			
			
		}
}
}

