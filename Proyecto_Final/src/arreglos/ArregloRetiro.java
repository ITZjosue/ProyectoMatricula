package arreglos;

import entidades.Retiro;
import java.util.ArrayList;

public class ArregloRetiro {
	private static ArrayList<Retiro> arregloRetiro;
	
	static {
		arregloRetiro = new ArrayList<>();
	}
	
	public static void adicionar(Retiro retiro) {
		arregloRetiro.add(retiro);
	}
	public static int getRetiroLen() {
		return arregloRetiro.size();
	}
	public static Retiro getRetiro(int index) {
		return arregloRetiro.get(index);
	}
	
	public static Retiro getRetiroByCode(int code) {
		for(int i = 0;i<arregloRetiro.size();i++) {
			if(arregloRetiro.get(i).getNumRetiro() == code) {
				return arregloRetiro.get(i);
			}
		}
		return null;
	}
	
	public static void deleteRetiroByCode(int code) {
		for(int i = 0; i < arregloRetiro.size();i++) {
			if(arregloRetiro.get(i).getNumRetiro() == code) {
				arregloRetiro.remove(i);
			}
		}
	}
}
