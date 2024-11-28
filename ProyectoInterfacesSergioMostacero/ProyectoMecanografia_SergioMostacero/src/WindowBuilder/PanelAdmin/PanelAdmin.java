package WindowBuilder.PanelAdmin;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class PanelAdmin extends JPanel {

    private static final long serialVersionUID = 1L;

    private JLabel titulo;
    private JButton gestionarAltasBajas;
    private JButton configuracionApp;
    private JButton probarEmail;
    private JButton cambiarArchivoLecciones;

    public PanelAdmin() {
        setLayout(null);

        titulo = new JLabel("PANEL DE ADMINISTRADOR");
        titulo.setFont(new Font("UniSansSemiBold", Font.PLAIN, 18));
        titulo.setBounds(80, 20, 300, 30);
        add(titulo);

        gestionarAltasBajas = new JButton("Gestionar Altas/Bajas");
        gestionarAltasBajas.setBounds(100, 80, 200, 50);
        gestionarAltasBajas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gestionarAltasBajas.addActionListener(e -> JOptionPane.showMessageDialog(this, "Funcionalidad de Altas/Bajas en desarrollo."));
        add(gestionarAltasBajas);

        configuracionApp = new JButton("Configuración de la App");
        configuracionApp.setBounds(100, 150, 200, 50);
        configuracionApp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        configuracionApp.addActionListener(e -> JOptionPane.showMessageDialog(this, "Configuración de la app en desarrollo."));
        add(configuracionApp);

        probarEmail = new JButton("Probar Envío de Emails");
        probarEmail.setBounds(100, 220, 200, 50);
        probarEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        probarEmail.addActionListener(e -> JOptionPane.showMessageDialog(this, "Prueba de envío de emails en desarrollo."));
        add(probarEmail);

        cambiarArchivoLecciones = new JButton("Cambiar Archivo de Lecciones");
        cambiarArchivoLecciones.setBounds(100, 290, 200, 50);
        cambiarArchivoLecciones.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        cambiarArchivoLecciones.addActionListener(e -> JOptionPane.showMessageDialog(this, "Cambio de archivo de lecciones en desarrollo."));
        add(cambiarArchivoLecciones);
    }
}

