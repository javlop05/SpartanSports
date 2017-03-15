package Pistas;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferPista;
import transfer.TransferUsuario;

public interface FachadaPistas {
	public List<TransferPista> consultarListaPistas(TipoOrdenacion filtro, String busqueda);
	public void eliminarPista(TransferPista pista);
	public void agregarPista(TransferPista pista);
	public List<TransferPista> ordernarListaPistas(TipoOrdenacion filtro, List<TransferPista> lista);
}
