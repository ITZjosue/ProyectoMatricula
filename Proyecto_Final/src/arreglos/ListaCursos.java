package arreglos;
import entidades.Curso;
import java.util.ArrayList;

public class ListaCursos {
	private static ArrayList<Curso> listaCursos;
	
	static {
		listaCursos = new ArrayList<>();
	}
	
	public static void addCurso(Curso alumno) {
		ListaCursos.listaCursos.add(alumno);
	}
	
	public static Curso getCurso(int indice) {
		return ListaCursos.listaCursos.get(indice);
	}
	
	public static int getCantidadCursos(){
		return ListaCursos.listaCursos.size();
	}
	
	public static void deleteCursoByCode(int code) {
		for(int i = 0; i < listaCursos.size();i++) {
			if(ListaCursos.listaCursos.get(i).getCodCurso() == code) {
				ListaCursos.listaCursos.remove(i);				
			}
		}
	}
	
	public static Curso getCursoByCode(int code) {
		for(int i = 0;i<listaCursos.size();i++) {
			if(ListaCursos.listaCursos.get(i).getCodCurso() == code) {
				return ListaCursos.listaCursos.get(i);
			}
		}
		return null;
	}
}
