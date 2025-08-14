package strings.Simple.string;

public class PerformSwappingWithOutThirdVariable {

    public static void performSwapping(int a, int b){

        System.out.println("A value before swapping :::: A : "+a);
        System.out.println("B value before swapping :::: B : "+b);

        a = a + b;
        b = a - b ;
        a = a - b ;

        System.out.println("A value after swapping :::: A : "+a);
        System.out.println("B value after swapping :::: B : "+b);
    }

    public static void main(String[] args) {
        performSwapping(2,3);
    }
}
