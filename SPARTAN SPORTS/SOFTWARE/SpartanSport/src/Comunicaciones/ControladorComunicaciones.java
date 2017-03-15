package Comunicaciones;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferMensaje;
import transfer.TransferPista;
import Pistas.FachadaPistas;
import Pistas.FachadaPistasImp;

public class ControladorComunicaciones {
	
	private FachadaComunicaciones fachada;
	
	/**
	 * @Descripcion Controlador de la clase, asigna FachadaComunicaciones.
	 */
	public ControladorComunicaciones(){
		this.fachada = new FachadaComunicacionesImp();
	}
	
	/**
	 * 
	 * @param mensaje: contiene el mensaje que se quiere enviar.
	 * @Descripcion Llama a la fachada para que envie el mensaje recibido..
	 */
	public void enviarMensaje(TransferMensaje mensaje) {
		this.fachada.enviarMensaje(mensaje);
	}
	
	/**
	 * @param idReceptor: contiene el id del usuario que quiere consultar la lista de mensajes
	 * recibidos.
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto que se desea buscar (En el inicio es vacio "")
	 * @return devuelve la lista de mensajes obtenida segun idReceptor, filtro y busqueda recibidos.
	 * @Descripcion Llama a la fachada para que obtenga la lista de abonos segun el filtro y busqueda obtenidos;
	 * por ultimo devuelve la lista obtenida.
	 */
	public List<TransferMensaje> consultarListaMensajesRecibidos(int idReceptor, TipoOrdenacion filtro, String busqueda) {
		return this.fachada.consultarListaMensajesRecibidos(idReceptor, filtro, busqueda);
	}
	
	/**
	 * @param idEmisor: contiene el id del usuario que quiere consultar la lista de mensajes
	 * recibidos.
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto que se desea buscar (En el inicio es vacio "")
	 * @return devuelve la lista de mensajes obtenida segun idEmisor, filtro y busqueda recibidos.
	 * @Descripcion Llama a la fachada para que obtenga la lista de abonos segun el filtro y busqueda obtenidos;
	 * por ultimo devuelve la lista obtenida.
	 */	
	public List<TransferMensaje> consultarListaMensajesEnviados(int idEmisor, TipoOrdenacion filtro, String busqueda) {
		return this.fachada.consultarListaMensajesEnviados(idEmisor, filtro, busqueda);
	}
	
	/**
	 * 
	 * @param filtro: contiene el filtro de ordenacion elegido.
	 * @param lista: contiene la lista que se desea ordenar.
	 * @return devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Llama a la fachada para que ordene la lista de mensajes recibida segun el filtro de ordenacion;
	 * por ultimo devuelve la lista.
	 */
	public List<TransferMensaje> ordenarListaMensajes(TipoOrdenacion filtro, List <TransferMensaje> lista) {
		return this.fachada.ordernarListaMensajes(filtro, lista);
	}
}
