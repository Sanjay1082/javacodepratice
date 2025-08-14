package strings.Simple.array;

public class MissingNumber {

    public static int findMissingNumber(int[] arr){

        for(int index = 0; index < arr.length-1; index++){

            if(!(arr[index+1] - arr[index] == 1)){
                return arr[index]+1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,9};
        System.out.println(findMissingNumber(arr));
    }
}
