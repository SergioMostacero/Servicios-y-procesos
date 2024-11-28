package WindowBuilder.PanelPrinci;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

import GestorFichs.DatosFicheros;
import GestorFichs.Estadisticas;
import GestorFichs.Usuario;

import javax.swing.JTextArea;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.JLabel;
import java.awt.Font;


public class PanelPrincipal extends JPanel{



	private final static int MODO_FACIL = 0;
	private final static int MODO_DIFICIL = 1;

	private final static int TEMPORIZADOR_FACIL = 4;
	private final static int TEMPORIZADOR_DIFICIL = 3;

	private boolean flagDificultad;
	private Dimension screenSize;
	private PanelTeclado panelTeclado;
	private PanelEstadisticas panelEstadisticas;
	private PanelTexto panelTexto;
	private Image fondoJuego;

	private Timer time;

	private int contadorDeLetras;
	private ArrayList<String> textos;
	private HashMap<Character, JButton> mapBoton;
	private ArrayList<Usuario> listaUsuarios;

	Highlighter subrayado;
	HighlightPainter colorVerde;
	HighlightPainter colorRojo;
	private JTextArea textArea;

	private Usuario usuarioLogin;

	private JMenuBar menuBar;
	private JMenu menuOpciones;
	private JMenuItem menuCambiarUsuario;
	private JMenuItem menuSalirSinGuardar;
	private boolean flagVida = false;

	JButton btnVolver;

	private DatosFicheros dataField;

	private int ppm;
	private int errores;
	private int temporizadorSegundos;
	private int temporizadorMinutos;
	private Date diaActual;
	private PanelMostrarStatsFail viewStatsFail;
	private Estadisticas stats;
	private PanelFelicitaciones Terminado;
	private JLabel lblNewLabel;

