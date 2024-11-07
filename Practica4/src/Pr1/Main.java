package Pr1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    private static final String hashcoded = "b221d9dbb083a7f33428d7c2a3c3198ae925614d70210e28716ccaa7cd4ddb79";
    private static final int numHilos = 4;

    public static class Hackeo implements Callable<String> {
        private final char startChar;
        private final char endChar;
        private final byte[] hashBytes;

        public Hackeo(char startChar, char endChar, byte[] hashBytes) {
            this.startChar = startChar;
            this.endChar = endChar;
            this.hashBytes = hashBytes;
        }

        @Override
        public String call() {
            for (char c1 = startChar; c1 <= endChar; c1++) {
                for (char c2 = 'a'; c2 <= 'z'; c2++) {
                    for (char c3 = 'a'; c3 <= 'z'; c3++) {
                        for (char c4 = 'a'; c4 <= 'z'; c4++) {
                            String palabra = "" + c1 + c2 + c3 + c4;
                            byte[] hash = getHash(palabra);
                            if (Arrays.equals(hash, hashBytes)) {
                                return palabra;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        byte[] targetHashBytes = hexStringToByteArray(hashcoded);
        ExecutorService executor = Executors.newFixedThreadPool(numHilos);
        List<Future<String>> resultados = new ArrayList<>();

  
        int letrasPorHilo = 26 / numHilos;
        char[] letras = "abcdefghijklmnopqrstuvwxyz".toCharArray();

        for (int i = 0; i < numHilos; i++) {
            char startChar = letras[i * letrasPorHilo];
            char endChar = (i == numHilos - 1) ? 'z' : letras[(i + 1) * letrasPorHilo - 1];
            resultados.add(executor.submit(new Hackeo(startChar, endChar, targetHashBytes)));
        }

        executor.shutdown();

        try {

            String resultado = null;
            for (Future<String> futuro : resultados) {
                resultado = futuro.get();
                if (resultado != null) {
                    System.out.println("Palabra encontrada: " + resultado);
                    executor.shutdownNow();
                    break;
                }
            }
            if (resultado == null) {
                System.out.println("Palabra no encontrada.");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static byte[] hexStringToByteArray(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i+1), 16));
        }
        return data;
    }


    public static byte[] getHash(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            return digest.digest(text.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
