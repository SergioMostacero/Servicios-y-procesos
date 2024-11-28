public class Filosofo implements Runnable {
    private final int id;
    private final Tenedor tenedorIzquierdo;
    private final Tenedor tenedorDerecho;

    public Filosofo(int id, Tenedor tenedorIzquierdo, Tenedor tenedorDerecho) {
        this.id = id;
        this.tenedorIzquierdo = tenedorIzquierdo;
        this.tenedorDerecho = tenedorDerecho;
    }

    @Override
    public void run() {
        try {
            while (true) {
                pensar();
                tomarTenedores();
                comer();
                soltarTenedores();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Filósofo " + id + " ha sido interrumpido.");
        }
    }

    private void pensar() throws InterruptedException {
        System.out.println("Filósofo " + id + " está pensando.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void tomarTenedores() throws InterruptedException {
        System.out.println("Filósofo " + id + " tiene hambre y quiere comer.");
        if (id % 2 == 0) { // Alternar para evitar interbloqueo
            tenedorIzquierdo.tomar();
            System.out.println("Filósofo " + id + " ha tomado el tenedor izquierdo.");
            tenedorDerecho.tomar();
            System.out.println("Filósofo " + id + " ha tomado el tenedor derecho.");
        } else {
            tenedorDerecho.tomar();
            System.out.println("Filósofo " + id + " ha tomado el tenedor derecho.");
            tenedorIzquierdo.tomar();
            System.out.println("Filósofo " + id + " ha tomado el tenedor izquierdo.");
        }
    }

    private void comer() throws InterruptedException {
        System.out.println("Filósofo " + id + " está comiendo.");
        Thread.sleep((long) (Math.random() * 1000));
    }

    private void soltarTenedores() {
        tenedorIzquierdo.soltar();
        tenedorDerecho.soltar();
        System.out.println("Filósofo " + id + " ha soltado los tenedores.");
    }
}
