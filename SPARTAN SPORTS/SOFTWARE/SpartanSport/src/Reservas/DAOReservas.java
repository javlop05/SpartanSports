package Reservas;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import transfer.TransferReserva;


public interface DAOReservas {
	public List<TransferReserva> getListaReservas(int id, String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException;
	public void setReserva(TransferReserva reserva) throws ClassNotFoundException, SQLException;
	public void deleteReserva(TransferReserva reserva) throws ClassNotFoundException, SQLException;
	public boolean comprobarReserva(TransferReserva reserva) throws ClassNotFoundException, SQLException; 
}

