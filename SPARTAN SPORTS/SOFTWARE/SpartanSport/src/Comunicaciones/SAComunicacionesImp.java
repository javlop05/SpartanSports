package Comunicaciones;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Pistas.DAOPistas;
import Pistas.DAOPistasImp;
import transfer.TipoOrdenacion;
import transfer.TransferMensaje;
import transfer.TransferPista;
import transfer.TransferReserva;

public class SAComunicacionesImp implements SAComunicaciones{

	private DAOComunicaciones daoComunicacion;

	/**
	 * @Descripcion Controlador de la clase, asigna el DAOComunicaciones.
	 */
	public SAComunicacionesImp(){
		this.daoComunicacion = new DAOComunicacionesImp();
	}
	
	/**
	 * @param idReceptor: contiene el id del usuario receptor.
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.VACIO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista de mensajes recibidos obtenida segun idReceptor, filtro 
	 * y la busqueda recibidas.
	 * @Descripcion En primer lugar transforma el filtro recibido en un string, a continuacion llama
	 * a getListaMensajesRecibidos del dao (obtiene la lista de la BBDD), ordena la lista por el emisor; 
	 * por ultimo devuelve la lista.
	 */
	public List<TransferMensaje> consultarListaMensajesRecibidos(int idReceptor, TipoOrdenacion filtro,
			String busqueda) {
		//Declaracion.
		List<TransferMensaje> lista;
		String filBusqueda;
		
			//Inicializacion.
			filBusqueda = filtrarLista(filtro);
			lista = new ArrayList <TransferMensaje>();
		
		try {
			
			lista = this.daoComunicacion.getListaMensajesRecibidos(idReceptor, filBusqueda, busqueda);
			lista = this.ordenarListaMensaje(TipoOrdenacion.EMISOR, lista);
			
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
		return lista;
	}

	/**
	 * @param idEmisor: contiene el id del usuario receptor.
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.VACIO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista de mensajes enviados obtenida segun idEmisor, filtro 
	 * y la busqueda recibidas.
	 * @Descripcion En primer lugar transforma el filtro recibido en un string, a continuacion llama
	 * a getListaMensajesEnviados del dao (obtiene la lista de la BBDD), ordena la lista por el receptor; 
	 * por ultimo devuelve la lista.
	 */
	public List<TransferMensaje> consultarListaMensajesEnviados(int idEmisor, TipoOrdenacion filtro,
			String busqueda) {
		//Declaracion.
		List<TransferMensaje> lista;
		String filBusqueda;
		
			//Inicializacion.
			filBusqueda = filtrarLista(filtro);
			lista = new ArrayList <TransferMensaje>();
		
		try {
			
			lista = this.daoComunicacion.getListaMensajesEnviados(idEmisor, filBusqueda, busqueda);
			lista = this.ordenarListaMensaje(TipoOrdenacion.RECEPTOR, lista);
		
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
		return lista;
	}

	private String filtrarLista(TipoOrdenacion filtro) {
		String busqueda;
		switch (filtro) {
		case EMISOR:
			busqueda = "Emisor";
			break;
		case RECEPTOR:
			busqueda = "Receptor";
			break;
		case FECHA:
			busqueda = "Fecha";
			break;
		default:
			busqueda = "*";
			break;
		}
		return busqueda;
	}
	
	/**
	 * @param mensaje: contiene el mensaje a agregar.
	 * @Descripcion Llama al dao para que agregue el mensaje recibido por parametro
	 * a la BBDD.
	 */
	public void enviarMensaje(TransferMensaje mensaje) {
		try {
			daoComunicacion.setMensaje(mensaje);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param filtro: recibe el filtro de ordenacion elegido.
	 * @param lista: recibe la lista a ordenar.
	 * @return Devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Elige segun el filtro de ordenacion recibido a la funcion privada de ordenacion a la que llamar,
	 * ordena la lista y la devuelve.
	 */
	public List<TransferMensaje> ordenarListaMensaje(TipoOrdenacion filtro,
			List<TransferMensaje> lista) {
		switch (filtro) {
		case EMISOR: 
			lista = ordenarPorEmisor(lista);
			break;
		case RECEPTOR:
			lista = ordenarPorReceptor(lista);
			break;
		case FECHA:
			lista = ordenarPorFecha(lista);
			break;
		}
		return lista;
	}

	private List<TransferMensaje> ordenarPorReceptor(List<TransferMensaje> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getReceptor() < lista.get(j-1).getReceptor()) {
					TransferMensaje tmp;
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

	private List<TransferMensaje> ordenarPorEmisor(List<TransferMensaje> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getEmisor() <lista.get(j-1).getEmisor()) {
					TransferMensaje tmp;
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

	private List<TransferMensaje> ordenarPorFecha(List<TransferMensaje> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if(lista.get(j).getFecha().before(lista.get(j-1).getFecha())){
					TransferMensaje tmp;
					tmp = lista.get(j);
					lista.set(j, lista.get(j-1));
					lista.set(j-1, tmp);
					inter = true;
				}
			}
			if (inter) i++;
		}
		
		return lista;
	}
}
