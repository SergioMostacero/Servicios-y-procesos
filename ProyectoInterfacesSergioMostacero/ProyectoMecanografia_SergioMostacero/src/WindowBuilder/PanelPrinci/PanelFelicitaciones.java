package WindowBuilder.PanelPrinci;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class PanelFelicitaciones extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JLabel lblTitulo;
	private JTextArea textStats;
	
	private JButton btnEnviarYsalir;
	private JButton btnGuardayContinuar;
	private JButton btnSalir;
	
	public PanelFelicitaciones() {
		setLayout(null);
		
		textStats = new JTextArea();
		textStats.setLineWrap(true);
		textStats.setBounds(10, 46, 760, 164);
		
		lblTitulo = new JLabel("FELICITACIONES, HAS SUPERADO LA PRUEBA!");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(171, 11, 465, 38);
		
		add(lblTitulo);
		add(textStats);
		
		btnEnviarYsalir = new JButton("Enviar por correo y salir");
		btnEnviarYsalir.setBounds(20, 245, 202, 33);
		add(btnEnviarYsalir);
		
		btnGuardayContinuar = new JButton("Enviar por correo y continuar");
		btnGuardayContinuar.setBounds(305, 245, 202, 33);
		add(btnGuardayContinuar);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(588, 245, 115, 33);
		add(btnSalir);
	}
	
	public JTextArea getTextStats() {
		return textStats;
	}
	public void setTextStats(JTextArea textStats) {
		this.textStats = textStats;
	}

	public JButton getBtnEnviarYsalir() {
		return btnEnviarYsalir;
	}
	public void setBtnEnviarYsalir(JButton btnEnviarYsalir) {
		this.btnEnviarYsalir = btnEnviarYsalir;
	}
	public JButton getBtnGuardayContinuar() {
		return btnGuardayContinuar;
	}
	public void setBtnGuardayContinuar(JButton btnGuardayContinuar) {
		this.btnGuardayContinuar = btnGuardayContinuar;
	}
	public JButton getBtnSalir() {
		return btnSalir;
	}
	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}
	public JLabel getLblTitulo() {
		return lblTitulo;
	}
	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}
}
