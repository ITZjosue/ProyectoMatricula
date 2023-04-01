package entidades;
public class Matricula {
	private int numMatricula,codAlumno ,codCurso;
	private String fechaMatricula,horaMatricula;
	
	private static int cantMatricula;
	static {
		cantMatricula= 0;
	}
	
	public Matricula(int codAlumno, int codCurso,String numMtricula, String fechaMatricula, String horaMatricula) {
		cantMatricula ++;
		this.numMatricula = 10000 + cantMatricula;
		this.codAlumno = codAlumno;
		this.codCurso = codCurso;
		this.fechaMatricula = fechaMatricula;
		this.horaMatricula = horaMatricula;
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

	public Matricula() {
	}

	
}