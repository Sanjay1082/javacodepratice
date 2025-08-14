package strings.Simple.array;

public class CheckArraySorted {

    public static boolean isSorted(int[] arr){

        boolean asscendingFlag = false;

        for(int index = 0; index < arr.length-1; index++){

            if((arr[index] <= arr[index+1])){
                asscendingFlag = true;
            }else{
                System.out.println("Array is not sorted asscendingly");
                return asscendingFlag = false;
            }
        }
        if(asscendingFlag)
            System.out.println("Array is sorted asscendingly :::: "+asscendingFlag);
        return asscendingFlag;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        isSorted(arr);
    }
}
