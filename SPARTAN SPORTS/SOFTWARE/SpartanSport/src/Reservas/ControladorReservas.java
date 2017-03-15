package Reservas;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferReserva;

public class ControladorReservas {

	private FachadaReservas fachada;
	
	/**
	 * @Descripcion Constructor de la clase, asigna el atributo fachadaReservas.
	 */
	public ControladorReservas() {
		this.fachada = new FachadaReservasImp();
	}
	
	/**
	 * @param id: recibe el id de usuario de la BBDD
	 * @param filtroBusqueda: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return devuelve la lista obtenida segun el id, filtroBusqueda y busqueda.
	 * @Descripcion llama a la fachada para que consulte la lista de reservas segun los 
	 * parametros recibidos.
	 */
	public List<TransferReserva> consultarListaReservas(int id, TipoOrdenacion filtroBusqueda, String busqueda) {
		return this.fachada.consultarListaReservas(id, filtroBusqueda, busqueda);
	}
	
	/**
	 * @param contiene el filtro de ordenacion elegido.
	 * @param lista: contiene la lista a ordenar.
	 * @return Devuelve la lista ordenada segun el filtro.
	 * @Descripcion Llama a la fachada para ordenar la lista recibida segun
	 * el filtro de ordenacion recibido.
	 */
	public List<TransferReserva> ordenarListaReservas(TipoOrdenacion filtro, List <TransferReserva> lista){
		return this.fachada.ordenarListaReservas(filtro, lista);
		
	}
	
	/**
	 * @param reservaElegida: Reserva que se quiere realizar
	 * @return devuelve un booleano que indica si se ha hecho o no la reserva
	 * @Descripcion llama a la fachada para hacer una reseva.
	 */
	public boolean hacerReserva(TransferReserva reservaElegida) {
		return this.fachada.hacerReserva(reservaElegida);
	}

	/**
	 * @param reserva: Reserva que se quiere eliminar.
	 * @Descripcion llama a la fachada para eliminar la reserva recibida.
	 */
	public void cancelarReserva(TransferReserva reserva) {
		this.fachada.cancelarReserva(reserva);
	}

}
