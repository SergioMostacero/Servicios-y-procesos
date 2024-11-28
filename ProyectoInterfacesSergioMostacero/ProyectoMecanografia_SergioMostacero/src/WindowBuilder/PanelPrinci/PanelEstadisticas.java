package WindowBuilder.PanelPrinci;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PanelEstadisticas extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel lblTituloEstadisticas;
	private JLabel lblPpm;
	private JLabel lblErrores;
	private JLabel lblTiempo;

	private JTextField txtPpm;
	private JTextField txtErrores;
	private JTextField txtTiempo;

	public PanelEstadisticas() {

		setBackground(Color.WHITE);
		setLayout(null);

		lblTituloEstadisticas = new JLabel("ESTADISTICAS");
		lblTituloEstadisticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloEstadisticas.setFont(new Font("Sylfaen", Font.BOLD, 24));
		lblTituloEstadisticas.setBounds(10, 11, 177, 71);
		add(lblTituloEstadisticas);

		lblPpm = new JLabel("PPM");
		lblPpm.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblPpm.setBounds(34, 93, 30, 25);
		add(lblPpm);

		lblErrores = new JLabel("Errores");
		lblErrores.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblErrores.setBounds(33, 151, 44, 25);
		add(lblErrores);

		lblTiempo = new JLabel("Tiempo");
		lblTiempo.setFont(new Font("Sylfaen", Font.BOLD, 13));
		lblTiempo.setBounds(34, 208, 62, 25);
		add(lblTiempo);

		txtPpm = new JTextField();
		txtPpm.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPpm.setForeground(new Color(0, 0, 0));
		txtPpm.setBounds(106, 88, 59, 26);
		txtPpm.setEnabled(false);
		txtPpm.setColumns(10);
		add(txtPpm);

		txtErrores = new JTextField();
		txtErrores.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtErrores.setColumns(10);
		txtErrores.setBounds(106, 146, 59, 26);
		txtErrores.setEnabled(false);
		add(txtErrores);

		txtTiempo = new JTextField();
		txtTiempo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTiempo.setColumns(10);
		txtTiempo.setEnabled(false);
		txtTiempo.setBounds(106, 203, 59, 26);
		add(txtTiempo);
		setVisible(true);
	}

	public JTextField getTxtPpm() {
		return txtPpm;
	}
	public void setTxtPpm(JTextField txtPpm) {
		this.txtPpm = txtPpm;
	}
	public JTextField getTxtErrores() {
		return txtErrores;
	}
	public void setTxtErrores(JTextField txtErrores) {
		this.txtErrores = txtErrores;
	}
	public JTextField getTxtTiempo() {
		return txtTiempo;
	}
	public void setTxtTiempo(JTextField txtTiempo) {
		this.txtTiempo = txtTiempo;
	}
}
