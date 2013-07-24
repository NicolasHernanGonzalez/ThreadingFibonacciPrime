package ar.testing;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.ArrayList;

public class MainThread {

	static final int FROM = 0; 
	static final int TO = 100000;
	
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.out.println("Started to run");
		
		ArrayList<Integer> bothTypeNumberList;
		PipedWriter primeWriter = new PipedWriter();
		PipedWriter fibonacciWriter = new PipedWriter();
		
		PipedReader primeReader = new PipedReader(primeWriter);
		PipedReader fiboReader = new PipedReader(fibonacciWriter);
		
		PrimeNumberGeneratorThread prime = new PrimeNumberGeneratorThread(FROM, TO,primeWriter);
		Thread myPrimeThread = new Thread(prime);
		myPrimeThread.start();
		
		FIbonacciNumberGeneratorThread fibo = new FIbonacciNumberGeneratorThread(FROM, TO,fibonacciWriter);
		Thread myFibonacciThread = new Thread (fibo);
		myFibonacciThread.start();
		
		bothTypeNumberList = genereteBothTypeNumbersList(primeReader,fiboReader);
		
		myPrimeThread.interrupt();
		myFibonacciThread.interrupt();
		primeReader.close();
		fiboReader.close();
		
		printList(bothTypeNumberList);
		
	}

	private static void printList(ArrayList<Integer> bothTypeNumberList) {
		
		System.out.println("both type numbes : ");
		
		for (Integer integer : bothTypeNumberList) {
			System.out.println(integer);
		}
		
	}

	private static ArrayList<Integer> genereteBothTypeNumbersList(PipedReader primeReader,
			PipedReader fiboReader) throws IOException {
		
			ArrayList<Integer> list = new ArrayList<Integer>();
			int primeNumber = primeReader.read();
			int fiboNumber = fiboReader.read();
			
			while ((fiboNumber != -1) && (primeNumber != -1)) {
				
				if (primeNumber == fiboNumber) {
					list.add(primeNumber);
					primeNumber = primeReader.read();
					fiboNumber = fiboReader.read();
				} 
				  else if (primeNumber < fiboNumber) {
					primeNumber = primeReader.read();
					
				} else if (primeNumber > fiboNumber){
					fiboNumber = fiboReader.read();
				}
			}
			
			return list;
	}

}