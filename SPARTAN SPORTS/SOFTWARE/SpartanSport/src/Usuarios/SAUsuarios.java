package Usuarios;


import java.util.List;

import transfer.TipoOrdenacion;
import transfer.TipoUsuario;
import transfer.TransferUsuario;

public interface SAUsuarios {
	public List<TransferUsuario> ordenarListaUsuarios(TipoOrdenacion filtro, List<TransferUsuario> lista);
	public void bajaUsuario(TransferUsuario usuario);
	public List<TransferUsuario> consultarListaUsuarios(TipoOrdenacion filtro, String busqueda);
	public boolean altaUsuario(TransferUsuario usuario);
	public void modificarUsuario(TransferUsuario usuario);
	public boolean login(TransferUsuario usuario);
}
