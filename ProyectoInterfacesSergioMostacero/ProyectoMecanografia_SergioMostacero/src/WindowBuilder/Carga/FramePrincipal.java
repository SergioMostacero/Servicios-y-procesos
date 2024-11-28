package WindowBuilder.Carga;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Correo.EnviarMail;
import GestorFichs.DatosFicheros;
import GestorFichs.Estadisticas;
import GestorFichs.Usuario;
import WindowBuilder.Dificultad.PanelDificultades;
import WindowBuilder.Login.PanelLogin;
import WindowBuilder.PanelAdmin.PanelAdmin;
import WindowBuilder.PanelPrinci.PanelPrincipal;


public class FramePrincipal extends JFrame{

	private static final long serialVersionUID = 1L;

	private Image image;

	private PanelLoading panelCarga;
	private PanelLogin login;
	private DatosFicheros dataFile;

	private Timer time;

	private Dimension pantallaCompleta;
	private PanelPrincipal panelPrincipal;
	private PanelDificultades panelDificultades;

	private ArrayList<Usuario> listaUsuarios;
	private ArrayList<String> textos;
	private ArrayList <Estadisticas> estadisticas;
	private Usuario usuarioLogin;


	private int contador;

	public FramePrincipal() {

		setIconImage(Toolkit.getDefaultToolkit().getImage("src/imagenes/iconoSinPinguino.jpg"));
		listaUsuarios = new ArrayList<>();
		estadisticas = new ArrayList<>();
		textos = new ArrayList<>();
		pantallaCompleta = Toolkit. getDefaultToolkit(). getScreenSize();
		image = requestImage("src/imagenes/cargaTematica.jpg");
		dataFile = new DatosFicheros(listaUsuarios, textos, estadisticas);
		login = new PanelLogin();
		panelCarga = new PanelLoading(image);

		login.setVisible(false);
		panelCarga.setVisible(true);

		//tamaño pantalla carga
		setSize(750, 500);
		setResizable(false);
		setLocationRelativeTo(null);

		setUndecorated(true);

		timerEvent();
		add(panelCarga);

		setVisible(true);
		preguntarCerrarApp();


	}

	private Image requestImage(String ruta) {
		BufferedImage  image = null;

		try {
			image = ImageIO.read(new File(ruta));
		}catch (IOException e) {
			JOptionPane.showInternalMessageDialog(null, "Error, background se encuentra", "Imagen no localizada", 0);
			System.exit(ABORT);
		}

		return image;
	}

	public void timerEvent() {

		time = new Timer(1000, e ->{
			contador += 1;
			panelCarga.getBarraProgreso().setValue(contador);

			comprobarFicheros(contador);
		});
		time.start();
	}

	//comprobamos todos los ficheros y si no es correcto tira de un error
	void comprobarFicheros(int contador) {
		if(contador == 4) {

			dataFile.comprobarFile();
			dataFile.accederFicheroUsuario("src/GestorFichs/usuarios.txt");
			dataFile.leerDatosTexto("src/GestorFichs/textos.txt");
			dataFile.accederDatosEstadisticas("src/GestorFichs/estadisticas.txt");

		}

		if(contador == 6) {
			time.stop();
			dispose();

			panelCarga.setVisible(false);
			setTitle("INICIO DE SESIÓN");
			login.setVisible(true);
			setUndecorated(false);

			eventoLogIn();

			setVisible(true);
			setSize(400,500);
			setLocationRelativeTo(null);

			add(login);
		}
	}

	public void eventoLogIn() {
		login.getBotonInicio().addActionListener(e -> {

			//Necesitamos el valueOf ya que el getPassword te devuelve un Array
			String pass = String.valueOf( login.getContrasenaField().getPassword());
			String name = login.getUsuarioField().getText();

			comprobarLength(name, pass);

			for(int i = 0; i<listaUsuarios.size();i++) {
				//Si el usuario y contraseña son correctos
				if((pass.equals(listaUsuarios.get(i).getContrasena()) && (name.equals(listaUsuarios.get(i).getNombre()) ))) {
					usuarioLogin = listaUsuarios.get(i);

					//inicio de login
					login.setVisible(false);
					setResizable(false);
					setLocationRelativeTo(null);

					setLocationRelativeTo(null);;
					setTitle("MECANOMAFIA");

					//si el usr es "a" y contraseña es "a" abre panelAdmin 
					if (name.equals("a") && pass.equals("a")) {
			            login.setVisible(false);
			            setResizable(false);
			            setLocationRelativeTo(null);
			            setTitle("Panel Admin");
			            PanelAdmin panelAdmin2 = new PanelAdmin();
						panelAdmin2.setVisible(true);
						setVisible(true);
						add(panelAdmin2);


			            return;
			        }else {
			        	//Añadimos un panel de dificultades
						image = requestImage("src/imagenes/fondoLogIn.jpg");
						panelDificultades = new PanelDificultades(image);
						add(panelDificultades);
						btnEventoDificultades();
			        }
					
					

				}
			}
		});

	}

