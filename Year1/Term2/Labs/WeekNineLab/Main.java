import java.util.ArrayList;

public class Main {

    public static void destructive(ArrayList<String> arr, int stringSize) {

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() < stringSize) {
                arr.remove(i);
            }
        }
    }

    public static ArrayList<String> constructive(ArrayList<String> arr, int stringSize) {

        ArrayList<String> stringArray = new ArrayList<>(arr);
        for (int i = 0; i < stringArray.size(); i++) {
            if (stringArray.get(i).length() < stringSize) {
                stringArray.remove(i);
            }
        }
        return stringArray;
    }

    public static <E> ArrayList<E> constructGeneric(ArrayList<E> arr, E obj1, E obj2) {

        ArrayList<E> genericArray = new ArrayList<>(arr);
        for (int i = 0; i < genericArray.size(); i++) {
            if (genericArray.get(i) == obj1) {
                genericArray.set(i, obj2);
                break;
            }
        }
        return genericArray;
    }

    public static <E> void destructGeneric(ArrayList<E> arr, E obj1, E obj2) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(obj1)) {
                arr.set(i, obj2);
                break;
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("tomato");
        stringArray.add("cheese");
        stringArray.add("chips");
        stringArray.add("fruit");
        stringArray.add("pie");
        stringArray.add("butter");
        stringArray.add("tea");
        stringArray.add("buns");

        ArrayList<String> constructiveArray;
        constructiveArray = constructive(stringArray, 4);

        System.out.println("Constructive Method");
        for (String i : constructiveArray) {
            System.out.printf("%s ", i);
        }
        System.out.println();
        System.out.println();
        System.out.println(
                "Original String ArrayList");
        for (String i : stringArray) {
            System.out.printf("%s ", i);
        }
        System.out.println();
        System.out.println();
        System.out
                .println("Destructive Method Changing String ArrayList");
        destructive(stringArray, 4);
        for (String i : stringArray) {
            System.out.printf("%s ", i);
        }
        System.out.println();
        System.out.println();
        ArrayList<Integer> integerArray = new ArrayList<>();
        integerArray.add(5);
        integerArray.add(12);
        integerArray.add(4);
        integerArray.add(16);
        integerArray.add(4);
        integerArray.add(2);
        integerArray.add(2);

        ArrayList<Integer> constructiveIntegerArray;
        constructiveIntegerArray = constructGeneric(integerArray, 4, 7);
        System.out.println("Constructive Method");
        for (Integer i : constructiveIntegerArray) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println();
        System.out.println(
                "Original String ArrayList");
        for (Integer i : integerArray) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println();
        destructGeneric(integerArray, 4, 7);
        System.out
                .println("Destructive Method Changing String ArrayList");
        for (Integer i : integerArray) {
            System.out.printf("%d ", i);
        }

    }
}
