package hilos.interbloqueos.ejer05;

public class Filosofo{
	
	public void pensar() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();		
		}
	}
	public void comer() {

	}

	public static void main(String[] args) {
		Object tenedor= new Object();
		
		Runnable Filosofo=()->{
			String NombreFilosofo=Thread.currentThread().getName();
			
			
		};
		
		Thread Filosofo1= new Thread(Filosofo, "Filosofo 1");
		Thread Filosofo2= new Thread(Filosofo, "Filosofo 2");
		Thread Filosofo3= new Thread(Filosofo, "Filosofo 3");
		Thread Filosofo4= new Thread(Filosofo, "Filosofo 4");
		Thread Filosofo5= new Thread(Filosofo, "Filosofo 5");
	}

}
