class Thread1 extends Thread{
	public Thread1() {
		super("Thread1");
	}
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				System.out.println("Hi " + i +", Priority is " + Thread.currentThread().getPriority());
				System.out.println();
				Thread.sleep(500);
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}
class Thread2 extends Thread{
	public Thread2() {
		super("Thread2");
	}
	public void run() {
		for(int i = 0; i < 5; i++) {
			try {
				System.out.println("Hello " + i +", Priority is " + Thread.currentThread().getPriority());
				System.out.println();
				Thread.sleep(500);
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}

class Thread3 implements Runnable{
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("How are you " + i +", Priority is " + Thread.currentThread().getPriority());
			System.out.println();
			try {
				Thread.sleep(500);
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
}
public class Question3{
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		Thread t3 = new Thread(new Thread3());

		try {
			t1.setPriority(1);
			t2.setPriority(6);
			t3.setPriority(10);
			t1.start();
			Thread.sleep(50);
			t2.start();
			Thread.sleep(50);
			t3.start();
			Thread.sleep(50);
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		
	}

}
