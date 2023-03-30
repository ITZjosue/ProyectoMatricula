package arreglos;


import java.util.ArrayList;
import java.io.*;

import entidades.Matricula;

public class ArregloMatricula {
	
	private ArrayList<Matricula> matricula; 
	
	public ArregloMatricula() {
		matricula = new ArrayList <Matricula> ();
		cargarMatriculas();
	}
	
	public void adicionar(Matricula x) {
	    boolean existe = false;
	    for (int i = 0; i < tamanio(); i++) {
	        Matricula m = obtener(i);
	        if (m.getCodAlumno() == x.getCodAlumno() && m.getCodCurso() == x.getCodCurso()) {
	            existe = true;
	            System.out.println("Error: El alumno ya está matriculado en este curso.");
	            break;
	        }
	    }
	    if (!existe) {
	        matricula.add(x);
	    }
	}
	
	public int tamanio() {
		return matricula.size();
	}
	
	public Matricula obtener(int i) {
		return matricula.get(i);
	}
	
	public Matricula buscar(int numMatricula) {
		for (int i = 0; i < tamanio(); i++) 
			if(obtener(i).getNumMatricula() == numMatricula)
				return obtener(i);
		
		return null;
	}
	
	public void eliminar(Matricula x) {
		matricula.remove(x);
	}
	
	public void grabarMatricula() {
		try {
			PrintWriter pw;
			String linea;
			Matricula x;
			pw = new PrintWriter(new FileWriter("matriculas.txt"));
			for (int i = 0; i < tamanio(); i++) {
				x = obtener(i);
				linea = x.getNumMatricula() + ";" +
						x.getCodAlumno() + ";" +
						x.getCodCurso() + ";" +
						x.getFechaMatricula() + ";" +
						x.getHoraMatricula();
				pw.println(linea);
			}
			pw.close();
			
		} catch (Exception e) {
		}
	}
	
	private void cargarMatriculas() {
		try {
			BufferedReader br;
			String linea, fechaMatricula,horaMatricula;
			String[] s;
			int numMatricula,codAlumno,codCurso;
			br = new BufferedReader(new FileReader("matriculas.txt"));
			while ((linea=br.readLine())!=null) {
				s = linea.split(";");
				numMatricula = Integer.parseInt(s[0].trim());
				codAlumno = Integer.parseInt(s[1].trim());
				codCurso = Integer.parseInt(s[2].trim());
				fechaMatricula = s[3].trim();
				horaMatricula = s[4].trim();
				//adicionar(new Matricula(numMatricula,codAlumno,codCurso,fechaMatricula,horaMatricula));
			}
			br.close();
		} catch (Exception e) {
		}
		
	}

}
