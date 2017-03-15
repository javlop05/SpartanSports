package Pistas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Usuarios.DAOUsuarios;
import Usuarios.DAOUsuariosImp;
import transfer.TipoOrdenacion;
import transfer.TransferPista;
import transfer.TransferUsuario;

public class SAPistasImp implements SAPistas{

	private DAOPistas daoPistas;
	
	/**
	 * @Descripcion Constructor de la clase, asigna el DAOPistas;
	 */
	public SAPistasImp()
	{
		this.daoPistas = new DAOPistasImp();
	}
	
	/**
	 * @param filtro: contiene el filtro de busqueda (en el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto a buscar (en el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y busqueda recibidos.
	 * @Descripcion Transforma en string el filtro recibido, llama al dao para obtener la lista de pistas, la ordena por deporte,
	 * por último devuelve la lista.
	 */
	public List<TransferPista> consultarListaPistas(TipoOrdenacion filtro, String busqueda) {
		//Declaracion.
		List<TransferPista> lista;
		String filBusqueda;
		
		
			//Inicializacion
			lista= new ArrayList <TransferPista>();
			filBusqueda = filtrarLista(filtro);
		
		try {
			
			lista = this.daoPistas.getListaPistas(filBusqueda, busqueda);
			lista = this.ordenarListaPistas(TipoOrdenacion.DEPORTE, lista);
			
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
		
		return lista;
	}

	private String filtrarLista(TipoOrdenacion filtro) {
		String busqueda;
		switch (filtro) {
		case PISTA:
			busqueda = "Numero_pista";
			break;
		case DEPORTE:
			busqueda = "Tipo";
			break;
		case ID:
			busqueda = "ID";
			break;
		default:
			busqueda = "*";
			break;
		}
		return busqueda;
	}
	
	/**
	 * @param pista: contiene la pista a eliminar.
	 * @Descripcion Llama al dao para que elimine de la BBDD la pista recibida.
	 */
	public void eliminarPista(TransferPista pista) {

		try {
			this.daoPistas.deletePista(pista);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param pista: contiene la pista que se quiere agregar.
	 * @Descripcion Llama al dao para que agregue la pista recibida.
	 */
	public void agregarPista(TransferPista pista) {
	
		try {
			this.daoPistas.setPista(pista);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param filtro: contiene el tipo de ordenacion seleccionado 
	 * @param lista: contiene la lista a ordenar.
	 * @return Devuelve la lista ordenada segun el filtro recibido. 
	 * @Descripcion elige según el filtro recibido a cual de las funciones de ordenación privadas llama; finalmente devuelve
	 * la lista ordenada.
	 */
	public List<TransferPista> ordenarListaPistas(TipoOrdenacion filtro, List<TransferPista> lista) {
		
		switch (filtro) {
		case PISTA: 
			lista = ordenarPorPista(lista);
			break;
		case DEPORTE:
			lista = ordenarPorDeporte(lista);
			break;
		}
		
		return lista;
	}

	private List<TransferPista> ordenarPorDeporte(List<TransferPista> lista) {
		//Declaracion.
		boolean inter;
		int i;
		
		
			//Inicializacion.
			inter = true;
			i = 0;
			
			
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getTipo().toString().compareTo(lista.get(j-1).getTipo().toString()) < 0) {
					TransferPista tmp;
					tmp = lista.get(j);
					lista.set(j, lista.get(j-1));
					lista.set(j-1, tmp);
					inter = true;
				}
			}
			if (inter) {
				i++;
			}
		}
		return lista;
	}

	private List<TransferPista> ordenarPorPista(List<TransferPista> lista) {
		//Declaracion.
		boolean inter;
		int i;
		
		
			//Inicializacion.
			inter = true;
			i = 0;
			
			
		while ((i < lista.size() - 1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getNumPista() < lista.get(j-1).getNumPista()) {
					TransferPista tmp;
					tmp = lista.get(j);
					lista.set(j, lista.get(j-1));
					lista.set(j-1, tmp);
					inter = true;
				}
			}
			if (inter) {
				i++;
			}
		}
		return lista;
	}

}
