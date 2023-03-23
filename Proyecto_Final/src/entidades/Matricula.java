package entidades;
public class Matricula {
	private int numMatricula, codAlumno ,codCurso, estado;
	private String fecha,hora;
	
	private static int cantMatricula;
	static {
		cantMatricula= 0;
	}
	
	public Matricula(int numMatricula, int codAlumno, int codCurso, String fecha, String hora) {
		super();
		this.numMatricula = numMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fecha = fecha;
		this.hora = hora;
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

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;//ssss
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public static int getCantMatricula() {
		return cantMatricula;
	}

	public static void setCantMatricula(int cantMatricula) {
		Matricula.cantMatricula = cantMatricula;
	}



	public Matricula() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getEstadoName() {
		if(this.estado == 0) {
			return "REGISTRADO";
		}else if(this.estado == 1) {
			return "MATRICULADO";
		}else {
			return "RETIRADO";
		}
	}
	
}