package transfer;

public enum TipoDeporte {
	FUTBOL,BALONCESTO,TENIS,PADEL, RUGBY, FUTBOL_AMERICANO, VOLEYBALL, HOCKEY;
	
	public TipoDeporte String2Deporte(String deporte) {
		//Declaracion.
		TipoDeporte tipo;
		
		
			//Inicializacion.
			tipo= TipoDeporte.FUTBOL;
		
		switch (deporte) {
		case "FUTBOL": tipo = TipoDeporte.FUTBOL; break;
		case "PADEL": tipo = TipoDeporte.PADEL; break;
		case "BALONCESTO": tipo = TipoDeporte.BALONCESTO; break;
		case "RUGBY": tipo = TipoDeporte.RUGBY; break;
		case "FUTBOL_AMERICANO": tipo = TipoDeporte.FUTBOL_AMERICANO; break;
		case "VOLEYBALL": tipo = TipoDeporte.VOLEYBALL; break;
		case "TENIS": tipo = TipoDeporte.TENIS; break;
		case "HOCKEY": tipo = TipoDeporte.HOCKEY; break;
		}
		
		return tipo;
	}
}
