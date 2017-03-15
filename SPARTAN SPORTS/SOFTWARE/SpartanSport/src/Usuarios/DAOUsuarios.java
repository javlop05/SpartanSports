package Usuarios;

import java.sql.SQLException;
import java.util.List;

import transfer.TransferUsuario;

public interface DAOUsuarios {
	public void setUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException;
	public void deleteUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException;
	public boolean getUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException;
	public boolean comprobarUsuario(TransferUsuario usuario)  throws ClassNotFoundException, SQLException;
	public void modificarUsuario(TransferUsuario usuario) throws ClassNotFoundException, SQLException;
	public List<TransferUsuario> getListaUsuarios(String filtroBusqueda, String busqueda) throws ClassNotFoundException, SQLException;
}
