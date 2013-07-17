package ar.testing;

import java.io.IOException;
import java.io.PipedWriter;

public class FIbonacciNumberGeneratorThread implements Runnable {

	private PipedWriter pw;
	private int from;
	private int to;
	
	public FIbonacciNumberGeneratorThread(int from, int to) throws IOException {
		super();
		this.from = from;
		this.to = to;
		this.pw = new PipedWriter();
	}
	
	@Override
	public void run() {
		
		try {
			pw.write(from);
			
			int aux = 1;
			
			pw.write(aux);
			
			int aux2 = 0; 
			
			
			while (from < to) {
				
				aux2 = aux + from;
				if (aux2 <= to) {
					pw.write(aux2);
//					System.out.println("Inserting = " + aux2);
				}
				else {
//					System.out.println("Last fibo number = " + aux);
					break;
				}
				from = aux;
				aux = aux2;
			}
			
			pw.close();
			
		} catch (IOException e) {
		}
		catch (Exception e) {
		}
	}

	public PipedWriter getPw() {
		return pw;
	}
	
}
