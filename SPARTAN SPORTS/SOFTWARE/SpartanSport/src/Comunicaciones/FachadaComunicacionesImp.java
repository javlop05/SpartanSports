package Comunicaciones;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferMensaje;

public class FachadaComunicacionesImp implements FachadaComunicaciones{

	private SAComunicaciones servicio;
	
	/**
	 * @Descripcion Controlador de la clase, asigna SAComunicaciones.
	 */
	public FachadaComunicacionesImp() {
		this.servicio = new SAComunicacionesImp();
	}
	
	/**
	 * @param idReceptor: contiene el id del usuario que ha consultado la
	 * bandeja de entrada.
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y la busqueda.
	 * @Descripcion Llama al servicio de aplicacion para que obtenga la lista segun idReceptor, filtro y busqueda recibido,
	 * por ultimo devuelve la lista obtenida.
	 */
	public List<TransferMensaje> consultarListaMensajesRecibidos(int idReceptor, TipoOrdenacion filtro,
			String busqueda) {
		return this.servicio.consultarListaMensajesRecibidos(idReceptor, filtro, busqueda);
	}

	/**
	 * @param idEmisor: contiene el id del usuario que ha consultado la
	 * bandeja de entrada.
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y la busqueda.
	 * @Descripcion Llama al servicio de aplicacion para que obtenga la lista segun idEmisor, filtro y busqueda recibido,
	 * por ultimo devuelve la lista obtenida.
	 */
	public List<TransferMensaje> consultarListaMensajesEnviados(int idEmisor, TipoOrdenacion filtro,
			String busqueda) {
		return this.servicio.consultarListaMensajesEnviados(idEmisor, filtro, busqueda);
	}
	
	/**
	 * @param mensaje: contiene el mensaje a enviar.
	 * @Descripcion Llama al servicio de aplicacion para que envie el mensaje recibido.
	 */
	public void enviarMensaje(TransferMensaje mensaje) {
		this.servicio.enviarMensaje(mensaje);	
	}

	/**
	 * @param filtro: contiene el filtro de ordenacion elegido.
	 * @param lista: contiene la lista que se quiere ordenar.
	 * @return Devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Llama al servicio de aplicacion para que ordene la lista recibida segun el filtro de ordenacion
	 * recibido; por ultimo devuelve la lista ordenada.
	 */
	public List<TransferMensaje> ordernarListaMensajes(TipoOrdenacion filtro,
			List<TransferMensaje> lista) {
	
		return this.servicio.ordenarListaMensaje(filtro, lista);
	}


}
