package GestorFichs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class DatosFicheros {

    // listas para almacenar usuarios, textos y estadísticas
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<String> textos;
    private ArrayList<Estadisticas> estadisticas;

    // formato para manejo de fechas
    private SimpleDateFormat formato;
    private Date fechaDate;

    // constructor para inicializar las listas
    public DatosFicheros(ArrayList<Usuario> listaUsuarios, ArrayList<String> textos, ArrayList<Estadisticas> estadisticas) {
        this.estadisticas = estadisticas;
        this.listaUsuarios = listaUsuarios;
        this.textos = textos;
    }

    // constructor alternativo cuando no se proporcionan usuarios
    public DatosFicheros(ArrayList<String> textos, ArrayList<Estadisticas> estadisticas) {
        this.textos = textos;
        this.estadisticas = estadisticas;
    }

    // método para comprobar la existencia de los archivos necesarios
    public void comprobarFile() {
        File usuarioFile = new File("src/GestorFichs/usuarios.txt");
        File estadisticasFile = new File("src/GestorFichs/estadisticas.txt");
        File textosFiles = new File("src/GestorFichs/textos.txt");

        // si algún archivo no existe, muestra error y detiene el programa
        if (!(usuarioFile.exists() && estadisticasFile.exists() && textosFiles.exists())) {
            JOptionPane.showMessageDialog(null, "error no se han detectado los archivos", "error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // método para leer y cargar datos de un archivo de usuarios
    public void accederFicheroUsuario(String fichero) {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String leerDatos;

            // lee el archivo línea por línea y agrega los datos a la lista de usuarios
            while ((leerDatos = br.readLine()) != null) {
                String[] partes = leerDatos.split(";");
                listaUsuarios.add(new Usuario(partes[0], partes[1], partes[2], partes[3]));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error al leer los usuarios", "error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    // método para leer y cargar datos de estadísticas
    public void accederDatosEstadisticas(String fichero) {
        formato = new SimpleDateFormat("dd-MM-yyyy-HH::mm:ss");

        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String leerStats;

            // lee el archivo línea por línea y agrega las estadísticas a la lista
            while ((leerStats = br.readLine()) != null) {
                String[] partes = leerStats.split(";");
                fechaDate = formato.parse(partes[6]);

                estadisticas.add(new Estadisticas(
                    partes[0],
                    Boolean.parseBoolean(partes[1]),
                    Integer.parseInt(partes[2]),
                    Integer.parseInt(partes[3]),
                    Integer.parseInt(partes[4]),
                    Integer.parseInt(partes[5]),
                    fechaDate
                ));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error en la lectura de estadísticas", "error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "error de formato en las fechas, cerrando el programa", "error de formato", JOptionPane.ERROR_MESSAGE);
            System.exit(9);
        }
    }

    // método para sobrescribir datos de estadísticas en un archivo
    public void sobreescribirDatosStats(ArrayList<Usuario> listaUsuarios, String ruta) {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy-HH::mm:ss");

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta, false))) {
            // recorre los usuarios y sus estadísticas para escribirlas en el archivo
            for (Usuario usuario : listaUsuarios) {
                for (Estadisticas estadistica : usuario.getEstadisticas()) {
                    bw.write(estadistica.getIdUsuario() + ";");
                    bw.write(estadistica.isDificultad() + ";");
                    bw.write(estadistica.getPpm() + ";");
                    bw.write(estadistica.getError() + ";");
                    bw.write(estadistica.getTiempoMinutos() + ";");
                    bw.write(estadistica.getTiempoSegundos() + ";");
                    bw.write(formato.format(estadistica.getDate()));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error al escribir las estadísticas", "error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // método para leer y separar los datos de los textos
    public void leerDatosTexto(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String lineaTexto;

            // lee el archivo línea por línea y separa los textos por niveles
            while ((lineaTexto = br.readLine()) != null) {
                String[] partes = lineaTexto.split(";");
                textos.add(partes[0]); // texto fácil
                textos.add(partes[1]); // texto difícil
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "error al leer los textos", "error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
}
