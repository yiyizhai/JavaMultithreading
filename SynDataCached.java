package demo1;

import java.util.Scanner;

class Processor extends Thread{
	//in some systems, or some implementations, the run code may cache the start 
	//value of running, so it's never gonna see the change of running and never gonna stop
	
	//private boolean running = true;
	//add a volatile to prevent the caching problem
	private volatile boolean running = true;
	
	public void run(){
		while(running){
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown(){
		running = false;
	}
}

public class SynDataCached {
	//basically there are two threads here, the main thread is writing to the running variable
	//because when it calls shutdown(), it calls it in the main thread
	//the thread proc is reading the running variable. 
	//ATT: the data running is the data in thread proc
	
	//when java try to optimize code, it doesn't allow thread to change the data in another thread
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press Ruturn to stop......");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
		
	}

}
