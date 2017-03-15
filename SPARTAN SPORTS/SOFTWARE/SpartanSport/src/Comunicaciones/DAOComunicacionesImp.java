package Comunicaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

import transfer.TipoUsuario;
import transfer.TransferMensaje;
import transfer.TransferPista;
import transfer.TransferUsuario;

public class DAOComunicacionesImp implements DAOComunicaciones{

	/**
	 * @param mensaje: contiene el mensaje a enviar.
	 * @Descripcion: Conecta a la BBDD, calcula el id del nuevo mensaje e introduce
	 * el mensaje recibido en la BBDD.
	 */
	public void setMensaje(TransferMensaje mensaje) throws SQLException, ClassNotFoundException {
		//Declaracion.
		int ID;
		Statement st;
		ResultSet rs;
		String fechaMensaje;

		
			//Inicializacion
			ID = 0;
			fechaMensaje = this.dateToString(mensaje.getFecha());
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		

		rs = (ResultSet) st.executeQuery("SELECT * FROM comunicacion"); 
		while (rs.next()){
			ID = rs.getInt("ID");
		}
		ID++;
		st.executeUpdate("INSERT INTO comunicacion (ID, Emisor, Receptor, Asunto, Contenido, ID_emisor, ID_receptor, Fecha) VALUES ('"+ID+"','"+mensaje.getEmisor()+"','"+mensaje.getReceptor()+"','"+mensaje.getAsunto()+"','"+mensaje.getContenido()+"','"+mensaje.getIdEmisor()+"','"+mensaje.getIdReceptor()+"','"+fechaMensaje+"')");	
			
		rs.close();
		st.close();
		conexion.close();
	}

	/**
	 * @param idReceptor: contiene el id del Usuario receptor.
	 * @param filtroBusqueda: contiene el filtro de busqueda elegido (En el inicio es "*").
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "").
	 * @return Devuelve la lista de mensajes recibidos segun el idReceptor, filtroBusqueda,
	 * busqueda. 
	 * @Descripcion Conecta con la BBDD, obtiene la lista de mensajes recibidos segun los parametros recibidos,
	 * y por ultimo la devuelve.
	 */
	public List<TransferMensaje> getListaMensajesRecibidos(int idReceptor, String filtroBusqueda,
			String busqueda) throws ClassNotFoundException, SQLException {
		//Declaracion.
		List <TransferMensaje> lista;
		TransferMensaje aux;
		Statement st;
		ResultSet rs;
		
		
			//Inicializacion
			lista = new ArrayList<TransferMensaje>();
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		if (filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM comunicacion WHERE ID_receptor='" + idReceptor + "'"); 
		else 
			rs = (ResultSet) st.executeQuery("SELECT * FROM comunicacion WHERE ID_receptor='"+ idReceptor +"'and "+filtroBusqueda+ "='" +busqueda+ "'"); 
		while (rs.next()){
			aux = new TransferMensaje(rs.getInt("Emisor"), rs.getInt("Receptor"), rs.getString("Asunto"), rs.getString("Contenido"), rs.getDate("Fecha"), rs.getInt("ID"), rs.getInt("ID_emisor"), rs.getInt("ID_receptor"));
			lista.add(aux);
		}
			
		//Apago conexion con la BBDD
		rs.close();
		st.close();
		conexion.close();
		
		return lista;
	}
	
	/**
	* @param idEmisor: contiene el id del Usuario emisor.
	* @param filtroBusqueda: contiene el filtro de busqueda elegido (En el inicio es "*").
	* @param busqueda: contiene el texto a buscar (En el inicio es vacio "").
	* @return Devuelve la lista de mensajes enviados segun el idEmisor, filtroBusqueda,
	* busqueda. 
 	*@Descripcion Conecta con la BBDD, obtiene la lista de mensajes enviados segun los parametros recibidos,
	* y por ultimo la devuelve.
	*/
	public List<TransferMensaje> getListaMensajesEnviados(int idEmisor, String filtroBusqueda,
			String busqueda) throws ClassNotFoundException, SQLException {
		//Declaracion.
		List <TransferMensaje> lista;
		TransferMensaje aux;
		Statement st;
		ResultSet rs;
		
			//Inicializacion
			lista = new ArrayList<TransferMensaje>();
				
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		if (filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM comunicacion WHERE ID_emisor='" + idEmisor +"'"); 
		else 
			rs = (ResultSet) st.executeQuery("SELECT * FROM comunicacion WHERE ID_emisor='"+ idEmisor +"'and "+filtroBusqueda+ "='" +busqueda+ "'"); 
		while (rs.next()){
				aux = new TransferMensaje(rs.getInt("Emisor"), rs.getInt("Receptor"), rs.getString("Asunto"), rs.getString("Contenido"), rs.getDate("Fecha"), rs.getInt("ID"), rs.getInt("ID_emisor"), rs.getInt("ID_receptor"));
				lista.add(aux);
			}
		
		//Apago conexion con la BBDD
		rs.close();
		st.close();
		conexion.close();
		return lista;
	}
	
	private static String dateToString(java.util.Date date){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
}
