package strings.Simple.array;

public class rorateIntArray {


    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static int[] rotateIntArrayByKLeft(int[] arr, int k){
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        reverseArray(arr, 0, arr.length-1);
        return arr;
    }

    public static int[] rotateIntArrayByKRight(int[] arr, int k){
        reverseArray(arr, 0, k-1);
        reverseArray(arr, k, arr.length-1);
        reverseArray(arr, 0, arr.length-1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,0};
        arr = rotateIntArrayByKLeft(arr,3);

        for(int num : arr){
            System.out.print(num+" ");
        }

        System.out.println();

        int[] arr1 = {1,2,3,4,5,6,7,8,9,0};
        arr1 = rotateIntArrayByKRight(arr,3);
        for(int num : arr1){
            System.out.print(num+" ");
        }
    }
}
