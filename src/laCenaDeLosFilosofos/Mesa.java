package laCenaDeLosFilosofos;

public class Mesa {

	public boolean [] tenedores;

	public Mesa (int numTenedor) {

		this.tenedores = new boolean [numTenedor];

	}

	public int tenedorDerecha(int filosofo) {
		
		if(filosofo == 0) {
			return filosofo = tenedores.length - 1;
		}
		else {
			return filosofo--;
		}			
	}

	public int tenedorIzquierda (int filosofo) {
		
		return filosofo;
	}
	
	public synchronized void cogerTenedores(Filosofo f1) {
		
		while (tenedores[f1.getTenIzq()] == false || tenedores[f1.getTenDer()] == false) {
			
			try {
				wait();
			} catch (InterruptedException e) {}
			
		}
		
		tenedores[f1.getTenIzq()] = false;
		tenedores[f1.getTenDer()] = false;
		notifyAll();		
	}
	
	public synchronized void dejarTenedores(Filosofo filosofo) {
		
		tenedores[filosofo.getTenIzq()] = true;
		tenedores[filosofo.getTenDer()] = true;
		notifyAll();		
	}
	
}
