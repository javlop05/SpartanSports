package Abonos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.TransferAbono;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DAOAbonosImp implements DAOAbonos {

	/**
	 * @param abono: contiene el abono que se desea comprobar.
	 * @return Devuelve un booleano, true si el abono recibido no existe en la base de datos,
	 * false en caso de que exista.
	 * @Descripcion Conecta con la BBDD y comprueba si el abono recibido ya existe, si existe devuelve un false;
	 * si no existe devuelve true.
	 */
	public boolean comprobarAbono(TransferAbono abono) throws ClassNotFoundException, SQLException{
		//Declaracion
		boolean correcto;
		int id;
		java.util.Date fecha;
		Statement st;
		ResultSet rs;
		
		
			//Inicializacion.
			correcto = false;
			id = -1;
			fecha = new java.util.Date();
		
		
		//Encendiendo conexion BBDD...
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
				
		rs = (ResultSet) st.executeQuery("SELECT * FROM abonos WHERE ID_usuario ='" + abono.getIdUsuario() +"'"
				+ "and (Nombre='" + abono.getNombre() + "')");
		rs.next();

		try{
			java.util.Date bbdd = rs.getDate("Fecha_fin");	
			id = rs.getInt("ID");
			if(bbdd.before(fecha)){
				eliminarAbono(id, st);
				correcto = true;
			}
		}
		catch(Exception e){
			rs.close();
		}

		if (id == -1) correcto = true;
		else abono.setFechaFinal(rs.getDate("Fecha_fin"));
		
		//Cerrando la conexion con la BBDD...
		rs.close();
		st.close();
		conexion.close();
		
		return correcto;
		
	}
	
	private void eliminarAbono(int id, Statement st) throws SQLException {
		st.executeUpdate("DELETE FROM abonos WHERE ID="+id);
	}
	
	/**
	 * @param filtroBusqueda: contiene el filtro de busqueda elegido (En el inicio es "*");
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "");
	 * @return Devuelve la lista obtenida segun el filtroBusqueda y la busqueda.
	 * @Descripcion Conecta con la BBDD y obtiene la lista de Abonos segun filtroBusqueda y busqueda,
	 * por último la devuelve.
	 */
	public List <TransferAbono> getListaAbonos(String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException{
		//Declaracion
		List <TransferAbono> lista;
		Statement st;
		ResultSet rs;
		int id, id_usuario, dni;
		String nombre;
		Date FechaInicio, FechaFin;
		
		//Inicializacion
		lista = new ArrayList <TransferAbono>();
		
		//Conectarse a la base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		if (filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM abonos"); 
		else
			rs = (ResultSet) st.executeQuery("SELECT * FROM abonos WHERE " +filtroBusqueda+ "='" +busqueda+ "'"); 
		
		while (rs.next()){
			id = (rs.getInt("ID"));
			nombre = rs.getString("Nombre");
			FechaInicio = rs.getDate("Fecha_inicio");
			FechaFin = rs.getDate("Fecha_fin");
			id_usuario = rs.getInt("ID_usuario");
			dni = rs.getInt("DniUsuario");
			TransferAbono aux = new TransferAbono(id, id_usuario, nombre, FechaInicio, FechaFin, dni);
			if(!comprobarAbono(aux)){
				lista.add(aux);
			}
		}
			
		//Apagar base de datos
		st.close();
		conexion.close();
		return lista;
	}

	/**
	 * @param abono: contiene el abono que se quiere agregar.
	 * @Descripcion Conecta con la BBDD, asigna el id y agrega el abono recibido a la BBDD.
	 */
	public void setAbono(TransferAbono abono) throws ClassNotFoundException, SQLException {
		//Declaracion
		int id_usuario, dni, id;
		String ini, fin, tipo;
		Statement st;
		ResultSet rs;
		
			//Inicializacion
			id_usuario = abono.getIdUsuario();
			tipo = abono.getNombre();
			dni = abono.getDniUsuario();
			ini = dateToString(abono.getFechaInicio());
			fin = dateToString(abono.getFechaFinal());
			id = 0;
		
		//Conectarse a la base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		

		rs = (ResultSet) st.executeQuery("SELECT ID FROM abonos"); 

		while (rs.next())
			id = rs.getInt("ID");
		id++;
		st.executeUpdate("INSERT INTO abonos (ID, ID_usuario, Nombre, Fecha_inicio, Fecha_fin, DniUsuario) VALUES "
					+ "('"+id+"','"+id_usuario+"','"+tipo+"','"+ini+"','"+fin+"','"+dni+"')");
		rs.close();
		
		//Apagar base de datos
		st.close();
		conexion.close();
		
	}
	

	private static String dateToString(java.util.Date date){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}