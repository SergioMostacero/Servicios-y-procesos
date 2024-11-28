import java.awt.EventQueue;

import javax.swing.JOptionPane;

import WindowBuilder.Carga.FramePrincipal;



public class main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					new FramePrincipal();

				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error", "Error cargando el programa", 0);
				}
			}
		});
	}
}