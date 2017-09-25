package controlers;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import data.DataElemento;
import data.DataPersona;
import data.DataReserva;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.Tipo_Elemento;

public class CtrlReserva {
	private DataReserva dataRes;
	private DataElemento dataEle;
	private DataPersona dataPer;
	private DataTipoElemento dataTip;
	
	
	public CtrlReserva(){
		dataRes=new DataReserva();
		dataEle=new DataElemento();
		dataPer=new DataPersona();
		dataTip=new DataTipoElemento();
		
		
	}

	public void add(Reserva r) throws Exception{
		dataRes.add(r);}
	
	
   public void delete(Reserva r) throws Exception{
	   dataRes.remove(r);}
   
   public ArrayList<Persona>getAll() throws Exception{
		return dataPer.getAll();}
	
	public ArrayList<Elemento> getElementos() throws Exception{
		return dataEle.getAll();
			}
	public ArrayList<Reserva> getReservas() throws Exception{
		return dataRes.getAll();
			}

	public ArrayList<Tipo_Elemento>getTipos() throws Exception{ 
		// TODO Auto-generated method stub
		return dataTip.getAll();
	}
	
	public boolean validar(Reserva r){
		
		return dataRes.validar(r);
	
	}
	
	
	public ArrayList<Elemento> getElementos(Tipo_Elemento t) throws Exception{
		return dataEle.getByTipo(t);
	}	
	
	public ArrayList<Elemento> getElemDisponibles(Date f, Time h,ArrayList<Elemento>el) throws Exception
		{ return dataRes.getElemDisponibles(f, h, el);
		}

	
	 public int validarBotonBuscar(int cboTipos , String fecha,String hora) {
		
		int ok;
		 /* try 
		 {
		 Tipo_Elemento te=new Tipo_Elemento();
		 */
		//if ((cboTipos == -1) &&  (fecha.isEmpty()) && (hora.isEmpty() ))
		 if (cboTipos == -1)
		 {
 			 //te=(Tipo_Elemento)cboTipos.getSelectedItem();
 			ok= 1;
 			
		 }
		 else if ((fecha.isEmpty()) || (hora.isEmpty()))
 		{
            ok=2;
			
		} 
 		else
 		{
 			
 			ok=3;
 		}
 		return ok;
		 
	}
	
	 
	 
}	
