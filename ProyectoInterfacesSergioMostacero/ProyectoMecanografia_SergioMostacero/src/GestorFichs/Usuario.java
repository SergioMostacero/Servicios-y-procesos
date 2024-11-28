package GestorFichs;

import java.util.ArrayList;

public class Usuario {

	private String id;
	private String nombre;
	private String contrasena;
	private String correo;
	private ArrayList<Estadisticas> estadiscitas;
	
	public Usuario(String id, String nombre, String contrasena, String correo) {
		estadiscitas = new ArrayList<>();
		this.nombre = nombre;
		this.contrasena = contrasena;
		this.correo = correo;
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	
	@Override
	public String toString() {
		return "nombre :" + nombre + ""
				+ "\n contrasena=" + contrasena + 
				"\n correo=" + correo  +
				"\n estadisticas" + estadiscitas.toString() + "\n";
	}

	public ArrayList<Estadisticas> getEstadisticas() {
		return estadiscitas;
	}
	public Estadisticas getOnlyStat(int index) {
		return estadiscitas.get(index);
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setEstadiscitas(Estadisticas stats) {
		this.estadiscitas.add(stats) ;
	}
	public void addEstadistica(Estadisticas estadistica) {
		estadiscitas.add(estadistica);
	}

	
}