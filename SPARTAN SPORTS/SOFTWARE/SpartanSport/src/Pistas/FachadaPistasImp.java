package Pistas;

import java.util.List;

import Usuarios.SAUsuariosImp;
import transfer.TipoOrdenacion;
import transfer.TransferPista;
import transfer.TransferUsuario;

public class FachadaPistasImp implements FachadaPistas{

	private SAPistas servicio;
	
	/**
	 * @Descripcion Constructor de la clase, asigna el SAPistas.
	 */
	public FachadaPistasImp()
	{
		this.servicio = new SAPistasImp();
	}
	
	/**
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.NINGUNO).
	 * @param busqueda: contiene el texto a busar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y busqueda recibidos.
	 * @Descripcion Llama al servicio de aplicacion para que obtenga la lista segun el filtro y busqueda recibidos,
	 * devuelve la lista que obtiene.
	 */
	public List<TransferPista> consultarListaPistas(TipoOrdenacion filtro, String busqueda) {
		return this.servicio.consultarListaPistas(filtro, busqueda);
	}

	/**
	 * @param pista: contiene la pista a eliminar.
	 * @Descripcion Llama al servicio de aplicacion para que elimine la pista recibida.
	 */
	public void eliminarPista(TransferPista pista) {
		this.servicio.eliminarPista(pista);
		
	}

	/**
	 * @param pista: contiene la pista que se quiere agregar.
	 * @Descripcion Llama al servicio de aplicacion para que agregue la pista recibida.
	 */
	public void agregarPista(TransferPista pista) {
		this.servicio.agregarPista(pista);
		
	}

	/**
	 * @param filtro: contiene el filtro de ordenacion que se quiere aplicar.
	 * @param lista: contiene la lista que se quiere ordenar
	 * @return Devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Llama al servicio de aplicacion para que ordene la lista recibida segun el filtro
	 * recibido, por último devuelve la lista ordenada.
	 */
	public List<TransferPista> ordernarListaPistas(TipoOrdenacion filtro, List<TransferPista> lista) {
		return this.servicio.ordenarListaPistas(filtro, lista);
	}

}
