package ar.testing;

import java.io.IOException;
import java.io.Writer;


public class PrimeNumberGeneratorThread implements Runnable {

	private int from;
	
	private int to;
	
	private Writer writer;
	
	
	public boolean isPrime(int number) {
		
		long counter = 2;

		while (counter < number) {
			if (number % counter != 0) {
				counter++;
			} else
				return false;
		}
		return true;
	}

	public PrimeNumberGeneratorThread(int from, int to,Writer writer) throws IOException {
		super();
		this.from = from;
		this.to = to;
		this.writer = writer;
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = from; i < to; i++) {
				if (isPrime(i)) {
					writer.write(i);
				}
			}
			writer.close();
			
		} catch (IOException e) {
		}
		catch (Exception e) {
		}
	}
}
