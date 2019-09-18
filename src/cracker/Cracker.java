package cracker;

/**
 *
 * @author bruno.bencke
 */

public class Cracker {
    
  public static int partial, complete, solution;

  public static void abcde(int n, String s) {
  
    if (n == 0) { // STOP CASE
      complete++;
      
      try {
        Process p = Runtime.getRuntime().exec("unzip -P " + s + " -t hidden.zip");
        p.waitFor();
        if (p.exitValue() == 0) {
          System.out.println("FOUND");
          System.out.println(s);
        }
      }
      catch (Exception e) {
        System.out.println(e);
      }
    }
    else { // GENERAL CASE
      partial++;
      abcde(n - 1, s + "a");
      abcde(n - 1, s + "b");
      abcde(n - 1, s + "c");
      abcde(n - 1, s + "d");
      abcde(n - 1, s + "e");
    }
  }

  public static void main(String[] args) {
    abcde(5, "");
    //System.out.println("partial:  " + partial);
    System.out.println("complete: " + complete);
    //System.out.println("solution: " + solution);
  }
}
