package Abonos;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.TransferAbono;
import transfer.TipoOrdenacion;

public class SAAbonosImp implements SAAbonos{
	
	private DAOAbonos daoAbonos;
	
	/**
	 * @Descripcion: Constructor de la clase, asigna el DAOAbonos;
	 */
	public SAAbonosImp() {
		daoAbonos = new DAOAbonosImp();
	}

	/**
	 * @param abono: contiene el abono que se desea comprar.
	 * @return Devuelve un booleano, true si el abono no existia y se ha comprado,
	 * false si existía.
	 * @Descripcion En primer lugar llama al dao para comprobar si hay un abono activo, si no hay uno activo
	 * llama a la funcion setAbono del dao para agregarlo a la BBDD; devuelve true si el abono se ha podidio agregar.
	 */
	public boolean comprarAbono(TransferAbono abono) {
		//Declaracion
		boolean correcto;
		
		
			//Inicializacion.
			correcto = false;
			
		
		try {
			
			correcto = this.daoAbonos.comprobarAbono(abono);
			if(correcto) daoAbonos.setAbono(abono);
			
		} catch (ClassNotFoundException e) {
		} catch (SQLException e) {	
		}
		
		return correcto;
	}

	/**
	 * @param filtro: contiene el filtro de busqueda elegido (En el inicio es TipoOrdenacion.VACIO)
	 * @param busqueda: contiene el texto a buscar (En el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y la busqueda recibidas.
	 * @Descripcion En primer lugar transforma el filtro recibido en un string, a continuacion llama
	 * a getAbonos del dao (obtiene la lista de la BBDD), ordena la lista por el abono; 
	 * por ultimo devuelve la lista.
	 */
	public List <TransferAbono> consultarListaAbonos(TipoOrdenacion filtro, String busqueda) {
		//Declaracion
		String filBusqueda;
		List <TransferAbono> listaAbono;
		
		
			//Inicializacion
			listaAbono = new ArrayList <TransferAbono >();
			filBusqueda = filtrarAbono(filtro);
		
		
		try {
			
			listaAbono = daoAbonos.getListaAbonos(filBusqueda, busqueda);
			listaAbono = ordenarAbonos(TipoOrdenacion.NOMBRE_ABONO, listaAbono);
			
		} catch (ClassNotFoundException | SQLException e) {}
		
		return listaAbono;
	}
	
	private String filtrarAbono(TipoOrdenacion filtro) {
		//Declaracion
		String busqueda;
		
		switch(filtro) {

			case FECHA: busqueda = "Fecha_fin"; break;
			
			case NOMBRE_ABONO: busqueda = "Nombre"; break;
			
			case ID: busqueda = "ID"; break;
			
			case DNI: busqueda = "DniUsuario"; break;
			
			default: busqueda = "*";
		}
		
		return busqueda;
	}

	/**
	 * @param filtro: recibe el filtro de ordenacion elegido.
	 * @param lista: recibe la lista a ordenar.
	 * @return Devuelve la lista ordenada segun el filtro de ordenacion recibido.
	 * @Descripcion Elige segun el filtro de ordenacion recibido a la funcion privada de ordenacion a la que llamar,
	 * ordena la lista y la devuelve.
	 */
	public List <TransferAbono> ordenarAbonos(TipoOrdenacion filtro, List <TransferAbono> lista) {
		
		switch(filtro) {

			case FECHA: lista = ordenarPorFecha(lista); break;
		
			case NOMBRE_ABONO: lista = ordenarPorNombre(lista); break;
			
			case DNI: lista = ordenarPorDni(lista); break;
		}
		
		return lista;
	}
	
	private List <TransferAbono> ordenarPorFecha(List <TransferAbono> lista) {
		//Declaracion.
		boolean inter;
		int i;
		
		
			//Inicializacion.
			inter = true;
			i = 0;
		
			
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				lista.get(j).getFechaFinal().before(lista.get(j-1).getFechaFinal()); 
				if(lista.get(j).getFechaFinal().before(lista.get(j-1).getFechaFinal())){
					TransferAbono tmp;
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

	private List <TransferAbono> ordenarPorNombre(List <TransferAbono> lista) {
		//Declaracion.
		boolean inter;
		int i;
		
		
			//Inicializacion.
			inter = true;
			i = 0;
		
			
		while ((i < lista.size()-1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getNombre().compareTo(lista.get(j-1).getNombre()) < 0) {
					TransferAbono tmp;
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
	
	private List <TransferAbono> ordenarPorDni(List <TransferAbono> lista) {
		//Declaracion.
		boolean inter;
		int i;
		
		
			//Inicializacion.
			inter = true;
			i = 0;
		
			
		while ((i < lista.size() - 1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getDniUsuario() < lista.get(j-1).getDniUsuario()) {
					TransferAbono tmp;
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
