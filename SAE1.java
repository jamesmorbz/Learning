/* **************************************
  Name : James Moreby
  Date : 12/10/2021
  Version: 1

    This SAE (Short-Assessed Exercise) is used
    to show that you have a grasp of simple print
    commands in java as well as an understanding
    of how methods/functions are implemented in java

  *************************************** */

  public class SAE1 {

    public static void letterJ() {
        System.out.println("JJJJJJJ");
        System.out.println("   J   ");
        System.out.println("   J   ");
        System.out.println("   J   ");
        System.out.println("JJJJ   ");
        System.out.println("       ");
    }

    public static void letterM() {
        System.out.println("M     M");
        System.out.println("M M M M");
        System.out.println("M  M  M");
        System.out.println("M     M");
        System.out.println("M     M");
    }
    
    public static void combinedJM() {
        letterJ();
        letterM();
    }
    public static void main(String[] args) {
        combinedJM();
    }
 }