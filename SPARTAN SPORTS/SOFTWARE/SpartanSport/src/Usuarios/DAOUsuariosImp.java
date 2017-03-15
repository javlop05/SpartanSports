package Usuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.TipoUsuario;
import transfer.TransferAbono;
import transfer.TransferReserva;
import transfer.TransferUsuario;
import Abonos.DAOAbonosImp;
import Reservas.DAOReservasImp;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DAOUsuariosImp implements DAOUsuarios{

	/**
	 * @param usuario: contiene un usuario, para comprobar si existe su dni en la base de datos.
	 * @return Devuelve un booleano dando a conocer si existe el dni del usuario (false en el caso de que exista,
	 * true en el caso contrario).
	 * @Descripcion Conecta con la BBDD y comprueba si existe el dni del usuario recibido, si existe devuelve false,
	 * si no existe devuelve true.
	 */
	public boolean comprobarUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException {
		//Declaracion.
		boolean correcto;
		int cargar;
		ResultSet rs;
		Statement st;
		
		
			//Inicializacion
			correcto = false; 
			cargar = -1;
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		//Primero busco si el usuario introducido existe en la BBDD
		rs = (ResultSet) st.executeQuery("SELECT Dni FROM usuarios WHERE Dni='"+usuario.getDni()+"'");
		rs.next();

		try{
			cargar = rs.getInt("Dni");
		}catch(Exception e){
			rs.close();
		}
		rs.close();
		
		if(cargar == -1) {
			correcto = true;
		}
		
		//Apago conexion con la BBDD
		st.close();
		conexion.close();
		
		return correcto;
	}

	/**
	 * @param usuario contiene los datos del usuario a dar de alta. 
	 * @Descripcion Conecta con la BBDD, calcula el ID que pertenecería al usuario e introduce el usuario recibido
	 * en la BBDD.
	 */
	public void setUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException {
		//Declaracion
		int ID, dni;
		String pass, domicilio, nombre;
		ResultSet rs;
		Statement st;
		
		
			//Inicializacion
			dni = usuario.getDni();
			pass = usuario.getPass();
			domicilio = usuario.getDomicilio();
			nombre = usuario.getNombre();
			ID = 1;
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		rs = (ResultSet) st.executeQuery("SELECT * FROM usuarios"); 
		
		while (rs.next()){
			ID = rs.getInt("ID");
		}
		ID++;
		
		st.executeUpdate("INSERT INTO usuarios (ID, Nombre, Dni, Pass, Direccion, Admin) VALUES ('"+ID+"','"+nombre+"','"+dni+"','"+pass+"','"+domicilio+"','"+TipoUsuario.CLIENTE+"')");	
		
		//Cierro la conexion con la BBDD
		rs.close();
		st.close();
		conexion.close();

		
	}

	/**
	 * @param usuario: recibe el usuario a borrar.
	 * @Descripcion Conecta con la BBDD y borra el usuario recibido por parámetro.
	 */
	public void deleteUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException {
		//Declaracion
		int dni;
		Statement st;
		
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		dni = usuario.getDni();
		st.executeUpdate("DELETE FROM usuarios WHERE Dni="+dni);
		
		//Apago conexion con la BBDD
		st.close();
		conexion.close();
		
	}
	
	/**
	 * @param usuario: recibe el usuario con los nuevos datos introducidos por el Admin.
	 * @Descripcion Conecta con la BBDD y actualiza los datos del usuario que estaban en la BBDD por los datos
	 * del usuario recibido como parámetro.
	 */
	public void modificarUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException {
		//Declaracion
		Statement st;
		
		
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		st.executeUpdate("UPDATE usuarios SET Pass='"+usuario.getPass()+"'"+"WHERE ID="+usuario.getIdUser());
		st.executeUpdate("UPDATE usuarios SET Direccion='"+usuario.getDomicilio()+"'"+"WHERE ID="+usuario.getIdUser());
		st.executeUpdate("UPDATE usuarios SET Nombre='"+usuario.getNombre()+"'"+"WHERE ID="+usuario.getIdUser());
		
		//Apago conexion con la BBDD
		st.close();
		conexion.close();
	}
	
	/**
	 * @param usuario: contiene en un inicio el nombre y la pass introducida para comprobar si existe en la
	 * BBDD.
	 * @return Devuelve un booleano para conocer si el dni y la pass han sido encontrados (true en ese caso, en el caso contrario
	 * false); en adición, el usuario recibido al ser un atributo de los paneles (para conocer el tipo de usuario que es, nombre, etc)
	 * conseguirá los campos que le faltaban (id, domicilio, tipoUsuario...)
	 * @Descripcion Conecta con la BBDD, comprueba si existe el dni y pass del usuario recibido, si existe obtiene los demas campos
	 * y devuelve true si lo ha conseguido; si no existe el nombre o la pass devuelve false.
	 */
	public boolean getUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException {
		//Declaracion
		boolean existe;
		int id;
		Statement st;
		ResultSet rs;
			
			//Inicializacion
			existe = false;
			id = -1;
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		//Primero busco si el usuario introducido existe en la BBDD
		rs = (ResultSet) st.executeQuery("SELECT * FROM usuarios WHERE Dni='"+usuario.getDni()+"'"
				+ "and (Pass='"+usuario.getPass()+"')");
		rs.next();
		
		try{
			id = rs.getInt("ID");
		}catch(Exception e){
			rs.close();
		}
		
		if(id != -1) {
			existe = true;
			usuario.setIdUser(id);	
			usuario.setNombre(rs.getString("Nombre"));
			usuario.setDomicilio(rs.getString("Direccion"));
			if(rs.getString("Admin").equals("ADMINISTRADOR")) {
				usuario.setTipoUser(TipoUsuario.ADMINISTRADOR);
			}
			else {
				usuario.setTipoUser(TipoUsuario.CLIENTE);
			}
			rs.close();
		}
		
		//Apago conexion con la BBDD
		st.close();
		conexion.close();
		return existe;
	}


	/**
	 * @param filtroBusqueda: recibe el filtro aplicado al buscar (en el inicio recibe un '*')
	 * @param busqueda: recibe el texto introducido a la hora de buscar (acorde con el filtro elegido), (en el inicio es vacio: "").
	 * @return Devuelve un List<TransferUsuario> con la lista filtrada segun los parametros recibidos.
	 * @Descripcion Conecta con la base de datos de usuarios, coge los usuarios que cumplan los filtros y los devuelve en un
	 * list<TransferUsuario>
	 */
	public List<TransferUsuario> getListaUsuarios(String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException {
		//Declaracion
		TipoUsuario tipo;
		List <TransferUsuario> lista;
		TransferUsuario usAux;
		ResultSet rs;
		Statement st;
		
			//Inicializacion
			lista = new ArrayList<TransferUsuario>();
			
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		//Cogemos los usuarios existentes.
		if (filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM usuarios"); 
		else 
			rs = (ResultSet) st.executeQuery("SELECT * FROM usuarios WHERE " +filtroBusqueda+ "='" +busqueda+ "'"); 
		
		while (rs.next()){
			if(rs.getString("Admin").equals("CLIENTE")) {
				tipo = TipoUsuario.CLIENTE;
				usAux = new TransferUsuario(rs.getInt("DNI"), rs.getString("Pass"), rs.getString("Nombre"),
						rs.getString("Direccion"), tipo, rs.getInt("ID"));
				lista.add(usAux);
			}
			
		}
		rs.close();
		
		//Apago conexion con la BBDD
		st.close();
		conexion.close();
		return lista;
	}

}
