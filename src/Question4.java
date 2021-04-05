class Count{
	int count;
	public synchronized void increase() {
		count++;
	}
}
public class Question4 	{
	public static void main(String[] args) throws Exception{
		Count c = new Count();
		Thread t1 = new Thread(new Runnable(){
			public void run() {
				for(int i = 0; i < 10000; i++) {
					c.increase();
				}
			} 
		});
		Thread t2 = new Thread(new Runnable(){
			public void run() {
				for(int i = 0; i < 10000; i++) {
					c.increase();
				}
			}
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Count final value is: "+ c.count);
	}

}

