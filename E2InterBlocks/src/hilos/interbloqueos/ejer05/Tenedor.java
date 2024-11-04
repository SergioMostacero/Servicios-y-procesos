package hilos.interbloqueos.ejer05;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tenedor {
	private final Lock lock = new ReentrantLock();
	
	public void coger() {
		lock.lock();
	}
	public void soltar() {
		lock.unlock();
	}

}
