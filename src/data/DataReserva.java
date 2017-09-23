package data;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.*;
import java.util.Date;

import util.AppDataException;
import entity.*;
 


public class DataReserva {
	public ArrayList<Reserva> getAll() throws Exception{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> res= new ArrayList<Reserva>();
		try {
		 	stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	rs = stmt.executeQuery("select * from reservas r "
		 			+ "inner join  personas p on p.idpersona=r.id_persona"
		 			+ "inner join elementos e on e.idelemento=r.id_elemento");
		 	if(rs!=null){
		 		while(rs.next()){
		 			Reserva r=new Reserva();
		 			r.setPersona(new Persona());
		 			r.setElemento(new Elemento());
		 			r.setId_reserva(rs.getInt("id_reserva"));
		 			r.setDetalle(rs.getString("detalle"));
		 			r.setEstado(rs.getString("estado"));
		 			r.setFecha(rs.getDate("fecha"));
		 			r.setHora(rs.getTime("hora"));
		 			r.getElemento().setIdelemento(rs.getInt("id_elemento"));
		 			r.getElemento().setNombre(rs.getString("nombre"));
		 			r.getPersona().setIdpersona(rs.getInt("idpersona"));
		 			r.getPersona().setApellido(rs.getString("apellido"));
		 			r.getPersona().setNombre(rs.getString("nombre"));
		 			res.add(r);
		 						}
		 				}		
			} catch (SQLException e) {throw e;
			} catch (AppDataException ade){
					throw ade;
				 		}
				try {
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				FactoryConexion.getInstancia().releaseConn();
				} catch (SQLException e) {
					e.printStackTrace();
		 		}
				
 		return res;
 		}
		 	
	public void add(Reserva r) throws Exception{
 		PreparedStatement stmt=null;
 		ResultSet keyResultSet=null;
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"insert into reservas(fecha, hora, id_persona, id_elemento, estado, detalle) "
 					+ "values (?,?,?,?,?,?)",
 					PreparedStatement.RETURN_GENERATED_KEYS
 					);
 			stmt.setDate(1, r.getFecha());
 			stmt.setTime(2, r.getHora());
 			stmt.setInt(3, r.getPersona().getIdpersona());
 			stmt.setInt(4, r.getElemento().getIdelemento());
 			stmt.setString(5, r.getEstado());
 			stmt.setString(6, r.getDetalle());
  			stmt.executeUpdate();
 			keyResultSet=stmt.getGeneratedKeys();
 			if(keyResultSet!=null && keyResultSet.next()){
 				r.setId_reserva(keyResultSet.getInt(1));
 			}
 		} catch (SQLException | AppDataException e) {
 			throw e;
 		}
 		try {
 			if(keyResultSet!=null)keyResultSet.close();
 			if(stmt!=null)stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
	public void remove(Reserva r) throws Exception{
 		PreparedStatement stmt=null;
 		
 		try {
 			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
 					"delete from reservas where id_reserva=?"
 					);
 			stmt.setInt(1, r.getId_reserva());
 			stmt.executeUpdate();
 			
 		} catch (SQLException | AppDataException e) {
 			throw e;
 		}
 		try {
 			
 			if(stmt!=null)stmt.close();
 			FactoryConexion.getInstancia().releaseConn();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}

 	
	public ArrayList<Elemento> getElemDisponibles(Date f,Time h,ArrayList<Elemento> elem) throws Exception
	{
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Elemento>e=new ArrayList<Elemento>();
		
		//for (int i=0; i<elem.size();i++){
			
		stmt = FactoryConexion.getInstancia().getConn().createStatement();
		 	/*rs = stmt.executeQuery("select * from elementos e inner join tipo_elemento te "
		 			+ "on e.idtipo_elemento=e.te.idtipo_elemento where e.idelemento='" + elem.get(i).getIdelemento() +
		 			" and e.idelemento not in (select * reservas where fecha='" + f + "and hora='"+ h +")");*/
		rs = stmt.executeQuery("select * from elementos e inner join tipo_elemento te "
	 			+ "on e.idtipo_elemento=te.idtipo_elemento where idelemento not in "
	 			+ "(select id_elemento from reservas where fecha='" + f + "'and hora='"+ h +"')");
	
		 		if(rs!=null){
			 		while(rs.next()){
			 			Elemento el=new Elemento();
			 			el.setTipo_Elem(new Tipo_Elemento());
			 			el.setIdelemento(rs.getInt("idelemento"));
			 			el.setNombre(rs.getString("nombre"));
			 			el.getTipo_Elem().setIdtipo_elemento(rs.getInt("idtipo_elemento"));
			 			el.getTipo_Elem().setNombre_tipo(rs.getString("nombre_tipo"));
			 			e.add(el);
			  		}
						try {
						if(rs!=null)rs.close();
						if(stmt!=null)stmt.close();
						FactoryConexion.getInstancia().releaseConn();
						} catch (SQLException ex) {
							ex.printStackTrace();
				 		}
						 		
		 		}
		 	 ArrayList <Elemento> edisp=new ArrayList<Elemento>();
		 			
				for (int i=0; i<e.size();i++)
				{ if (elem.contains(e.get(i)))edisp.add(e.get(i));}
				
		return edisp;		
			
	}
	public boolean validar(Reserva r) {
		// TODO Auto-generated method stub
		int dias=r.getElemento().getTipo_Elem().getDias_anticip();
		java.util.Date hoy=new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(hoy);
		cal.add(Calendar.DAY_OF_YEAR, dias);
		if (r.getFecha().after(cal.getTime()))
			return true;
		else
		
		return false;
	}
	
	
	
}