	public PanelPrincipal(boolean flagDificultad, Image imagen, ArrayList<String> textos, Usuario usuarioLogin, ArrayList<Estadisticas> estadisticas, ArrayList<Usuario> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
		this.usuarioLogin = usuarioLogin;
		this.textos = textos;

		this.contadorDeLetras = 0;
		this.temporizadorMinutos = 0;
		this.temporizadorSegundos = 0;
		this.errores = 0;
		this.ppm = 0;

		this.diaActual = new Date();
		this.stats = new Estadisticas(usuarioLogin.getId(), flagDificultad, ppm, errores, MODO_FACIL, MODO_DIFICIL, diaActual);

		Terminado = new PanelFelicitaciones();
		mapBoton = new HashMap<>();
		dataField = new DatosFicheros(textos, estadisticas);
		viewStatsFail = new PanelMostrarStatsFail();
		viewStatsFail.setVisible(false);

		this.flagDificultad = flagDificultad;
		this.fondoJuego = imagen;

		setLayout(null);

		screenSize = Toolkit. getDefaultToolkit(). getScreenSize();
		setSize(screenSize);

		panelEstadisticas = new PanelEstadisticas();
		panelEstadisticas.setBackground(new Color(255, 255, 255));
		panelEstadisticas.setBounds(1553, 657, 217, 264);
		add(panelEstadisticas);

		panelTeclado = new PanelTeclado(mapBoton);
		panelTeclado.setBounds(575, 629, 780, 375);
		add(panelTeclado);

		panelTexto = new PanelTexto();
		panelTexto.getTextArea().setBounds(10, 0, 1685, 142);
		panelTexto.setSize(1695, 144);
		panelTexto.setLocation(115, 279);
		add(panelTexto);

		textArea = new JTextArea();
		textArea.setBounds(176, 473, 1322, 122);
		textArea.setFocusable(true);
		textArea.setLineWrap(true);

		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				textArea.setEnabled(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				textArea.setEnabled(false);
			}

		});

		add(textArea);

		//MENU
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1920, 22);
		add(menuBar);

		menuOpciones = new JMenu("Opciones");
		menuBar.add(menuOpciones);

		menuCambiarUsuario = new JMenuItem("Cambiar de usuario");
		menuOpciones.add(menuCambiarUsuario);

		menuSalirSinGuardar = new JMenuItem("Salir sin guardar");
		menuOpciones.add(menuSalirSinGuardar);
		
		btnVolver = new JButton("Volver");
		btnVolver.setBounds(0, 23, 89, 23);
		btnVolver.setFocusable(false);
		add(btnVolver);
		
		lblNewLabel = new JLabel("MECANOMAFIA");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 70));
		lblNewLabel.setBounds(627, 71, 603, 107);
		add(lblNewLabel);

		//subrayar letras segun vas escribiendo
		subrayado = panelTexto.getTextArea().getHighlighter();
		colorVerde = new DefaultHighlighter.DefaultHighlightPainter(Color.GREEN);
		colorRojo = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);

		imprimirTextoDificultad();

		
		//bucle para las estadisticas de cada usuario al principio 0 cuando vayan jugando ira subiendo
		for(int i = 0; i<listaUsuarios.size(); i++) {
			for(int j = 0; j<estadisticas.size(); j++) {
				if(listaUsuarios.get(i).getId().equals(estadisticas.get(j).getIdUsuario()) && listaUsuarios.get(i).getEstadisticas().size() < 2) {
					listaUsuarios.get(i).setEstadiscitas(estadisticas.get(j));
				}
			}
		}
		setVisible(true);
	}

	public void imprimirTextoDificultad() {


		//modo facil
		if(flagDificultad == true) {
			getPanelTexto().getTextArea().setText(textos.get(MODO_FACIL));
			comprobarTexto(MODO_FACIL,TEMPORIZADOR_FACIL, true, 5);
			contadorDeInicio(MODO_FACIL, TEMPORIZADOR_FACIL);
		}

		//mododificil
		if(flagDificultad == false) {
			getPanelTexto().getTextArea().setText(textos.get(MODO_DIFICIL));
			comprobarTexto(MODO_DIFICIL, TEMPORIZADOR_DIFICIL, false, 3);
			contadorDeInicio(MODO_DIFICIL, TEMPORIZADOR_DIFICIL);
		}
	}

	public void comprobarTexto(int dificultad, int temporizador, boolean flagDificultad, int cantidadErrores) {

		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

				//Usamos la clase Pattern que es un patron de búsqueda, en este caso buscamos en proceso de compilación las letras mayusculas y minusculas numeros y el espacio
				String cadena = Character.toString(e.getKeyChar());
				Pattern p = Pattern.compile("[a-zA-ZáéíóúÁÉÍÓÚñÑ0-9 .,\\n\\p{Space}]");


				//Usamos Matcher una vez creado pattern, le pasamos la cadena y el realiza la busqueda de nuestra expresion
				Matcher m = p.matcher(cadena);  
				if(!m.find()){
					e.consume();
				}
			}

			//cuando suelta tecla vuelta a color blanco
			@Override
			public void keyReleased(KeyEvent e) {

				if(mapBoton.get(e.getKeyChar()) != null) {
					panelTeclado.btnTeclado.get(e.getKeyChar()).setBackground(Color.WHITE);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			    textArea.setEditable(false);

			    try {
			        char keyChar = e.getKeyChar();
			        char expectedChar = textos.get(dificultad).charAt(textArea.getText().length());

			        // Comparar sin distinguir entre mayúsculas, minúsculas y normalizando caracteres con acentos
			        if (!Character.toString(expectedChar).equalsIgnoreCase(Character.toString(keyChar)) && flagVida == false) {
			            e.consume(); 
			        } else {
			            textArea.setEditable(true);
			            flagVida = true;

			            if ((temporizadorMinutos != 0 || temporizadorSegundos != 0)) {
			                time.start();
			            }

			            if (mapBoton.get(keyChar) != null && time.isRunning()) {
			                // Comparar caracteres esperados e ingresados directamente
			                if (expectedChar == keyChar) {
			                    panelTeclado.btnTeclado.get(keyChar).setBackground(Color.GREEN);
			                    subrayado.addHighlight(0, textArea.getText().length() + 1, colorVerde);
			                } else {
			                    panelTeclado.btnTeclado.get(keyChar).setBackground(Color.RED);
			                    subrayado.addHighlight(0, textArea.getText().length() + 1, colorRojo);
			                    errores++;
			                    panelEstadisticas.getTxtErrores().setText(String.valueOf(errores));
			                }
			            }

			            contadorDeLetras++;
			        }
			    } catch (StringIndexOutOfBoundsException sib) {
			        textArea.setEditable(false);
			        time.stop();
			        e.consume();
			    } catch (BadLocationException e1) {
			        textArea.setEditable(false);
			        panelTeclado.setEnabled(false);
			        time.stop();
			        e.consume();
			    }


			    mostrarPanelFallado(cantidadErrores);

			    // Comprobamos si el texto está completo y el temporizador no está en marcha
			    if ((textArea.getText().length() > textos.get(dificultad).length() - 1 && !time.isRunning())) {
			        mostrarPanelBien();

			        for (int i = 0; i < listaUsuarios.size(); i++) {
			            if (usuarioLogin.getId().equals(listaUsuarios.get(i).getId())) {
			                if (usuarioLogin.getEstadisticas().get(0).getDate().before(usuarioLogin.getEstadisticas().get(1).getDate())) {
			                    compararPorFechas(stats, i, 0);
			                    break;
			                } else {
			                    compararPorFechas(stats, i, 1);
			                    break;
			                }
			            }
			        }
			    }
			}

		});
	}

	//panel si terminas el nivel correctamente
	public void mostrarPanelBien() {
		Frame[] f = Frame.getFrames();

		Terminado.setVisible(true);
		setVisible(false);
		stats = new Estadisticas(usuarioLogin.getId(), flagDificultad, ppm, errores, temporizadorMinutos, temporizadorSegundos, diaActual);
		Terminado.getTextStats().setText("Has terminado el nivel. \n Aqui tienes tus estádisticas "+ usuarioLogin.getNombre() + " \n\n" + stats.toString());

		f[0].setSize(800, 400);
		f[0].setLocationRelativeTo(null);
		f[0].add(Terminado);

	}

	public void mostrarPanelFallado(int cantidadErrores) {
		//si se acaba el ttiempo 
		if(temporizadorMinutos == 0 && temporizadorSegundos == 0 || errores > cantidadErrores) {

			//hacemos referencia al frame principal
			Frame[] f = Frame.getFrames();

			stats = new Estadisticas(usuarioLogin.getId(), flagDificultad, ppm, errores, temporizadorMinutos, temporizadorSegundos, diaActual);
			setVisible(false);
			viewStatsFail.setVisible(true);
			viewStatsFail.getTextArea().setText(stats.toString());

			f[0].setSize(500, 500);
			f[0].setLocationRelativeTo(null);
			f[0].add(viewStatsFail);

		}
	}

	//Comparamos con fechas y sustituimos la mas antigua por la más nueva
	public void compararPorFechas(Estadisticas stats, int index, int posicion) {
		usuarioLogin.getEstadisticas().set(posicion, stats);
		listaUsuarios.get(index).getEstadisticas().set(posicion, stats);
		dataField.sobreescribirDatosStats(listaUsuarios, "src/GestorFichs/estadisticas.txt");
	}

	public void contadorDeInicio(int dificultad, int tiempoMinutos) {

		temporizadorMinutos = tiempoMinutos;
		temporizadorSegundos = 1;

		if(textArea.getText().length() == 0){
			time = new Timer(1000, e ->{

				temporizadorSegundos--;

				ppm = contadorDeLetras*60/(60-temporizadorSegundos);
				panelEstadisticas.getTxtPpm().setText(String.valueOf(ppm));

				panelEstadisticas.getTxtTiempo().setText(temporizadorMinutos + " : " + temporizadorSegundos);

				//en caso de que el tiempo llegue a 0
				if(temporizadorMinutos == 0 && temporizadorSegundos == 0) {

					time.stop();
					textArea.setEditable(false);

				}else if(temporizadorSegundos == 0) {
					temporizadorMinutos--;	
					temporizadorSegundos = 60;
				}				
			});
		}
	}

	/*GETTER AND SETTER*/
	public PanelTeclado getPanelTeclado() {
		return panelTeclado;
	}
	public PanelFelicitaciones getTerminado() {
		return Terminado;
	}
	public PanelMostrarStatsFail getViewStatsFail() {
		return viewStatsFail;
	}
	public JButton getBtnVolver() {
		return btnVolver;
	}
	public JMenuItem getMenuCambiarUsuario() {
		return menuCambiarUsuario;
	}
	public JMenuItem getSalirSinGuardar() {
		return menuSalirSinGuardar;
	}
	public PanelTexto getPanelTexto() {
		return panelTexto;
	}
	public void paintComponent(Graphics g) {
		g.drawImage(fondoJuego,0,0,getWidth(),getHeight(), null);
	}
}
