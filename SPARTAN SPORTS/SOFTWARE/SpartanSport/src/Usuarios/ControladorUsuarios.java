package Usuarios;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferUsuario;

public class ControladorUsuarios {
	
	private FachadaUsuarios fachada;
	
	/**
	 * @Descripcion: Constructor de la clase, asigna la FachadaUsuarios.
	 */
	public ControladorUsuarios() {
		this.fachada = new FachadaUsuariosImp();
	}
	
	/**
	 * @param user: contiene el usuario (dni y pass) que quiere iniciar sesion.
	 * @return Devuelve un booleano si se ha podido iniciar sesion , false en caso contrario
	 * @Descripcion Llama a la fachada para iniciar sesion.
	 */
	public boolean login(TransferUsuario user) {
		return fachada.login(user);
	}

	/**
	 * 
	 * @param filtro: contiene el filtro de busqueda elegido (en el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: contiene el texto introducido al buscar (en el inicio es vacio "")
	 * @return Devuelve la lista obtenida segun el filtro y busqueda recibidos.
	 * @Descripcion Llama a la fachada para consultar la lista de usuarios.
	 */
	public List<TransferUsuario> consultarListaUsuarios(TipoOrdenacion filtro, String busqueda) {
		return this.fachada.consultarListaUsuarios(filtro, busqueda);
	}

	/**
	 * 
	 * @param filtro: contiene el TipoOrdenacion elegido.
	 * @param listaUsers: contiene la lista a ordenar.
	 * @return Devuelve la lista ordenada segun el filtro recibido.
	 * @Descripcion Llama a la fachda para ordenar la lista recibida.
	 */
	public List<TransferUsuario> ordenarListaUsuarios(TipoOrdenacion filtro,
			List<TransferUsuario> listaUsers) {
		return this.fachada.ordenarListaUsuarios(filtro, listaUsers);
	}

	/**
	 * 
	 * @param nuevoUsuario: contiene el usuario a dar de alta.
	 * @return Devuelve un booleano, true si se ha conseguido dar de alta el usuario recibido, 
	 * false si no se ha podido.
	 * @Descripcion Llama a la fachada para dar de alta un usuario.
	 */
	public boolean altaUsuario(TransferUsuario nuevoUsuario) {
		return this.fachada.altaUsuario(nuevoUsuario);
	}

	/**
	 * 
	 * @param existente: contiene el usuario a modificar.
	 * @Descripcion Llama a la fachada para modificar el usuario recibido.
	 */
	public void modificarUsuario(TransferUsuario existente) {
		this.fachada.modificarUsuario(existente);
		
	}

	/**
	 * 
	 * @param usuario: contiene el usuario a dar de baja.
	 * @Descripcion Llama a la fachada para que elimine el usuario recibido.
	 */
	public void bajaUsuario(TransferUsuario usuario) {
		this.fachada.bajaUsuario(usuario);
		
	}

}
