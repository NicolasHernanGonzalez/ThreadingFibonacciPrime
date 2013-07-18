package ar.testing;

import java.io.IOException;
import java.io.Writer;

public class FIbonacciNumberGeneratorThread implements Runnable {

	private Writer writer;
	private int from;
	private int to;
	
	public FIbonacciNumberGeneratorThread(int from, int to,Writer writer) throws IOException {
		super();
		this.from = from;
		this.to = to;
		this.writer = writer;
	}
	
	@Override
	public void run() {
		
		try {
			writer.write(from);
			
			int aux = 1;
			
			writer.write(aux);
			
			int aux2 = 0; 
			
			
			while (from < to) {
				
				aux2 = aux + from;
				if (aux2 <= to) {
					writer.write(aux2);
				}
				else {
					break;
				}
				from = aux;
				aux = aux2;
			}
			
			writer.close();
			
		} catch (IOException e) {
		}
		catch (Exception e) {
		}
	}
	
}
