package controlers;

import data.DataPersona;
import entity.Persona;

public class CtrlLogin {
	
	 private DataPersona dataPer;
	 
	 
	 public CtrlLogin(){
		
	 }

	
	
	
	public Persona getUsuario(Persona p) throws Exception{
		return this.dataPer.getByDni(p);
		}	
	
	public Persona getUsuario(String u, String pas) throws Exception{
		Persona p=new Persona();
		p.setUsuario(u);
		p.setContrasenia(pas);
		return getUsuario(p);
}
}