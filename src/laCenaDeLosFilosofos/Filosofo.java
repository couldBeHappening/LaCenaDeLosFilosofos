package laCenaDeLosFilosofos;

public class Filosofo extends Thread {

	private Mesa mesa;
	private int filosofo;
	private int comensal;
	private int tenDer;
	private int tenIzq;

	public Filosofo(Mesa mesa, int comensal) {

		this.mesa = mesa;
		this.comensal = comensal;
		this.filosofo = comensal - 1;
		this.tenDer = mesa.tenedorDerecha(this.filosofo);
		this.tenIzq = mesa.tenedorIzquierda(this.filosofo);
	}
	
	public int getTenDer() {
		return tenDer;
	}
	
	public int getTenIzq() {
		return tenIzq;
	}

	public void pensando() {

		System.out.println("El filosofo " + comensal + " está pensando");

		try {
			sleep((long)(Math.random()*4000));
		} catch (InterruptedException e) {}

	}

	public void comiendo() {

		System.out.println("El filosofo " + comensal + " quiere comer");
		mesa.cogerTenedores(this);
		System.out.println("El filosofo " + comensal + " está comiendo");

		try {
			sleep((long)(Math.random()*4000));
		} catch (InterruptedException e) {}
		
		System.out.println("El filosofo " + comensal + " ha terminado de comer");
		mesa.dejarTenedores(this);	
		
	}

	@Override
	public void run() {
		
		this.pensando();
		this.comiendo();
		
	}
	
	
}