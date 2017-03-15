package Abonos;

import java.util.List;

import transfer.TransferAbono;
import transfer.TipoOrdenacion;

public class FachadaAbonosImp implements FachadaAbonos{
	
	private SAAbonos servicioAbono;
	
	/**
	 * @Descripcion Controlador de la clase, asigna SAAbonos.
	 */
	public FachadaAbonosImp() {
		servicioAbono = new SAAbonosImp();
	}

	/**
	 * @param abono: contiene el abono a comprar.
	 * @return Devuelve un booleano, true si se ha podido comprar el abono, false en caso contrario.
	 * @Descripcion Llama al servicio de aplicacion para que compre un abono, si ha podido comprarlo devuelve true,
	 * false si no ha podido
	 */
	public boolean comprarAbono(TransferAbono abono) {
		return servicioAbono.comprarAbono(abono);
	}

	/**
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y la busqueda.
	 * @Descripcion Llama al servicio de aplicacion para que obtenga la lista segun el filtro y busqueda recibido,
	 * por ultimo devuelve la lista obtenida.
	 */
	public List<TransferAbono> consultarListaAbonos(TipoOrdenacion filtro, String busqueda) {
		return servicioAbono.consultarListaAbonos(filtro, busqueda);
	}

	/**
	 * @param filtro: contiene el filtro de ordenacion elegido.
	 * @param lista: contiene la lista que se quiere ordenar.
	 * @return Devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Llama al servicio de aplicacion para que ordene la lista recibida segun el filtro de ordenacion
	 * recibido; por ultimo devuelve la lista ordenada.
	 */
	public List<TransferAbono> ordenarAbonos(TipoOrdenacion filtro, List<TransferAbono> lista) {
		return servicioAbono.ordenarAbonos(filtro, lista);
	}

}