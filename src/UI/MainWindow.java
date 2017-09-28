package UI;
 
import java.awt.Dimension;
import java.awt.EventQueue;
 

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JDesktopPane;

import java.awt.BorderLayout;

public class MainWindow {

private JFrame frmSistemaDeReservas;
private JDesktopPane desktopPane;
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
	} catch (Exception e) {
	e.printStackTrace();
	}
}
});
}

public MainWindow() {
initialize();
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
JMenu mnuTipos = new JMenu("Tipos de Elementos");
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

JMenu mnuElementos = new JMenu("Elementos");
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


JMenu mnuReservas = new JMenu("Reservas");
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
	desktopPane.add(rp);
	rp.setVisible(true);
}

protected void mnuCerrarSesionClick() {
	// TODO Auto-generated method stub
	Login lo=new Login();
	desktopPane.add(lo);
	lo.setVisible(true);
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
}

