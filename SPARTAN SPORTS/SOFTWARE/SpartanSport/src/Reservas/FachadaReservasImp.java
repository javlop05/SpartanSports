package Reservas;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferReserva;

public class FachadaReservasImp implements FachadaReservas{

	private SAReservas servicio;
	
	/**
	 * @Descripcion Es el constructor de la clase, asigna el SAReservas.
	 */
	public FachadaReservasImp () {
		this.servicio = new SAReservasImp();
	}
	
	/**
	 * @param reserva: contiene la reserva a realizar
	 * @return Devuelve un booleano, true si se ha conseguido hacer la reserva,
	 * false en el caso contrario.
	 * @Descripcion Llama al servicio de aplicacion para que intente hacer la reserva
	 * recibida, devuelve true si lo consigue, false en caso contrario.
	 */
	public boolean hacerReserva(TransferReserva reserva) {
		return this.servicio.hacerReserva(reserva);
	}

	/**
	 * @param filtro: recibe el filtro de ordenacion.
	 * @param lista: contiene la lista a ser ordenada.
	 * @return devuelve la lista ya ordenada.
	 * @Descripcion Llama al servicio de aplicacion para que ordene la lista recibida
	 * por el filtro de ordenacion recibido.
	 */
	public List<TransferReserva> ordenarListaReservas(TipoOrdenacion filtro, List <TransferReserva> lista) {
		return this.servicio.ordenarListaReservas(filtro, lista);
	}

	/**
	 * @param id: Numero del usuario que consulta la lista 
	 * @param filtroBusqueda: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: recibe el texto introducido que se desea buscar (en el inicio sera vacio
	 * "").
	 * @Descripcion Llama al servicio de aplicacion para que obtenga la lista segun el filtroBusqueda y busqueda recibidos.
	 */
	public List <TransferReserva> consultarListaReservas(int id,TipoOrdenacion filtroBusqueda, String busqueda) {
		return this.servicio.consultarListaReservas(id, filtroBusqueda, busqueda);
	}

	/**
	 * @param reserva: contiene la reserva a cancelar
	 * @Descripcion Llama al servicio de aplicacion para que elimine la reserva recibida.
	 */
	public void cancelarReserva(TransferReserva reserva) {
		this.servicio.cancelarReserva(reserva);
		
	}

}
