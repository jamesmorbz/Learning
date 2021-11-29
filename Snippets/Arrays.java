package Snippets;

public class Arrays {

    public static void CreatingArrays() {
        String[] cars = {"Volvo", "BMW", "Ford", "Mazda"}; // initialization and delaration of array
        System.out.println("Printing List of Cars: " + java.util.Arrays.toString(cars) + ". This list has " + cars.length + " Elements"); // Printing entire list of array + Array Length
        for (int i = 0; i < cars.length; i++) { // Iterating through list printing out elements individually
            System.out.println(cars[i]);
          }
    }
    public static void ChangingArrays() {
        int Num[] = {10, 20, 30, 40}; // initialization and delaration of array
        System.out.println("Printing List of Numbers: " + java.util.Arrays.toString(Num));
        Num[1] = 50; // Changing value in Index 1 - This overwrites, doesn't append - You can't append arrays, they are not dynamic
        Num[3] = 1; // Changing value in Index 3 - This overwrites, doesn't append - You can't append arrays, they are not dynamic
        System.out.println("After Changing Numbers " + java.util.Arrays.toString(Num));
    }

    public static void ArrayBackwards() {
        System.out.println();
        System.out.println("Array Manipulation:");
        System.out.println();
        Integer[] intArray = {10, 20, 30, 40, 50, 60, 70, 80, 90};
     
        System.out.println("Original Array:");  //print array starting from first element
        for(int i=0;i<intArray.length;i++)
                System.out.print(intArray[i] + "  ");
            
        System.out.println();
            
        System.out.println("Original Array printed in reverse order:"); //print array starting from last element
                for(int i=intArray.length-1;i>=0;i--)
                System.out.print(intArray[i] + "  ");
    }
    public static void main(String[] args) {
        CreatingArrays();
        ChangingArrays();
        ArrayBackwards();
    }
}