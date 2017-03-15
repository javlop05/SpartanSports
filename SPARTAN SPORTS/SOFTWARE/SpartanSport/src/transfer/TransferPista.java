package transfer;

import Pistas.*;


public class TransferPista {
	private TipoDeporte tipo;
	private int idPista;
	private int numPista;

	public TransferPista(int numPista, TipoDeporte tipoPista) {
		this.numPista = numPista;
		this.tipo = tipoPista;
	}
	
	public TransferPista(int numPista, TipoDeporte tipoPista, int idPista) {
		this.numPista = numPista;
		this.tipo = tipoPista;
		this.idPista = idPista;
	}

	/*Getter and Setter*/
	public TipoDeporte getTipo(){
		return tipo;
	}
	
	public void setTipo(TipoDeporte tipo){
		this.tipo = tipo;
	}
	
	public int getIdPista(){
		return idPista;
	}
	
	public void setIdPista(int idPista){
		this.idPista = idPista;
	}
	
	public int getNumPista(){
		return numPista;
	}
	
	public void setNumPista(int numPista){
		this.numPista = numPista;
	}
}
