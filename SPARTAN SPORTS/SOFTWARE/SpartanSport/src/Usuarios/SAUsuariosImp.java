package Usuarios;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferUsuario;

public class SAUsuariosImp implements SAUsuarios{

	private DAOUsuarios daoUsers;
	
	/**
	 * @Descripcion Constructor de la clase, asigna el atributo daoUsers.
	 */
	public SAUsuariosImp () {
		this.daoUsers = new DAOUsuariosImp();
	}

	/**
	 * @param filtro: recibe el tipo de orden por el que se quiere ordenar la lista
	 * @param lista: contiene la lista a ser ordenada.
	 * @return devuelve la lista ya ordenada.
	 * @Descripcion elige según el filtro recibido a cual de las funciones de ordenación privadas llama; finalmente devuelve
	 * la lista ordenada.
	 */
	public List <TransferUsuario> ordenarListaUsuarios(TipoOrdenacion filtro, List <TransferUsuario> lista) {
		
		switch (filtro) {
		
		case DNI: 
			lista = ordenarPorDni(lista);
			break;
		case NOMBRE:
			lista = ordenarPorNombre(lista);
			break;
			
		}
		
		return lista;
	}

	private List <TransferUsuario> ordenarPorNombre(List <TransferUsuario> lista) {
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
					TransferUsuario tmp;
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
	
	private List <TransferUsuario> ordenarPorDni(List <TransferUsuario> lista) {
		//Declaracion.
		boolean inter;
		int i;
		
		
			//Inicializacion.
			inter = true;
			i = 0;
		
			
		while ((i < lista.size() - 1) && inter) {
			inter = false;
			for (int j = lista.size() - 1; j > i; j--) {
				if (lista.get(j).getDni() < lista.get(j-1).getDni()) {
					TransferUsuario tmp;
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
	 * @param usuario: contiene el usuario a dar de baja.
	 * @Descripcion Llama a la funcion del dao deleteUsuario para dar de baja al usuario recibido.
	 */
	public void bajaUsuario(TransferUsuario usuario) {
		try {
			
			this.daoUsers.deleteUsuario(usuario);
			
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
	}

	/**
	 * @param filtroBusqueda: contiene el filtro elegido al realizar una busqueda (en el inicio sera
	 * TipoOrdenacion.NINGUNO
	 * @param busqueda: recibe el texto introducido que se desea buscar (en el inicio sera vacio
	 * "").
	 * @return Devuelve la lista de Usuarios ordenada por nombre.
	 * @Descripcion En primer lugar convierte el filtro recibido en un string, despúes llama a la funcion para obtener
	 * la lista de Usuarios del dao, por último ordena la lista por nombre y la devuelve.
	 */
	public List <TransferUsuario> consultarListaUsuarios(TipoOrdenacion filtroBusqueda, String busqueda) {
		//Declaracion.
		List <TransferUsuario> lista;
		String filBusqueda;
		
		
			//Inicializacion.
			lista = new ArrayList <TransferUsuario >();
			filBusqueda = filtrarLista(filtroBusqueda);
			
		try {
			
			lista = this.daoUsers.getListaUsuarios(filBusqueda, busqueda);
			lista = this.ordenarListaUsuarios(TipoOrdenacion.NOMBRE, lista);
			
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
		
		return lista;
		
	}

	private String filtrarLista(TipoOrdenacion filtro) {
		//Declaracion.
		String busqueda;
		
		
		switch (filtro) {
		
		case DNI:
			busqueda = "Dni";
			break;
		case NOMBRE:
			busqueda = "Nombre";
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
	 * @param usuario: contiene los datos del usuario a dar de alta.
	 * @return devuelve un booleano, true si se ha podido dar de alta al usuario, false en caso contrario
	 * pues el dni introducido es coincidente con el de otro usuario.
	 * @Descripcion En primer lugar comprueba si el dni del usuario introducido coincide con el de otra persona
	 * registrada en la BBDD, si no existe lo introduce en la BBDD y devuelve true. 
	 */
	public boolean altaUsuario(TransferUsuario usuario) {
		//Declaracion.
		boolean correcto;
		
		
			//Inicializacion
			correcto = false;
		
		
		try {
			
			correcto = this.daoUsers.comprobarUsuario(usuario);
			if(correcto) this.daoUsers.setUsuario(usuario);
			
		} catch (ClassNotFoundException e) {}
		catch (SQLException e){}
		
		return correcto;
		
	}

	/**
	 * @param usuario: contiene los datos del usuario a modificar.
	 * @Descripcion Llama a la funcion del dao para modificar usuario.
	 */
	public void modificarUsuario(TransferUsuario usuario) {
		
		try {
			
			this.daoUsers.modificarUsuario(usuario);
			
		}catch (ClassNotFoundException e){} 
		catch (SQLException e){}
	}

	/**
	 * @param usuario: recibe el usuario con el dni y pass.
	 * @return Devuelve un booleano, true si el usurio (dni y pass) existian en la BBDD, false en caso contrario.
	 * @Descripcion Llama a la funcion getUsuario del dao para ver si existe el usuario introducido, si existe devuelve true.
	 */
	public boolean login(TransferUsuario usuario){
		//Declaracion.
		boolean login;
		
		
			//Inicializacion.
			login = false;
		
		
		try {
			
		login = this.daoUsers.getUsuario(usuario);
		
		}catch (ClassNotFoundException e){} 
		catch (SQLException e){}
		
		return login;
	}

}
