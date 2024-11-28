package WindowBuilder.PanelPrinci;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelEscribir extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;

	public PanelEscribir() {
		
		setLayout(null);

		textArea = new JTextArea();
		textArea.setBounds(1, 1, 1600, 600);
		textArea.setEnabled(false);
		textArea.setLineWrap(true);
		add(textArea);

		setVisible(true);
	}

	public JTextArea getTextPane() {
		return textArea;
	}
	public void setTextPane(JTextArea textPane) {
		this.textArea = textPane;
	}
}
