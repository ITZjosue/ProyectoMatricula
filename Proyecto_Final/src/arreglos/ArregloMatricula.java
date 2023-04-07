package arreglos;


import java.util.ArrayList;
import java.io.*;

import entidades.Matricula;

public class ArregloMatricula {
	
	private static ArrayList<Matricula> arregloMatricula; 
	
	static {
		arregloMatricula = new ArrayList<>();
	}
	
	public static void adicionar(Matricula matricula) {
		ArregloMatricula.arregloMatricula.add(matricula);
	}
	
	public static Matricula getMatricula(int indice) {
		return ArregloMatricula.arregloMatricula.get(indice);
	}
	public static int tamanio() {
		return arregloMatricula.size();
	}
	
	public static Matricula getMatriculaById(int id) {
		for(int i = 0; i < arregloMatricula.size();i++) {
			if(arregloMatricula.get(i).getNumMatricula() == id) {
				return arregloMatricula.get(i);
			}
		}
		return null;
	}
	
	public static void deleteMatriculaByCode(int code) {
		for(int i = 0; i < arregloMatricula.size();i++) {
			if(arregloMatricula.get(i).getNumMatricula() == code) {
				arregloMatricula.remove(i);
			}
		}
	}
}
