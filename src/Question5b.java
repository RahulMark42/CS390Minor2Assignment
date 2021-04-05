class Deadlock2{
	String resource1 = "Printer";
	String resource2 = "Scanner";
	
	Thread t1 = new Thread() {
		public void run () {
			synchronized (resource1) {
				try {
					System.out.println(Thread.currentThread().getName() + " locked with " + resource1);
					Thread.sleep(100);
				}
				catch (Exception e) {
				}
				synchronized (resource2) {
					System.out.println(Thread.currentThread().getName() + " locked with " + resource2);
				}
			}
		
		}
	};

	Thread t2 = new Thread() {
		public void run () {
			synchronized (resource2) {
				try {
					System.out.println(Thread.currentThread().getName() + " locked with " + resource2);
				}
				catch (Exception e) {
				}
			}
			synchronized (resource1) {
				System.out.println(Thread.currentThread().getName() + " locked with " + resource1);
			}
		}		
	};
}
public class Question5b {
	
	public static void main(String[] args) {
		Deadlock2 d = new Deadlock2();
		
		d.t1.start();
		d.t2.start();
	}

}

