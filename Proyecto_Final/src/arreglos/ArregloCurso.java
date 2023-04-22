package arreglos;
import entidades.Alumno;
import entidades.Curso;

import java.io.*;
import java.util.ArrayList;

public class ArregloCurso {
	private static ArrayList<Curso> listaCursos;
	
	static {
		listaCursos = new ArrayList<>();
		//cargarCurso();
		Curso a = new Curso(2,2,6,"Fisica II");
		Curso b = new Curso(2,3,3,"Ecuaciones Diferenciales");
		Curso c = new Curso(3,5,9,"Calculo I");
		Curso d = new Curso(1,2,4,"Quimica Organica");
		Curso e = new Curso(4,3,2,"Fisico-Quimica");
		Curso f = new Curso(2,4,3,"Bases de datos");
		Curso g = new Curso(1,5,4,"Geometria");
		Curso h = new Curso(3,2,5,"Algebra Lineal");
		Curso i = new Curso(4,5,6,"Programacion Orientada a Objetos");
		Curso j = new Curso(1,3,4,"Biologia Molecular");
		Curso k = new Curso(2,1,3,"Matematicas Discretas");
		Curso l = new Curso(3,4,5,"Termodinamica");
		Curso m = new Curso(1,4,3,"Ingenieria de Software");
		Curso n = new Curso(4,2,2,"Redes de Computadoras");
		Curso o = new Curso(3,3,6,"Optica");
		Curso p = new Curso(2,5,4,"Probabilidad y Estadistica");
		Curso q = new Curso(4,4,3,"Sistemas Operativos");
		ArregloCurso.addCurso(a);
		ArregloCurso.addCurso(b);
		ArregloCurso.addCurso(c);
		ArregloCurso.addCurso(d);
		ArregloCurso.addCurso(e);
		ArregloCurso.addCurso(f);
		ArregloCurso.addCurso(g);
		ArregloCurso.addCurso(h);
		ArregloCurso.addCurso(i);
		ArregloCurso.addCurso(j);
		ArregloCurso.addCurso(k);
		ArregloCurso.addCurso(l);
		ArregloCurso.addCurso(m);
		ArregloCurso.addCurso(n);
		ArregloCurso.addCurso(o);
		ArregloCurso.addCurso(p);
		ArregloCurso.addCurso(q);
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
	
	public static void grabarCurso() {
		try {
			PrintWriter pw;
			Curso x;
			String linea;
			pw = new PrintWriter(new FileWriter("curso.txt"));
			for(int i = 0;i<ArregloAlumno.getListaAlumnosLen();i++) {
				x = ArregloCurso.getCurso(i);
				linea = x.getCodCurso()+";"+
						x.getAsignatura()+";"+
						x.getCiclo()+";"+
						x.getCreditos()+";"+
						x.getHoras();
				pw.println(linea);
			}
			pw.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void cargarCurso() {
		try {
			BufferedReader br;
			String linea, asignatura;;
			int codCurso, ciclo, creditos, horas;
			String s[];
			
			br = new BufferedReader(new FileReader("curso.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codCurso = Integer.parseInt(s[0]);
				asignatura = s[1];
				ciclo = Integer.parseInt(s[2]);
				creditos = Integer.parseInt(s[3]);
				horas = Integer.parseInt(s[4]);
				ArregloCurso.addCurso(new Curso(codCurso,ciclo,creditos,horas,asignatura));
			}
			br.close();
		}catch(Exception e) {
			System.out.println("acac");
		}
	}
}
