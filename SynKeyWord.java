package demo1;

public class SynKeyWord {
	private int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SynKeyWord sk = new SynKeyWord();
		sk.doWork();
	}
	
	//every object in java has a monitor lock (mutex)
	//so adding synchronized makes every call require a lock first
	public synchronized void increment(){
		count++;
	}
	
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0; i < 10000; i++){
					//count++;
					increment();
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable(){
			public void run(){
				for(int i = 0; i < 10000; i++){
					//count++;
					increment();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		//only add join still can't really give us the right count number
		//count++: not atomic, there are 3 steps: get the count, increment, and store the new value back
		//both threads read and write the count. thread 1 can read it as 100 and thread2 also
		//before thread1 increment it, thread2 may increment it twice, but after t1 write it again, count becomes 101
		//so some increments will be skipped
		//need to make it atomic ==> change count++ as synchronized
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//here the printed count number is always 0
		//the mechanism is the main thread starts
		//t1 starts, t2 starts, then print, then the run() begins to run
		//we want to wait for t1 and t2 and then print ==> add join()
		System.out.println("Count is " + count);
	}

}
