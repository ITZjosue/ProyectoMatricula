package entidades;

import java.time.LocalDateTime;

public class Retiro {
	private int numRetiro, numMatricula;
	private String fecha, hora;
	private static int cantRetiro;
	
	static {
		cantRetiro = 0;
	}
	
	public Retiro(int numMatricula) {
		cantRetiro++;
		LocalDateTime today = java.time.LocalDateTime.now();
		this.numRetiro = 200000 + cantRetiro;
		this.numMatricula = numMatricula;
		this.fecha = today.getDayOfMonth()+"/"+today.getMonthValue()+"/"+today.getYear();
		this.hora = today.getHour()+":"+today.getMinute()+":"+today.getSecond();
	}

	public int getNumRetiro() {
		return numRetiro;
	}

	public void setNumRetiro(int numRetiro) {
		this.numRetiro = numRetiro;
	}

	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	
}
