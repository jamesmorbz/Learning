package Learning.PassByReferencing;

public class PassByReferencing {
    public static void main(String[] args) {
        String[] a = {"1"};
        String[] b = {"2"};
        a = b;
        b[0] = "3";
        System.out.println((a[0]));
        System.out.println((b[0]));
    }
}
