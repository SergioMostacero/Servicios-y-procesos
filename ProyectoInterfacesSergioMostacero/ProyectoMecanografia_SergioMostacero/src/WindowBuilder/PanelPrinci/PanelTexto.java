package WindowBuilder.PanelPrinci;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;



public class PanelTexto extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JTextArea textArea;
	
	public PanelTexto(){
		setLayout(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 23));
		textArea.setBounds(0, 0, 1450, 500);
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setLineWrap(true);
		
		add(textArea);
		
		setVisible(true);
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
	
	

}
