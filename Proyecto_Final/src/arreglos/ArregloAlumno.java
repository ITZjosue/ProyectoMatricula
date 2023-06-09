package arreglos;
import entidades.Alumno;

import java.io.*;

import java.util.ArrayList;

public class ArregloAlumno {
	
	private ArrayList<Alumno> arregloAlumnos;
	
	private static ArrayList<Alumno> listaAlumnos;
	
	static {
		listaAlumnos = new ArrayList<>();
	}
	public void ActualizarArchivo() {
		grabarAlumnos();
	}
	
	private void grabarAlumnos() {
		try {
			PrintWriter pw;
			String linea;
			Alumno x;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for (int i = 0; i< arregloAlumnos.size(); i++) {
				x = arregloAlumnos.get(i);
				linea = x.getCodAlumno() + ";" +
					    x.getNombres() + ";" +
						x.getApellidos() + ";" +
						x.getDni() + ";" +
						x.getEdad() + ";" +
						x.getCelular() + ";" +
						x.getEstado();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	
	public static void setListaAlumnos(Alumno alumno) {
		ArregloAlumno.listaAlumnos.add(alumno);
	}
	
	public static Alumno getAlumno(int indice) {
		return ArregloAlumno.listaAlumnos.get(indice);
	}
	
	public static int getListaAlumnosLen(){
		return ArregloAlumno.listaAlumnos.size();
	}
	
	public static Alumno getAlumnoByCode(int code) {
		for(int i = 0; i < listaAlumnos.size();i++) {
			if(ArregloAlumno.listaAlumnos.get(i).getCodAlumno() == code) {
				return ArregloAlumno.listaAlumnos.get(i);
			}
		}
		return null;
	}
	
	public static void deleteAlumnoByCode(int code) {
		for(int i = 0; i < listaAlumnos.size();i++) {
			if(ArregloAlumno.listaAlumnos.get(i).getCodAlumno() == code) {
				if(ArregloAlumno.listaAlumnos.get(i).getCodAlumno() == code)
					ArregloAlumno.listaAlumnos.remove(i);
			}
		}
	}
	
	public static ArrayList<Alumno> getAlumnosRegistrados() {
		ArrayList<Alumno> registrados = new ArrayList<>();
		for(int i= 0;i<ArregloAlumno.listaAlumnos.size();i++) {
			if(ArregloAlumno.listaAlumnos.get(i).getEstado() == 0)
				registrados.add(ArregloAlumno.listaAlumnos.get(i));
		}
		return registrados;
	}
	
	public static ArrayList<Alumno> getAlumnosVigentes(){
		ArrayList<Alumno> vigentes = new ArrayList<>();
		for(int i = 0;i<ArregloAlumno.listaAlumnos.size();i++) {
			if(ArregloAlumno.listaAlumnos.get(i).getEstado() == 1) {
				vigentes.add(ArregloAlumno.listaAlumnos.get(i));
			}
		}
		return vigentes;
	}

	public Alumno buscar(int codAlumno) {
		for (int i = 0; i < listaAlumnos.size(); i++) {
			if (listaAlumnos.get(i).getCodAlumno() == codAlumno)
				return listaAlumnos.get(i);
		}
		return null;
	}

	public int tamanio() {
		return listaAlumnos.size();
	}

	public Alumno obtener(int i) {
		return listaAlumnos.get(i);
		}
	
}