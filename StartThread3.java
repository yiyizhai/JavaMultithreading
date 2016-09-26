package demo1;

public class StartThread3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new Runnable() {
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
		});
		t1.start();
	}

}
