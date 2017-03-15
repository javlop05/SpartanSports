package transfer;

import java.util.Date;


public class TransferAbono {
	private int id;
	private String nombre;
	private int idUsuario;
	private int dniUsuario;
	private Date fechaInicio;
	private Date fechaFinal;
	
	public TransferAbono(int id, int id_usuario, String nombre,
			java.sql.Date fechaInicio, java.sql.Date fechaFin, int dniUsuario) {
		this.id = id;
		this.idUsuario = id_usuario;
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFin;
		this.dniUsuario = dniUsuario;
	}

	/*Getter and Setter*/
	
	public TransferAbono(String nombre, Date fechaInicio, Date fechaFin, int idUsuario, int dniUsuario) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFin;
		this.idUsuario = idUsuario;
		this.dniUsuario = dniUsuario;
	}

	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getIdUsuario(){
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario){
		this.idUsuario = idUsuario;
	}
	
	public Date getFechaInicio(){
		return fechaInicio;
	}
	
	public void setFechaInicio(Date fechaInicio){
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFinal(){
		return fechaFinal;
	}
	
	public void setFechaFinal(Date fechaFinal){
		this.fechaFinal = fechaFinal;
	}

	public int getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(int dniUsuario) {
		this.dniUsuario = dniUsuario;
	}
}