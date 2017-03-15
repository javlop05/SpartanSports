package Abonos;

import java.util.List;

import transfer.TransferAbono;
import transfer.TipoOrdenacion;


public interface FachadaAbonos {
	public boolean comprarAbono(TransferAbono abono);
	public List<TransferAbono> consultarListaAbonos(TipoOrdenacion filtro, String busqueda);
	public List<TransferAbono> ordenarAbonos(TipoOrdenacion filtro, List<TransferAbono> lista);
}