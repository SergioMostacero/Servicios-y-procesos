
import java.util.concurrent.Semaphore;

public class Tenedor {
    private final Semaphore semaforo = new Semaphore(1);

    public void tomar() throws InterruptedException {
        semaforo.acquire(); // Adquirir el tenedor
    }

    public void soltar() {
        semaforo.release(); // Liberar el tenedor
    }
}
