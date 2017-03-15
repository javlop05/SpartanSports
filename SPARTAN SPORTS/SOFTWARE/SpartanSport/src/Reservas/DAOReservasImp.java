package Reservas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import transfer.TipoDeporte;
import transfer.TransferAbono;
import transfer.TransferReserva;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class DAOReservasImp implements DAOReservas{

	/**
	 * @param id: contiene el id del usuario que va a consultar la lista de reservas,
	 * si el id es 0 es el admin, por lo que se le mostrarían todas las reservas, en el caso
	 * contrario se le mostrarian solo las reservas activas del usuario (al cual pertenece el id).
	 * @param filtroBusqueda: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y la busqueda recibidos.
	 * @Descripcion Conecta con la BBDD comprueba si el usuario es un Admin, si es Admin 
	 * cogera la lista de todas las reservas (segun filtroBusqueda y busqueda);
	 * si es cliente cogera tan solo las reservas de dicho cliente(activas);
	 * por ultimo devuelve la lista obtenida.
	 */
	public List <TransferReserva> getListaReservas(int id,String filtroBusqueda, String busqueda)throws ClassNotFoundException,SQLException {
		//Declaracion.
		int idReserva, idPista, idUsuario, dniUsuario, numPista;
		String hora;
		Date fecha;
		TipoDeporte deporte;
		List <TransferReserva> lista;
		ResultSet rs;
		Statement st;
		
		
			//Inicializacion
			deporte = TipoDeporte.FUTBOL;
			lista = new ArrayList<TransferReserva>();
			
			
	//Enciendo conexion con la BBDD
	Class.forName("com.mysql.jdbc.Driver");
	Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
	st = (Statement) conexion.createStatement();
	
	if(id != 0){
		if (filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM reservas WHERE ID_usuario='"+id+"'"); 
		else
			rs = (ResultSet) st.executeQuery("SELECT * FROM reservas WHERE ID_usuario='"+id+"'"
					+"and " +filtroBusqueda+ "='" +busqueda+"'");
	}
	else{
		if(filtroBusqueda.equals("*"))
			rs = (ResultSet) st.executeQuery("SELECT * FROM reservas"); 
		else
			rs = (ResultSet) st.executeQuery("SELECT * FROM reservas WHERE "+filtroBusqueda+ "='" +busqueda+"'");
	}
	
		while (rs.next()){
			idReserva = rs.getInt("ID");
			idPista = rs.getInt("ID_pista");
			idUsuario = rs.getInt("ID_usuario");
			dniUsuario = rs.getInt("DniUsuario");
			numPista = rs.getInt("NumeroPista");
			fecha = rs.getDate("Fecha");
			hora = rs.getString("Hora");
			String tipoPista = rs.getString("Deporte");
			deporte = deporte.String2Deporte(tipoPista);
			TransferReserva reserva = new TransferReserva(idReserva,idPista,idUsuario
					,fecha, hora, dniUsuario, numPista, deporte);
			if(comprobarReservaActiva(reserva))
				lista.add(reserva);
		}
	
	//Apago conexion con la BBDD
	rs.close();
	st.close();
	conexion.close();
	return lista;
	}

	/**
	 * @param reserva: contiene la reserva que se quiere agregar.
	 * @return Devuelve un booleano, si la reserva es posible devuelve true,
	 * si no es posible devuelve false.
	 * @Descripcion 
	 */
	public void setReserva(TransferReserva reserva) throws ClassNotFoundException,SQLException {
		//Declaracion
		int id_pista, id_user, iden, dniUsuario, numPista;
		TipoDeporte deporte;
		String hora;
		String fechaCorrecta;
		Statement st;
		ResultSet rs;
		
		
			//Inicializacion
			fechaCorrecta = dateToString(reserva.getFecha());
			id_pista = reserva.getIdPista();
			id_user = reserva.getIdUsuario();
			iden = -1;
			dniUsuario = reserva.getDniUsuario();
			numPista = reserva.getNumPista();
			deporte = reserva.getDeporte();
			hora = reserva.getHora();
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
				
		rs = (ResultSet) st.executeQuery("SELECT * FROM reservas"); 
		while (rs.next())
		iden = rs.getInt("ID");
		iden++;
		st.executeUpdate("INSERT INTO reservas (ID, ID_pista, ID_usuario, Fecha, Hora, DniUsuario, NumeroPista, Deporte) VALUES "
		    + "('"+iden+"','"+id_pista+"','"+id_user+"','"+fechaCorrecta+"','"+hora+"','"+dniUsuario+"','"+numPista+"','"+deporte+"' )");

		//Apago conexion con la BBDD
		rs.close();
		st.close();
		conexion.close();
		
	}
	
	/**
	 * @param reserva: contiene la reserva a comprobar.
	 * @return Devuelve un booleano, que es true cuando no existe ninguna reserva
	 * en la BBDD con los datos de la reserva a comprobar, y false en caso contrario.
	 * @Descripcion Conecta con la BBDD, comprueba si la reserva recibida existe ya en
	 * la BBDD, si no existe devuelve true, si existe devuelve false. (La reserva no estaría disponible)
	 */
	public boolean comprobarReserva(TransferReserva reserva) throws ClassNotFoundException, SQLException {
		//Declaracion
		boolean correcto;
		int id_pista, iden;
		String hora;
		String fechaCorrecta;
		Statement st;
		ResultSet rs;
		
		
			//Inicializacion
			correcto = false;
			fechaCorrecta = dateToString(reserva.getFecha());
			id_pista = reserva.getIdPista();
			iden = -1;
			hora = reserva.getHora();
		
			
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
						
		//Busco en la base de datos si existe una reserva con los datos introducidos
		rs = (ResultSet) st.executeQuery("SELECT ID FROM reservas WHERE (ID_pista='"+id_pista+"')"+
		"and (Fecha='" +fechaCorrecta+"')" + "and (Hora='"+hora+"')");
		//and (ID_usuario='"+id_user+"')
		rs.next();
				
		try{
			iden = rs.getInt("ID");
		}catch(Exception e){
			rs.close();
		}
				
		if(iden == -1) correcto = true;
		
		return correcto;
	}

	private boolean comprobarReservaActiva(TransferReserva reserva) throws ClassNotFoundException, SQLException{
		//Declaracion
		boolean correcto;
		java.util.Date fecha;
		Statement st;
		
		
			//Inicializacion
			fecha = new java.util.Date();
			correcto = true;
		
		
		//Encendiendo conexion BBDD...
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
				
			if(reserva.getFecha().before(fecha)){
				deleteReserva(reserva);
				correcto = false;
			}

		//Cerramos la conexion con la BBDD...
		st.close();
		conexion.close();
		return correcto;
		
	}
	
	/**
	 * @param reserva: contiene la reserva a eliminar
	 * @Descripcion Conecta con la BBDD, y elimina la reserva recibida.
	 */
	public void deleteReserva(TransferReserva reserva) throws ClassNotFoundException,SQLException {
		//Declaracion
		Statement st;
		int id;
		
		
			//Inicializacion
			id = reserva.getId();
		
		
		//Enciendo conexion con la BBDD
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/spartansport", "root", "root"); 
		st = (Statement) conexion.createStatement();
			
		st.executeUpdate("DELETE FROM reservas WHERE ID="+id);
				
		//Apago conexion con la BBDD
		st.close();
		conexion.close();
	}

	//Transforma un tipo date de eclipse a tipo date de mysql para poder guardarlo en la bbdd
	private static String dateToString(Date fecha){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(fecha);
	}
}
