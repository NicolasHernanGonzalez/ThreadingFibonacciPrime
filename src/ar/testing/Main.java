package ar.testing;

import java.io.IOException;
import java.io.PipedReader;

public class Main {

	static final int FROM = 0; 
	static final int TO = 100000;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Started to run");
		
		PrimeNumberGeneratorThread prime = new PrimeNumberGeneratorThread(FROM, TO);
		Thread myPrimeThread = new Thread(prime);
		
		FIbonacciNumberGeneratorThread fibo = new FIbonacciNumberGeneratorThread(FROM, TO);
		Thread myFibonacciThread = new Thread (fibo);
		
		PipedReader primeReader = new PipedReader(prime.getPw());
		PipedReader fiboReader = new PipedReader(fibo.getPw());
		
		myFibonacciThread.start();
		
		myPrimeThread.start();
		myFibonacciThread.join();
		
		int primeNumber = primeReader.read();
		
		int fiboNumber = fiboReader.read();
		
//		while (fiboNumber != -1) {
//			System.out.println("Fibonacci number testing : " + fiboNumber);
//			fiboNumber = fiboReader.read();
//		}
		
		System.out.println("In both lists: ");
		while ((fiboNumber != -1) && (primeNumber != -1)) {
			
//			System.out.println("Time : " + System.currentTimeMillis() + " status : " + primeNumber + " " + fiboNumber );
			
			if (primeNumber == fiboNumber) {
				System.out.println(primeNumber);
				primeNumber = primeReader.read();
				fiboNumber = fiboReader.read();
			} 
			  else if (primeNumber < fiboNumber) {
				primeNumber = primeReader.read();
				
			} else if (primeNumber > fiboNumber){
				fiboNumber = fiboReader.read();
			}
		}
		
		myPrimeThread.interrupt();
		myFibonacciThread.interrupt();
		primeReader.close();
		fiboReader.close();
	}
}