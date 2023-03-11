package arreglos;
import entidades.Alumno;
import java.util.ArrayList;

public class ListaAlumnos {
	private static ArrayList<Alumno> listaAlumnos;
	
	static {
		listaAlumnos = new ArrayList<>();
	}
	
	public static void setListaAlumnos(Alumno alumno) {
		ListaAlumnos.listaAlumnos.add(alumno);
	}
	
	public static Alumno getAlumno(int indice) {
		return ListaAlumnos.listaAlumnos.get(indice);
	}
	
	public static int getListaAlumnosLen(){
		return ListaAlumnos.listaAlumnos.size();
	}
	
	public static Alumno getAlumnoByCode(int code) {
		for(int i = 0; i < listaAlumnos.size();i++) {
			if(ListaAlumnos.listaAlumnos.get(i).getCodAlumno() == code) {
				return ListaAlumnos.listaAlumnos.get(i);
			}
		}
		return null;
	}
	
	public static void deleteAlumnoByCode(int code) {
		for(int i = 0; i < listaAlumnos.size();i++) {
			if(ListaAlumnos.listaAlumnos.get(i).getCodAlumno() == code) {
				if(ListaAlumnos.listaAlumnos.get(i).getCodAlumno() == code)
					ListaAlumnos.listaAlumnos.remove(i);
			}
		}
	}
}
