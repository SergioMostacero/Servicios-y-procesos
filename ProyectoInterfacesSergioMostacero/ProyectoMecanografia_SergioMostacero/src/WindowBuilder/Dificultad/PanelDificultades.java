package WindowBuilder.Dificultad;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class PanelDificultades extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel textoDificultad;

	private ButtonGroup grupoDificultad;

	private JRadioButton botonFacil;
	private JRadioButton botonDificil;

	private Image fondoLogIn;
	private JButton botonComenzar;

	public PanelDificultades(Image fondo) {

		this.fondoLogIn = fondo;

		setLayout(null);
		setVisible(true);

		textoDificultad = new JLabel("Elige la dificultad");
		textoDificultad.setBounds(120, 50, 178, 31);
		textoDificultad.setFont(new Font("UniSansRegular", Font.PLAIN, 22));
		textoDificultad.setVisible(true);

		grupoDificultad = new ButtonGroup();

		botonFacil = new JRadioButton("Fácil", true);
		botonFacil.setFont(new Font("UniSansRegular", Font.PLAIN, 15));

		botonDificil = new JRadioButton("Difícil", false);
		botonDificil.setFont(new Font("UniSansRegular", Font.PLAIN, 15));

		grupoDificultad.add(botonFacil);
		grupoDificultad.add(botonDificil);

		botonFacil.setBounds(155, 100, 86, 51);
		botonDificil.setBounds(155, 169, 86, 51);

		botonFacil.setVisible(true);
		botonDificil.setVisible(true);
		
		botonComenzar = new JButton("START");
		botonComenzar.setFont(new Font("Dialog", Font.PLAIN, 12));
		botonComenzar.setBounds(92, 238, 217, 51);

		add(botonDificil);
		add(botonFacil);
		add(textoDificultad);
		add(botonComenzar);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 11, 10, 10);
		add(panel);
	}

	public JButton getBotonComenzar() {
		return botonComenzar;
	}

	public void setBotonComenzar(JButton botonComenzar) {
		this.botonComenzar = botonComenzar;
	}

	public JRadioButton getBotonFacil() {
		return botonFacil;
	}

	public void setBotonFacil(JRadioButton botonFacil) {
		this.botonFacil = botonFacil;
	}

	public JRadioButton getBotonDificil() {
		return botonDificil;
	}

	public void setBotonDificil(JRadioButton botonDificil) {
		this.botonDificil = botonDificil;
	}
	
	public void paintComponent(Graphics g) {
		g.drawImage(fondoLogIn,0,0,getWidth(),getHeight(), null);
	}
}
