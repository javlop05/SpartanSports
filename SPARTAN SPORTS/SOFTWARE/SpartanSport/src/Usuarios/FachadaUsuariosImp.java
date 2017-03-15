package Usuarios;

import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferUsuario;

public class FachadaUsuariosImp implements FachadaUsuarios {
	
	private SAUsuarios servicio;

	/**
	 * @Descripcion Es el constructor de la clase, asigna el SAUsuarios.
	 */
	public FachadaUsuariosImp() {
		this.servicio = new SAUsuariosImp();
	}

	/**
	 * @param filtro: contiene el filtro por el que ordenar la lista,
	 * @param lista: contiene la lista a ordenar.
	 * @return Devuelve la lista ordenada.
	 * @Descripcion Llama al servicio de aplicacion para que ordene la lista recibida por parámetro mediante el filtro 
	 * recibido.
	 */
	public List<TransferUsuario> ordenarListaUsuarios(TipoOrdenacion filtro, List<TransferUsuario> lista) {
		return this.servicio.ordenarListaUsuarios(filtro, lista);
	}


	/**
	 * @param usuario: contiene el usuario a dar de baja.
	 * @Descripcion Llama al servicio de aplicacion para que elimine el usuario recibido.
	 */
	public void bajaUsuario(TransferUsuario usuario) {
		this.servicio.bajaUsuario(usuario);
		
	}

	/**
	 * @param filtro: contiene el filtro elegido a la hora de buscar (en el inicio es TipoOrdenacion.NINGUNO)
	 * @param busqueda: es el texto introducido para buscar (en el inicio es vacio "").
	 * @return Devuelve la lista segun el filtro y busqueda recibidos.
	 * @Descripcion Llama al servicio de aplicacion para que obtenga la lista según el filtro y busqueda recibidos.
	 */
	public List <TransferUsuario> consultarListaUsuarios(TipoOrdenacion filtro, String busqueda) {
		return this.servicio.consultarListaUsuarios(filtro, busqueda);
	}

	/**
	 * @param usuario: contiene el usuario a dar de alta.
	 * @return Devuelve un booleano, true si se ha conseguido dar de alta al usuario, false en caso contrario.
	 * @Descripcion Llama al servicio de aplicacion para que de de alta al usuario recibido por parametro.
	 */
	public boolean altaUsuario(TransferUsuario usuario) {
		return this.servicio.altaUsuario(usuario);
		
	}

	/**
	 * @param usuario: contiene el usuario a modificar.
	 * @Descripcion Llama al servicio de aplicacion para que actualice los datos del usuario recibido.
	 */
	public void modificarUsuario(TransferUsuario usuario) {
		this.servicio.modificarUsuario(usuario);
		
	}

	/**
	 * @param usuario: contiene el usuario con el dni y pass introducidos.
	 * @return devuelve un booleano, true si se ha conseguido iniciar sesion, en el caso contrario false.
	 * @Descripcion Llama al servicio de aplicacion para que intente iniciar sesion, si lo consigue devuelve true,
	 * si no lo consigue devuelve false.
	 */
	public boolean login(TransferUsuario usuario) {
		return this.servicio.login(usuario);
	}


}
