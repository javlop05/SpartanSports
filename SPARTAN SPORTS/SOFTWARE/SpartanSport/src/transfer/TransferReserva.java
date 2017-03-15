package transfer;

import java.util.Date;

public class TransferReserva {
	private int id;
	private int idPista;
	private int idUsuario;
	private int numPista;
	private int dniUsuario;
	private Date fecha;
	private String hora;
	private TipoDeporte deporte;
	
	
	public TransferReserva(int idReserva, int idPista, int idUsuario,
			Date fecha,String hora, int dniUsuario, int numPista, TipoDeporte deporte) {
		this.id = idReserva;
		this.idPista = idPista;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.hora = hora;
		this.dniUsuario = dniUsuario;
		this.numPista = numPista;
		this.deporte = deporte;
		
	}

	public TransferReserva(int idPista, int idUsuario,
			Date fecha,String hora, int dniUsuario, int numPista, TipoDeporte deporte) {
		this.idPista = idPista;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.hora = hora;
		this.dniUsuario = dniUsuario;
		this.numPista = numPista;
		this.deporte = deporte;
		
	}
	
	/*Getter and Setter*/
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getIdPista(){
		return idPista;
	}
	
	public void setIdPista(int idPista){
		this.idPista = idPista;
	}
	
	public int getIdUsuario(){
		return idUsuario;
	}
	
	public void setIdUsuario(int idUsuario){
		this.idUsuario = idUsuario;
	}
	
	public Date getFecha(){
		return fecha;
	}
	
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}

	public int getNumPista() {
		return numPista;
	}

	public void setNumPista(int numPista) {
		this.numPista = numPista;
	}

	public TipoDeporte getDeporte() {
		return deporte;
	}

	public void setDeporte(TipoDeporte deporte) {
		this.deporte = deporte;
	}

	public int getDniUsuario() {
		return dniUsuario;
	}

	public void setDniUsuario(int dniUsuario) {
		dniUsuario = dniUsuario;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
