package Comunicaciones;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferMensaje;
import transfer.TransferPista;

public interface FachadaComunicaciones {
	public List<TransferMensaje> consultarListaMensajesEnviados(int idEmisor, TipoOrdenacion filtro,String busqueda);
	public List<TransferMensaje> consultarListaMensajesRecibidos(int idReceptor, TipoOrdenacion filtro,String busqueda);
	public void enviarMensaje(TransferMensaje mensaje);
	public List<TransferMensaje> ordernarListaMensajes(TipoOrdenacion filtro, List<TransferMensaje> mensaje);
}
