package Comunicaciones;

import java.sql.SQLException;
import java.util.List;

import transfer.TransferMensaje;
import transfer.TransferPista;

public interface DAOComunicaciones {
	public void setMensaje(TransferMensaje mensaje) throws ClassNotFoundException, SQLException;
	public List<TransferMensaje> getListaMensajesEnviados(int idEmisor, String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException;
	public List<TransferMensaje> getListaMensajesRecibidos(int idReceptor, String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException;
}
