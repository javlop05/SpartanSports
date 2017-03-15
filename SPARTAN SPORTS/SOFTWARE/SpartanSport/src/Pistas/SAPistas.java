package Pistas;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferPista;

public interface SAPistas {
	public List<TransferPista> consultarListaPistas(TipoOrdenacion filtro, String busqueda);
	public void eliminarPista(TransferPista pista);
	public void agregarPista(TransferPista pista);
	public List<TransferPista> ordenarListaPistas(TipoOrdenacion filtro, List<TransferPista> lista);
}
