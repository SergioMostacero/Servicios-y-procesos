package WindowBuilder.Login;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import Passwd.PasswordEvent;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelLogin extends JPanel {


    private JLabel titulo; // título del panel
    private JLabel usuario; // etiqueta para el campo de usuario
    private JLabel contrasena; // etiqueta para el campo de contraseña

    private JTextField usuarioField; // campo para ingresar el usuario
    private JPasswordField contrasenaField; // campo para ingresar la contraseña

    private JButton botonInicio; // botón para iniciar sesión
    private JCheckBox mostrarPsw; // checkbox para mostrar/ocultar la contraseña

    private Image backgroundImage; // imagen de fondo

    public PanelLogin() {
        // establecer diseño nulo para posicionamiento manual
        setLayout(null);

        // cargar la imagen de fondo
        backgroundImage = Toolkit.getDefaultToolkit().getImage("src/imagenes/fondoInicio.jpg");

        // configuración del título
        titulo = new JLabel("INICIAR  SESIÓN");
        titulo.setFont(new Font("Georgia", Font.BOLD, 29));
        titulo.setBounds(76, 11, 263, 77);

        // etiqueta y campo para el usuario
        usuario = new JLabel("Usuario:");
        usuario.setFont(new Font("Georgia", Font.BOLD, 14));
        usuario.setBounds(74, 124, 74, 35);

        usuarioField = new JTextField();
        usuarioField.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        usuarioField.setFont(new Font("UniSansRegular", Font.PLAIN, 13));
        usuarioField.setBounds(185, 131, 106, 20);
        usuarioField.setColumns(10);

        // etiqueta y campo para la contraseña
        contrasena = new JLabel("Contraseña:");
        contrasena.setFont(new Font("Georgia", Font.BOLD, 14));
        contrasena.setBounds(49, 201, 99, 29);

        contrasenaField = new JPasswordField();
        contrasenaField.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0)));
        contrasenaField.setBounds(185, 205, 106, 20);
        contrasenaField.setFont(new Font("UniSansRegular", Font.PLAIN, 13));

        // limitar la longitud de los campos de texto
        usuarioField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (usuarioField.getText().length() >= 10) {
                    e.consume();
                }
            }
        });

        contrasenaField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (contrasenaField.getPassword().length >= 10) {
                    e.consume();
                }
            }
        });

        // checkbox para mostrar/ocultar contraseña
        mostrarPsw = new JCheckBox();
        mostrarPsw.setBounds(304, 210, 21, 20);

        // agregar evento para el checkbox
        PasswordEvent passwordEvent = new PasswordEvent(mostrarPsw, contrasenaField);
        mostrarPsw.addActionListener(passwordEvent);

        // botón para iniciar sesión
        botonInicio = new JButton("INICIAR SESIÓN");
        botonInicio.setBackground(new Color(255, 255, 179));
        botonInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        botonInicio.setBounds(100, 359, 170, 50);

        // agregar componentes al panel
        add(titulo);
        add(usuario);
        add(contrasena);
        add(usuarioField);
        add(contrasenaField);
        add(mostrarPsw);
        add(botonInicio);
    }

    // método para dibujar la imagen de fondo
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // getters y setters para acceder a los componentes
    public JButton getBotonInicio() {
        return botonInicio;
    }

    public void setBotonInicio(JButton botonInicio) {
        this.botonInicio = botonInicio;
    }

    public JTextField getUsuarioField() {
        return usuarioField;
    }

    public void setUsuarioField(JTextField usuarioField) {
        this.usuarioField = usuarioField;
    }

    public JPasswordField getContrasenaField() {
        return contrasenaField;
    }

    public void setContrasenaField(JPasswordField contrasenaField) {
        this.contrasenaField = contrasenaField;
    }
}
