package WindowBuilder.PanelPrinci;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelMostrarStatsFail extends JPanel{

	private static final long serialVersionUID = 1L;
	private JButton btnVolver;
	private JTextArea textArea;
	private JLabel lblTitulo;
	private JButton btnSalir;
	
	public PanelMostrarStatsFail() {
		setLayout(null);
		
		setSize(442, 359);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(35, 45, 370, 231);
		textArea.setEditable(false);
		add(textArea);
		
		btnVolver = new JButton("Volver a jugar");
		btnVolver.setBounds(47, 287, 135, 37);
		add(btnVolver);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(243, 287, 135, 37);
		add(btnSalir);
		
		lblTitulo = new JLabel("FIN DEL JUEGO");
		lblTitulo.setFont(new Font("SimSun-ExtG", Font.BOLD, 17));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(35, 11, 370, 23);
		add(lblTitulo);
	}
	
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	
	
}
