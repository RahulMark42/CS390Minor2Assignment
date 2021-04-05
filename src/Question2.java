//Exception Subclass
class MyException extends Exception{
	public MyException() {
		super("This is an exception and cannot be handled using integer datatype");
	}
}
class ArrayException extends Exception{
	public ArrayException() {
		super("This is an exception and cannot be handled using this length of array");
	}
}
public class Question2 {
	public static void main(String[] args) {
		int a = 8;
		int b = 10;
		int c = a/b;
		int[] array = {1,2,3,4,5};
		try {
			for(int i = 0; i <= 5; i++) {
				try{
					if(i < 5) {
						System.out.println(array[i] + " ");
					}
					else {
						throw new ArrayException();
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			if(c == 0) {
				throw new MyException();
			}
			else {
				System.out.println(c);
			}
		}
		catch(MyException e) {
			System.out.println(e.getMessage());
		}
	}
}
