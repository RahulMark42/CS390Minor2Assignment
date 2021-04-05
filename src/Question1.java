import java.io.*;

class Question1 {
  public static void File() throws IOException {

    // code that may generate IOException
    File newFile = new File("test.txt");
    FileInputStream stream = new FileInputStream(newFile);
  }

  public static void main(String[] args) {
    try {
      File();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }
}



