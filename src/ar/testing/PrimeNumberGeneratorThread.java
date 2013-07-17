package ar.testing;

import java.io.IOException;
import java.io.PipedWriter;


public class PrimeNumberGeneratorThread implements Runnable {

	private int from;
	
	private int to;
	
	private PipedWriter pw;
	
	
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

	public PrimeNumberGeneratorThread(int from, int to) throws IOException {
		super();
		this.from = from;
		this.to = to;
		this.pw = new PipedWriter();
	}
	
	@Override
	public void run() {
		
		try {
			for (int i = from; i < to; i++) {
				if (isPrime(i)) {
					pw.write(i);
//					System.out.println("prime number = "+  i);
				}
			}
			
//			System.out.println("Finsh the calculation..");
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
