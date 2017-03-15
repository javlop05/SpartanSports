package Pistas;

import java.sql.SQLException;
import java.util.List;

import transfer.TransferPista;
import transfer.TransferUsuario;

public interface DAOPistas {
	public void setPista(TransferPista pista) throws ClassNotFoundException, SQLException;
	public void deletePista(TransferPista pista) throws ClassNotFoundException, SQLException;
	public List<TransferPista> getListaPistas(String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException;
	
}
