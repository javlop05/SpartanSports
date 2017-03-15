package Abonos;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import transfer.TransferAbono;

public interface DAOAbonos {
	public List <TransferAbono> getListaAbonos(String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException;
	public void setAbono(TransferAbono abono) throws ClassNotFoundException, SQLException;
	public boolean comprobarAbono(TransferAbono abono) throws ClassNotFoundException, SQLException;
}
