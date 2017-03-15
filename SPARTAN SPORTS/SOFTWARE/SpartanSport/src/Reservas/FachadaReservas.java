package Reservas;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferReserva;

public interface FachadaReservas {
	public boolean hacerReserva(TransferReserva reserva);
	public List<TransferReserva> ordenarListaReservas(TipoOrdenacion filtro, List <TransferReserva> lista);
	public List<TransferReserva> consultarListaReservas(int id,TipoOrdenacion filtroBusqueda, String busqueda);
	public void cancelarReserva(TransferReserva reserva);
}
