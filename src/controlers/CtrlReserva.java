package controlers;

import java.util.ArrayList;

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

	public ArrayList<Tipo_Elemento>getTipos() throws Exception{ {
		// TODO Auto-generated method stub
		return dataTip.getAll();
	}
	}
	
	public ArrayList<Elemento> getElementos(Tipo_Elemento t) throws Exception{
		return dataEle.getByTipo(t);
	}
	
	
	}
	
