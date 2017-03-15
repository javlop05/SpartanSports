package Reservas;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TransferAbono;
import transfer.TransferPista;
import transfer.TransferReserva;
import transfer.TransferUsuario;

public class SAReservasImp implements SAReservas{

	private DAOReservas daoReserva;
	
	/**
	 * @Descripcion Constructor de la clase, asigna el atributo DAOReservas.
	 */
	public SAReservasImp () {
		this.daoReserva = new DAOReservasImp();
	}
	
	/**
	 * @param reserva: contiene los datos de la reserva a realizar.
	 * @return devuelve un booleano, true si se ha podido hacer la reserva,
	 * false en caso contrario.
	 * @Descripcion Llama al dao para comprobar si existe la reserva, si no existe
	 * se agrega la reserva y devuelve true, si existe se devuelve false.
	 */
	public boolean hacerReserva(TransferReserva reserva) {
		boolean correcto = false;
		try {
			correcto = this.daoReserva.comprobarReserva(reserva);
			if(correcto) this.daoReserva.setReserva(reserva);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return correcto;
	}

	/**
	 * @param filtro: recibe el tipo de orden por el que se quiere ordenar la lista
	 * @param lista: contiene la lista a ser ordenada.
	 * @return devuelve la lista ya ordenada.
	 * @Descripcion elige segun el filtro recibido a cual de las funciones de ordenacion privadas llama; finalmente devuelve
	 * la lista ordenada.
	 */
	public List <TransferReserva> ordenarListaReservas(TipoOrdenacion filtro, List <TransferReserva> lista) {
		switch (filtro) {
		case DNI: 
			lista = ordenarPorDni(lista);
			break;
		case DEPORTE:
			lista = ordenarPorDeporte(lista);
			break;
		case FECHA: 
			lista = ordenarPorFecha(lista);
			break;
		case HORA:
			lista = ordenarPorHora(lista);
			break;
		case PISTA: 
			lista = ordenarPorPista(lista);
		}
		return lista;
		
	}

	private List<TransferReserva> ordenarPorPista(List<TransferReserva> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size() - 1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getNumPista() < lista.get(j-1).getNumPista()) {
					TransferReserva tmp;
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

	private List<TransferReserva> ordenarPorDeporte(List<TransferReserva> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getDeporte().toString().compareTo(lista.get(j-1).getDeporte().toString()) < 0) {
					TransferReserva tmp;
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

	private List<TransferReserva> ordenarPorFecha(List<TransferReserva> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if(lista.get(j).getFecha().before(lista.get(j-1).getFecha())){
					TransferReserva tmp;
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

	private List<TransferReserva> ordenarPorHora(List<TransferReserva> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getHora().compareTo(lista.get(j-1).getHora()) < 0) {
					TransferReserva tmp;
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

	private List<TransferReserva> ordenarPorDni(List<TransferReserva> lista) {
		boolean inter = true;
		int i = 0;
		while ((i < lista.size() - 1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getDniUsuario() < lista.get(j-1).getDniUsuario()) {
					TransferReserva tmp;
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

	/**
	 * @param id: numero del usuario que quiere consultar sus reservas
	 * @param filtroBusqueda: contiene el filtro elegido al realizar una busqueda (en el inicio sera
	 * TipoOrdenacion.NINGUNO)
	 * @param busqueda: recibe el texto introducido que se desea buscar (en el inicio sera vacio
	 * "").
	 * @return Devuelve la lista de reservas.
	 * @Descripcion En primer lugar convierte el filtro recibido en un string, despues llama a la funcion para obtener
	 * la lista de reservas del dao, por ultimo ordena la lista por dni y la devuelve.
	 */
	public List <TransferReserva> consultarListaReservas(int id,TipoOrdenacion filtroBusqueda, String busqueda) {
		List <TransferReserva> lista = new ArrayList<TransferReserva>();
		try {
			String filBusqueda = filtrarLista(filtroBusqueda);
			lista = this.daoReserva.getListaReservas(id,filBusqueda, busqueda);
			lista = ordenarListaReservas(TipoOrdenacion.DNI, lista);
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
		return lista;
	}
	
	private String filtrarLista(TipoOrdenacion filtro) {
		String busqueda;
		switch (filtro) {
		case DNI:
			busqueda = "DniUsuario";
			break;
		case DEPORTE:
			busqueda = "Deporte";
			break;
		case FECHA: 
			busqueda = "Fecha";
			break;
		case HORA:
			busqueda = "Hora";
			break;
		case PISTA: 
			busqueda = "NumeroPista";
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
	 * @param reserva: contiene la reserva a eliminar.
	 * @Descripcion Llama a la funcion del dao deleteReserva para eliminar la reserva.
	 */
	public void cancelarReserva(TransferReserva reserva) {
		try {
			this.daoReserva.deleteReserva(reserva);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
