package Pistas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.TipoUsuario;
import transfer.TransferPista;
import transfer.TipoDeporte;
import transfer.TransferUsuario;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DAOPistasImp implements DAOPistas{

	/**
	 * @param pista: contiene la pista que se quiere agregar.
	 * @Descripcion Conecta con la BBDD, obtiene el id de la pista y la agrega la pista recibida a la BBDD.
	 */
	public void setPista(TransferPista pista) throws ClassNotFoundException,SQLException {
		//Declaracion.
		int numPista; 
		TipoDeporte nombre; 
		int id; 
		Statement st;
		ResultSet rs;
		
		
			//Inicializacion
			numPista = pista.getNumPista();
			nombre = pista.getTipo();
			id = 0;
			
			
		//Conectarse a la base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		

		rs = (ResultSet) st.executeQuery("SELECT * FROM Pistas"); 
		
		//Busco la  ultima ID de la BBDD
		while (rs.next())
		  id = rs.getInt("ID");
		id++;
		
		st.executeUpdate("INSERT INTO Pistas (ID, Tipo, Numero_pista) VALUES ('"+id+"','"+nombre+"','"+numPista+"')");

		//Cierro la conexion con la BBDD.
		rs.close();
		st.close();
		conexion.close();	
		
	}

	/**
	 * @param pista: contiene la pista que se quiere eliminar.
	 * @Descripcion Conecta con la BBDD, y elimina de la BBDD la pista recibida.
	 */
	public void deletePista(TransferPista pista) throws ClassNotFoundException,SQLException {
		//Declaracion
		Statement st;
		ResultSet rs;
		int numPista;
		
		
			//Inicializacion
			numPista = pista.getNumPista();
		
			
		//Conectarse a la base de datos
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		//Busco la pista que tenga el mismo nombre y numPista seleccionado por el admin
		rs = (ResultSet) st.executeQuery("SELECT ID FROM Pistas WHERE Numero_pista='"+numPista+"'");
		rs.next();
		int id = rs.getInt("ID");
				
		//Borro la pista de la BBDD
		st.executeUpdate("DELETE FROM pistas WHERE ID="+id);
		rs.close();
		
		//Actualizo los numeros de pista de las pistas que hay en la BBDD.
		rs = (ResultSet) st.executeQuery("SELECT * FROM pistas WHERE Numero_pista>'" +numPista+ "'");
		
		while(rs.next()) {
			st.executeUpdate("UPDATE pistas SET Numero_pista='"+numPista+"'WHERE ID=" +rs.getInt("ID"));
			numPista++;
			rs = (ResultSet) st.executeQuery("SELECT * FROM pistas WHERE Numero_pista>'" +numPista+ "'");
		}
		
		//Apagar base de datos
		st.close();
		conexion.close();	
	}


	/**
	 * @param filtroBusqueda: contiene el filtro de la busqueda elegido (En el inicio es "*")
	 * @param busqueda: contiene el texto introducido a buscar (En el inicio es vacio "").
	 * @return Devuelve la lista obtenida segun el filtro y la busqueda recibidas por parametros.
	 */
	public List<TransferPista> getListaPistas(String filtroBusqueda,
			String busqueda) throws ClassNotFoundException, SQLException {
		//Declaracion.
		TipoDeporte tipo;
		List <TransferPista> lista;
		String tipoPista;
		TransferPista pistaAux;
		Statement st;
		ResultSet rs;
		
		
			//Inicializacion
			tipo = TipoDeporte.FUTBOL;
			lista = new ArrayList<TransferPista>();
		
		
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
		
		//Cogemos los usuarios existentes.
		if (filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM pistas"); 
		else 
			rs = (ResultSet) st.executeQuery("SELECT * FROM pistas WHERE " +filtroBusqueda+ "='" +busqueda+ "'"); 
		
		while (rs.next()){
			tipoPista = rs.getString("Tipo");
			tipo = tipo.String2Deporte(tipoPista);
			pistaAux = new TransferPista(rs.getInt("Numero_pista"), tipo, rs.getInt("ID"));
			lista.add(pistaAux);
		}

		
		//Apago conexion con la BBDD
		rs.close();
		st.close();
		conexion.close();
		return lista;
	}

}
