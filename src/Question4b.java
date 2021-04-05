class Product{
	int num;
	boolean stateOfValue = false;
	
	public synchronized void get() {
		//while(!stateOfValue) {
			//try{
				//wait();
			//} catch(Exception e) {}
		//}
		System.out.println("Get : " + num);
		stateOfValue = false;
		//notify();
		
	}
	
	public synchronized void set(int n) {
		//while(stateOfValue) {
			//try{
				//wait();
			//} catch(Exception e) {}
		//}
		this.num = n;
		System.out.println("Set : " + num);
		stateOfValue = true;
		//notify();
	}
	
}
class Producer implements Runnable{
	Product p;
	Producer(Product p){
		this.p = p;
		Thread t = new Thread(this, "Producer");
		t.start();
	}
	
	public void run() {
		int i = 0;
		while(i < 1000) {
			p.set(i++);
			try {Thread.sleep(50);} catch(Exception e) {}
		}
	}
	
}

class Consumer implements Runnable{
	Product p;
	Consumer(Product p){
		this.p = p;
		Thread t = new Thread(this, "Consumer");
		t.start();
	}
	public void run() {
		int i = 0;
		while(i < 1000) {
			p.get();
			try {Thread.sleep(500);} catch(Exception e) {}
		}
	}
	
}
public class Question4b {
	public static void main(String[] args) {
		Product p = new Product();
		new Producer(p);
		new Consumer(p);
	}

}
