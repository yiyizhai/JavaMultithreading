package demo1;

class Runner2 implements Runnable {
	public void run(){
		for(int i = 0; i < 10; i++){
		    System.out.println("Hello " + i);
		    //100 milli sec
		    try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class StartThread2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runner2());
		Thread t2 = new Thread(new Runner2());
		t1.start();
		t2.start();
	}

}
