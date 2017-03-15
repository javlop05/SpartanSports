package Pistas;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferPista;

public class ControladorPistas {
	
	private FachadaPistas fachada;
	
	/**
	 * @Descripcion Controlador de la clase, asigna la FachadaPistas;
	 */
	public ControladorPistas(){
		this.fachada = new FachadaPistasImp();
	}
	
	/**
	 * 
	 * @param pista: contiene la pista que se desea agregar.
	 * @Descripcion Llama a la fachada para que agregue la pista recibida.
	 */
	public void agregarPista(TransferPista pista) {
		this.fachada.agregarPista(pista);
	}
	
	/**
	 * 
	 * @param pista: contiene la pista que se desea eliminar.
	 * @Descripcion Llama a la fachada para que elimine la pist recibida.
	 */
	public void eliminarPista(TransferPista pista) {
		this.fachada.eliminarPista(pista);
	}
	
	/**
	 * 
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y busqueda recibidos.
	 * @Descripcion Llama a la fachada para que obtenga la lista de pistas segun el filtro y busqueda;
	 * por último devuelve la lista obtenida.
	 */
	public List<TransferPista> consultarListaPistas(TipoOrdenacion filtro, String busqueda) {
		return this.fachada.consultarListaPistas(filtro, busqueda);
	}

	/**
	 * 
	 * @param filtro: contiene el filtro de ordenacion elegido.
	 * @param lista: contiene la lista a ordenar.
	 * @return Devuelve la lista ordenada segun el filtro recibido.
	 * @Descripcion Llama a la fachada para que ordene la lista de pistas recibida, segun el
	 * criterio de ordenacion recibido.
	 */
	public List<TransferPista> ordenarListaPistas(TipoOrdenacion filtro, List <TransferPista> lista) {
		return this.fachada.ordernarListaPistas(filtro, lista);
	}
}
