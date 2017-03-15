package transfer;

import Abonos.*;
import Reservas.*;
import Comunicaciones.*;

public class TransferUsuario {

	private int dni;
	private String pass;
	private String nombre;
	private int idUser;
	private String domicilio;
	private TipoUsuario tipoUser;
	
	
	
	//Para el inicio de sesion.
	public TransferUsuario(int dni, String pass) {
		this.dni = dni;
		this.pass = pass;
	}

	//Para crear un usuario nuevo o modificarlo.
	public TransferUsuario(int dni, String pass, String nombre, String domicilio, TipoUsuario tipoUser) {
		this.dni = dni;
		this.pass = pass;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.tipoUser = tipoUser;
	}
	
	//Para guardar un usuario leido de la bbdd. (Normalmente de la lista)
	public TransferUsuario(int dni, String pass, String nombre, String domicilio, TipoUsuario tipoUser, int idUser) {
		this.dni = dni;
		this.pass = pass;
		this.nombre = nombre;
		this.domicilio = domicilio;
		this.tipoUser = tipoUser;
		this.idUser = idUser;
	}
	//Getter and Setter */
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getPass() {
		return pass;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public void setDomicilio(String domicilio){
		this.domicilio = domicilio;
	}
	public String getDomicilio(){
		return domicilio;
	}
	public TipoUsuario getTipoUser() {
		return tipoUser;
	}
	public void setTipoUser(TipoUsuario tipoUser) {
		this.tipoUser = tipoUser;
	}
}
