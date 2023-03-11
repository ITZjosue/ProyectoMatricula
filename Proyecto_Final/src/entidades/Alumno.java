package entidades;


public class Alumno {
	private int codAlumno, edad,celular,estado;
	private String nombres,apellidos,dni;
	
	private static int cantAlumnos;
	static {
		cantAlumnos = 0;
	}
	
	public Alumno(String nombres, String apellidos,String dni, int edad, int celular) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.estado = 0;
		this.celular = celular;
		cantAlumnos++;
		this.codAlumno = cantAlumnos;
	}
	
	public Alumno(String nombres, String apellidos,String dni, int edad, int celular,int estado) {
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.estado = estado;
		this.celular = celular;
		cantAlumnos++;
		this.codAlumno = cantAlumnos;
	}
	public int getCodAlumno() {
		return codAlumno;
	}
	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCelular() {
		return celular;
	}
	public void setCelular(int celular) {
		this.celular = celular;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
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
