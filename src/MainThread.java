
public class MainThread {

	public static void ThreadMessage(String message) {
		System.out.format("%s %s%n",Thread.currentThread().getName(),message); 
	}
	
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		Thread myThread = new Thread(new MyThread());
		ThreadMessage("Started to run");
		myThread.start();
		ThreadMessage("Doing some thing");
//		Thread.sleep(2000);
//		myThread.interrupt();
		myThread.join();
		ThreadMessage("Done!");
	}
}