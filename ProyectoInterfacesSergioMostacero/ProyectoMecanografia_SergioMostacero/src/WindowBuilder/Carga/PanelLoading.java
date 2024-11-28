package WindowBuilder.Carga;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class PanelLoading extends JPanel{

	private JProgressBar barraProgreso;

	private int contador = 0;
	private Image cargaTematica;


	public PanelLoading(Image fondo) {

		this.cargaTematica = fondo;

		setLayout(null);
		barraProgreso = new JProgressBar(0, 6);

		barraProgreso.setVisible(true);
		barraProgreso.setBounds(0, 458, 750, 42);
		barraProgreso.setBorderPainted(false);
		barraProgreso.setForeground(new Color(116, 50, 36));
		barraProgreso.setStringPainted(true);

		add(barraProgreso);

	}


	public int getContador() {
		return contador;
	}

	public JProgressBar getBarraProgreso() {
		return barraProgreso;
	}

	//fondo de pantalla
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(cargaTematica,0,0,getWidth(),getHeight(), null);

	}


	


}
