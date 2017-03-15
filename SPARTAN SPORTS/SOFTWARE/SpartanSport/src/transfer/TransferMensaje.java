package transfer;

import java.util.Date;

public class TransferMensaje {
	private int emisor; 
	private int receptor; 
	private String asunto;
	private String contenido;
	private Date fecha;
	private int idMensaje;
	private int idEmisor;
	private int idReceptor;
	
	public TransferMensaje(int emisor, int receptor, String asunto, String contenido, Date fecha, int idMensaje, int idEmisor, int idReceptor) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.asunto = asunto;
		this.contenido = contenido;
		this.fecha = fecha;
		this.idMensaje = idMensaje;
		this.idEmisor = idEmisor;
		this.idReceptor = idReceptor;
	}
	
	public TransferMensaje(int emisor, int receptor, String asunto, String contenido, Date fecha, int idEmisor, int idReceptor) {
		this.emisor = emisor;
		this.receptor = receptor;
		this.asunto = asunto;
		this.contenido = contenido;
		this.fecha = fecha;
		this.idEmisor = idEmisor;
		this.idReceptor = idReceptor;
	}
	
	/* Getter and Setter */
	public int getEmisor() {
		return emisor;
	}
	public void setEmisor(int emisor) {
		this.emisor = emisor;
	}
	public int getReceptor() {
		return receptor;
	}
	public void setReceptor(int receptor) {
		this.receptor = receptor;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(int idMensaje) {
		this.idMensaje = idMensaje;
	}
	public int getIdReceptor() {
		return idReceptor;
	}
	public void setIdReceptor(int idReceptor) {
		this.idReceptor = idReceptor;
	}
	public int getIdEmisor() {
		return idEmisor;
	}
	public void setIdEmisor(int idEmisor) {
		this.idEmisor = idEmisor;
	}

}
