package arreglos;
import entidades.Curso;
import java.util.ArrayList;

public class ArregloCurso {
	private static ArrayList<Curso> listaCursos;
	
	static {
		listaCursos = new ArrayList<>();
	}
	
	public static void addCurso(Curso alumno) {
		ArregloCurso.listaCursos.add(alumno);
	}
	
	public static Curso getCurso(int indice) {
		return ArregloCurso.listaCursos.get(indice);
	}
	
	public static int getCantidadCursos(){
		return ArregloCurso.listaCursos.size();
	}
	
	public static void deleteCursoByCode(int code) {
		for(int i = 0; i < listaCursos.size();i++) {
			if(ArregloCurso.listaCursos.get(i).getCodCurso() == code) {
				ArregloCurso.listaCursos.remove(i);				
			}
		}
	}
	
	public static Curso getCursoByCode(int code) {
		for(int i = 0;i<listaCursos.size();i++) {
			if(ArregloCurso.listaCursos.get(i).getCodCurso() == code) {
				return ArregloCurso.listaCursos.get(i);
			}
		}
		return null;
	}
}
