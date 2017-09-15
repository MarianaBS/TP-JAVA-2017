package controlers;
import java.util.ArrayList;




import data.DataElemento;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Tipo_Elemento;

public class CtrlABMElemento {
		private DataElemento dataEle;
		private DataTipoElemento dataTie;
		private ArrayList<Elemento> elem;
		
	public CtrlABMElemento(){
		dataEle= new DataElemento();
		dataTie=new DataTipoElemento();
		elem= new ArrayList<Elemento>();
		}
		
	public void add(Elemento e) throws Exception{
		dataEle.add(e);}
	
	
   public void delete(Elemento e) throws Exception{
	   dataEle.remove(e);}
   
		
	public void update(Elemento e) throws Exception{
		dataEle.update(e);
		//dataEle.add(e);
		}
		
		
		
	public Elemento getByNombre(Elemento e) throws Exception{
	return this.dataEle.getByNombre(e);
	}	
		
	
	public Elemento getByNombre(String n) throws Exception{
	Elemento e=new Elemento();
	e.setNombre(n);
	return getByNombre(e);
	}
	
	
		
	public ArrayList<Elemento>getAll() throws Exception{
		return dataEle.getAll();}
	
	public ArrayList<Tipo_Elemento> getTipos() throws Exception{
		return dataTie.getAll();
	
		}
		
		
	
}
