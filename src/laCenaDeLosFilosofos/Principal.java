package laCenaDeLosFilosofos;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Mesa m = new Mesa(5);
		for (int i = 0; i < 5; i++) {
			m.tenedores[i] = true;
		}

		Filosofo f1 = new Filosofo(m,1);
		Filosofo f2 = new Filosofo(m,2);
		Filosofo f3 = new Filosofo(m,3);
		Filosofo f4 = new Filosofo(m,4);
		Filosofo f5 = new Filosofo(m,5);
		
		f1.start();
		f2.start();
		f3.start();
		f4.start();
		f5.start();
	}
}