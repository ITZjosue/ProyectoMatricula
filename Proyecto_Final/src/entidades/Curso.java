package entidades;

public class Curso {
	private int codCurso, ciclo, creditos, horas;
	private String asignatura;
	private static int cantCurso;
	static {
		cantCurso = 0;
	}
	
	public Curso(int ciclo,int creditos,int horas,String asignatura) {
		cantCurso++;
		this.codCurso = 10000+cantCurso;
		this.creditos = creditos;
		this.ciclo = ciclo;
		this.horas = horas;
		this.asignatura = asignatura;
	}
	
	public int getCodCurso() {
		return codCurso;
	}
	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}
	public int getCiclo() {
		return ciclo;
	}
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getHoras() {
		return horas;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public String getAsignatura() {
		return asignatura;
	}
	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}
	
}
