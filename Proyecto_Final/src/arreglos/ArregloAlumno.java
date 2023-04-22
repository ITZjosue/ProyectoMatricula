package arreglos;
import entidades.Alumno;
import java.io.*;
import java.util.ArrayList;

public class ArregloAlumno {
	
	private static ArrayList<Alumno> listaAlumnos;
	
	static {
		listaAlumnos = new ArrayList<>();
		cargarAlumno();
		/*Alumno a = new Alumno("Dante Martin","Perez","7678872",15,990867622);
		Alumno b = new Alumno("Mario Cesar","Casas","1234567",14,990867622);
		Alumno c = new Alumno("Pedro Ramon","Suarez","9807654",12,990867622);
		Alumno d = new Alumno("Daniel Alejandro","Pereda","1845987",20,990867622);
		Alumno e = new Alumno("Michelle Melissa","Santos","3329487",19,990867622);
		Alumno f = new Alumno("Jorge Luis","Cordova","2345678",16,990867622);
		Alumno g = new Alumno("Fernanda Maria","Garcia","9087654",13,990867622);
		Alumno h = new Alumno("Juan Pablo","Alvarez","6758493",18,990867622);
		Alumno i = new Alumno("Isabella Maria","Gonzalez","5487109",17,990867622);
		Alumno j = new Alumno("Santiago Jose","Castillo","8783901",15,990867622);
		Alumno k = new Alumno("Camila Andrea","Martinez","8765432",14,990867622);
		Alumno l = new Alumno("Luis Fernando","Ramirez","5690831",16,990867622);
		Alumno m = new Alumno("Mariana Alejandra","Sanchez","1230987",18,990867622);
		Alumno n = new Alumno("Daniel Eduardo","Alfaro","8765432",15,990867622);
		Alumno o = new Alumno("Juliana Fernanda","Lopez","9087654",17,990867622);
		Alumno p = new Alumno("Cristian David","Gomez","6758493",14,990867622);
		Alumno q = new Alumno("Carolina Isabel","Cortes","5487109",16,990867622);
		Alumno r = new Alumno("Roberto Carlos","Arango","8783901",18,990867622);
		Alumno s = new Alumno("Vanessa Alejandra","Pardo","1230987",15,990867622);
		Alumno t = new Alumno("Andres Felipe","Giraldo","8765432",17,990867622);
		ArregloAlumno.setListaAlumnos(a);
		ArregloAlumno.setListaAlumnos(b);
		ArregloAlumno.setListaAlumnos(c);
		ArregloAlumno.setListaAlumnos(d);
		ArregloAlumno.setListaAlumnos(e);
		ArregloAlumno.setListaAlumnos(f);
		ArregloAlumno.setListaAlumnos(g);
		ArregloAlumno.setListaAlumnos(h);
		ArregloAlumno.setListaAlumnos(i);
		ArregloAlumno.setListaAlumnos(j);		
		ArregloAlumno.setListaAlumnos(k);
		ArregloAlumno.setListaAlumnos(l);
		ArregloAlumno.setListaAlumnos(m);
		ArregloAlumno.setListaAlumnos(n);
		ArregloAlumno.setListaAlumnos(o);
		ArregloAlumno.setListaAlumnos(p);
		ArregloAlumno.setListaAlumnos(q);
		ArregloAlumno.setListaAlumnos(r);
		ArregloAlumno.setListaAlumnos(s);
		ArregloAlumno.setListaAlumnos(t);*/
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
	
	public static void grabarAlumno() {
		try {
			PrintWriter pw;
			Alumno x;
			String linea;
			pw = new PrintWriter(new FileWriter("alumnos.txt"));
			for(int i = 0;i<ArregloAlumno.getListaAlumnosLen();i++) {
				x = ArregloAlumno.getAlumno(i);
				linea = x.getCodAlumno()+";"+
						x.getNombres()+";"+
						x.getApellidos()+";"+
						x.getDni()+";"+
						x.getCelular()+";"+
						x.getEstado()+";"+
						x.getEdad();
				pw.println(linea);
			}
			pw.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void cargarAlumno() {
		try {
			BufferedReader br;
			String linea, nombres,apellidos,dni;
			int codAlumno, edad,celular,estado;
			String s[];
			
			br = new BufferedReader(new FileReader("alumnos.txt"));
			while((linea = br.readLine()) != null) {
				s = linea.split(";");
				codAlumno = Integer.parseInt(s[0]);
				nombres = s[1];
				apellidos = s[2];
				dni = s[3];
				celular = Integer.parseInt(s[4]);
				estado = Integer.parseInt(s[5]);
				edad = Integer.parseInt(s[6]);
				ArregloAlumno.setListaAlumnos(new Alumno(codAlumno,nombres,apellidos,dni,edad,celular,estado));
			}
			br.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
