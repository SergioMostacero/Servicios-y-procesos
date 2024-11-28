package GestorFichs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Estadisticas {
	
	private String idUsuario;

	private boolean dificultad;
	private int ppm;
	private int error;
	private int tiempoMinutos;
	private int tiempoSegundos;
	private Date date;
	private SimpleDateFormat formato;
	private String fechaMostrar;
	
	public Estadisticas(String idUsuario, boolean dificultad, int ppm, int error, int tiempoMinutos, int tiempoSegundos, Date date) {
		this.idUsuario = idUsuario;
		this.ppm = ppm;
		this.error = error;
		this.tiempoMinutos = tiempoMinutos;
		this.tiempoSegundos = tiempoSegundos;
		this.dificultad = dificultad;
		this.date = date;
		
		formato = new SimpleDateFormat("dd-MM-yyy-HH::mm:s");
		fechaMostrar = formato.format(date);
		
	}
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public boolean isDificultad() {
		return dificultad;
	}
	public void setDificultad(boolean dificultad) {
		this.dificultad = dificultad;
	}
	public int getPpm() {
		return ppm;
	}
	public void setPpm(int ppm) {
		this.ppm = ppm;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public int getTiempoMinutos() {
		return tiempoMinutos;
	}
	public void setTiempoMinutos(int tiempoMinutos) {
		this.tiempoMinutos = tiempoMinutos;
	}
	public int getTiempoSegundos() {
		return tiempoSegundos;
	}
	public void setTiempoSegundos(int tiempoSegundos) {
		this.tiempoSegundos = tiempoSegundos;
	}
	public Date getDate() {
		return date;
	}
	
	@Override
	public String toString() {
			
		String dificultadString = (dificultad == true) ? "Facil" : "Dificil"; 
		
		return "\nDificultad: " + dificultadString
				+ "\nPpm: " + ppm 
				+ "\nErrores: " + error 
				+ "\nTiempo restante minutos: " + tiempoMinutos 
				+ "\nTiempo restante segundos: " + tiempoSegundos 
				+ "\nFecha: "+ fechaMostrar;
	}
}
