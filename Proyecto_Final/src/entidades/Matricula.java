package entidades;

import java.time.LocalDateTime;

public class Matricula {
	private int numMatricula,codAlumno ,codCurso;
	String fechaMatricula;
	private String horaMatricula;
	private int estado;
	// ESTADOS: 
	// 0 (ACTIVO), 
	// 1 (DESACTIVADO)
	private static int cantMatricula;
	static {
		cantMatricula= 0;
	}
	
	public Matricula(int codAlumno, int codCurso) {
		cantMatricula ++;
		LocalDateTime today = java.time.LocalDateTime.now();
		this.numMatricula = 100000 + cantMatricula;
		this.estado = 0;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fechaMatricula = today.getDayOfMonth()+"/"+today.getMonthValue()+"/"+today.getYear();
		this.horaMatricula = today.getHour()+":"+today.getMinute()+":"+today.getSecond();
	}

	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getEstadoName() {
		if(estado == 0) {
			return "ACTIVO";
		}else {
			return "DESACTIVADO";
		}
	}
	public int getNumMatricula() {
		return numMatricula;
	}

	public void setNumMatricula(int numMatricula) {
		this.numMatricula = numMatricula;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(String fecha) {
		this.fechaMatricula = fecha;
	}

	public String getHoraMatricula() {
		return horaMatricula;
	}

	public void setHoraMatricula(String hora) {
		this.horaMatricula = hora;
	}

	public static int getCantMatricula() {
		return cantMatricula;
	}

	public static void setCantMatricula(int cantMatricula) {
		Matricula.cantMatricula = cantMatricula;
	}

	
}