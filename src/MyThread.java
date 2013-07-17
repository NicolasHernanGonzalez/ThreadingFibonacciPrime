public class MyThread implements Runnable {

	@Override
	public void run() {
		MainThread.ThreadMessage("Running");
		try {
			
			for (int i = 0; i < 10; i++) {
				MainThread.ThreadMessage("doing some things");
				Thread.sleep(1000);
			}
			
		} catch (InterruptedException e) {
			MainThread.ThreadMessage("Interrupted");
		}
		
	}
	
}