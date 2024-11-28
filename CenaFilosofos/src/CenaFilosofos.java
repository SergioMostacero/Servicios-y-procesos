public class CenaFilosofos {

    public static void main(String[] args) {
        final int NUM_FILOSOFOS = 5; // Número de filósofos y tenedores
        Tenedor[] tenedores = new Tenedor[NUM_FILOSOFOS];
        Thread[] filosofos = new Thread[NUM_FILOSOFOS];

        // Crear tenedores
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            tenedores[i] = new Tenedor();
        }

        // Crear y comenzar hilos de filósofos
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Tenedor tenedorIzquierdo = tenedores[i];
            Tenedor tenedorDerecho = tenedores[(i + 1) % NUM_FILOSOFOS];
            filosofos[i] = new Thread(new Filosofo(i, tenedorIzquierdo, tenedorDerecho));
            filosofos[i].start();
        }
    }
}