	//comprobar tamaño contraseña
	public void comprobarLength(String name, String pass) {
		
		//con el panel Admin hacemos un if para que filtre primero el usuario a contraseña a si no es ese usuario pasa al else if con los usuarios normales
		 if(pass.length() < 4 || pass.length() > 10 && name.length() > 5) {
				JOptionPane.showMessageDialog(null, "La contraseña debe tener minimo 4 carácteres y máximo 10" + "\n \n"  +"el usuario tiene que tener máximo 5 carácteres", "Contraseña o usario invalidos", 0);
			}
		
		
		
	}

	//pregunta si desea as alir y lanza ConfirmarSalir()
	public void preguntarCerrarApp() {
		try {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					Confirmarsalir();
					setVisible(true);
				}
			});

		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error inseperado", "Error", 0);
			System.exit(ABORT);
		}
	}
	
	//confirmar salida

	private void Confirmarsalir() {
	    
	    ImageIcon icon = new ImageIcon("src/imagenes/salida.jpg");
	    Image scaledImage = icon.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH);
	    ImageIcon scaledIcon = new ImageIcon(scaledImage);


	    int valor = JOptionPane.showConfirmDialog(
	        this, 
	        "¿Está seguro de cerrar la aplicación?", 
	        "Advertencia", 
	        JOptionPane.YES_NO_OPTION, 
	        JOptionPane.PLAIN_MESSAGE, 
	        scaledIcon
	    );
	    if (valor == JOptionPane.YES_OPTION) {
	        System.exit(0);
	    }
	}
	
	

	//escoger dificultades
	public void btnEventoDificultades() {

		panelDificultades.getBotonComenzar().addActionListener(e -> {
			dispose();
			setSize(pantallaCompleta);
			setLocationRelativeTo(null);
			setVisible(true);
			panelDificultades.setVisible(false);
			image = requestImage("src/imagenes/fondoJuego.jpg");

			//dificultad facil
			if(panelDificultades.getBotonFacil().isSelected()) {
				dificultades(true);
				JOptionPane.showMessageDialog(null, "benvinguts al meu programa de mecanografia\n"
						+ " 1.- Tienes un maximo de 5 errores permitidos.\n"
						+ " 2.- Tienes un tiempo máximo de 1 minuto. \n"
						+ " 3.- El contador empezará cuando le des a la primera tecla pulsada. \n"
						+ " 4.- Si superas el límite de tiempo o llegas al total de errores el juego finalizará. \n"
						+ " Pulsa Aceptar para comenzar."

						, "Instrucciones", 1);
			}
			//dificultad dificil

			if(panelDificultades.getBotonDificil().isSelected()) {
				dificultades(true);
				JOptionPane.showMessageDialog(null, "benvinguts al meu programa de mecanografia\n"
						+ " 1.- Tienes un maximo de 3 errores permitidos.\n"
						+ " 2.- Tienes un tiempo máximo de 3 minuto. \n"
						+ " 3.- El contador empezará cuando le des a la primera tecla pulsada. \n"
						+ " 4.- Si superas el límite de tiempo o llegas al total de errores el juego finalizará. \n"
						+ " Pulsa Aceptar para comenzar."

						, "Instrucciones", 1);
			}
		});
	}

	//facil true, dificil false
	public void dificultades(boolean flag) {
		panelPrincipal = new PanelPrincipal(flag, image, textos, usuarioLogin, estadisticas, listaUsuarios);
		panelPrincipal.setVisible(true);
		menuOpciones();
		botonBack();

		btnEventoFallo();
		btnTerminado();
		add(panelPrincipal);
	}

//volver
	public void botonBack() {
		panelPrincipal.getBtnVolver().addActionListener(e ->{
			panelPrincipal.setVisible(false);
			panelDificultades.setVisible(true);
			setSize(400,500);
			setLocationRelativeTo(null);
		});
	}

	// menu cambiar usaurio salir sin guardar
	public void menuOpciones() {

		panelPrincipal.getMenuCambiarUsuario().addActionListener(e -> {
			login.setVisible(true);
			setSize(400,500);
			setLocationRelativeTo(null);
			panelPrincipal.setVisible(false);
		});

		panelPrincipal.getSalirSinGuardar().addActionListener(e ->{
			Confirmarsalir();
		});
	}


	//si fallas sale boton y te llev al panel dificultades
	public void btnEventoFallo() {
		panelPrincipal.getViewStatsFail().getBtnVolver().addActionListener(e ->{

			setSize(400,500);
			panelDificultades.setVisible(true);
			panelPrincipal.getViewStatsFail().setVisible(false);
		});

		panelPrincipal.getViewStatsFail().getBtnSalir().addActionListener(e ->{
			Confirmarsalir();
		});
	}

	//boton panel terminado
	public void btnTerminado() {
		panelPrincipal.getTerminado().getBtnEnviarYsalir().addActionListener(e ->{
			EnviarMail.enviarCorreo(usuarioLogin);
			System.exit(0);
		});

		panelPrincipal.getTerminado().getBtnGuardayContinuar().addActionListener(e ->{
			EnviarMail.enviarCorreo(usuarioLogin);
			setSize(400,500);
			panelPrincipal.getTerminado().setVisible(false);
			panelDificultades.setVisible(true);
		});

		panelPrincipal.getTerminado().getBtnSalir().addActionListener(e ->{
			Confirmarsalir();
		});
	}


}