package strings.Simple.array;

public class SecondMax {

    public static void secondMax(int[] arr){

        int first_max = Integer.MIN_VALUE;
        int second_max =  Integer.MIN_VALUE;

        for(int num : arr){

            if(first_max<num){
                second_max = first_max;
                first_max = num;
            } else if (first_max > num && second_max <num ) {
                second_max = num;
            }
        }
        System.out.println("Second max is  :::: "+second_max);
    }

    public static void main(String[] args) {

        int[] arr = {123,345,2,24,45,645,242,4,5,1};
        secondMax(arr);
    }
}
