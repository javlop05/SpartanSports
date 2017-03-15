package Abonos;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferAbono;

public class ControladorAbonos {
	
	private FachadaAbonos fachada;
	
	/**
	 * @Descripcion Controlador de la clase, asigna FachadaAbonos.
	 */
	public ControladorAbonos() {
		fachada = new FachadaAbonosImp();
	}
	
	/**
	 * 
	 * @param abono: contiene el abono que se quiere comprar.
	 * @return Devuelve un booleano, true si se ha podido comprar, false en caso contrario.
	 * @Descripcion Llama a la fachada para que compre el abono recibido; devuelve true si se ha conseguido,
	 * false si no se ha conseguido.
	 */
	public boolean comprarAbono(TransferAbono abono) {
		return fachada.comprarAbono(abono);
	}
	
	/**
	 * 
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto que se desea buscar (En el inicio es vacio "")
	 * @return devuelve la lista de abonos obtenida segun el filtro y busqueda recibidos.
	 * @Descripcion Llama a la fachada para que obtenga la lista de abonos segun el filtro y busqueda obtenidos;
	 * por ultimo devuelve la lista obtenida.
	 */
	public List<TransferAbono> consultarListaAbonos(TipoOrdenacion filtro, String busqueda) {
		return fachada.consultarListaAbonos(filtro, busqueda);
	}
	
	/**
	 * 
	 * @param filtro: contiene el filtro de ordenacion elegido.
	 * @param lista: contiene la lista que se desea ordenar.
	 * @return devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Llama a la fachada para que ordene la lista de abonos recibida segun el filtro de ordenacion;
	 * por ultimo devuelve la lista.
	 */
	public List<TransferAbono> ordenarAbonos(TipoOrdenacion filtro, List<TransferAbono> lista) {
		return fachada.ordenarAbonos(filtro, lista);
	}

}