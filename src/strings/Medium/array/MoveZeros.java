package strings.Medium.array;

import java.util.Arrays;

public class MoveZeros {


    // Move the all the zeros to the left using extra variable
    public static int[] moveZeros(int[] arr) {

        int counter = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[counter] = arr[i];
                counter++;
            }
        }
        while (counter < arr.length) {
            arr[counter] = 0;
            counter++;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        return arr;
    }

    //This approach wont maintain the order of the non zero elements
    public static int[] moveZeros1(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            if (arr[start] == 0 && arr[end] != 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            } else if (arr[start] != 0) {
                start++;
            } else if (arr[end] == 0) {
                end--;
            }
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        return arr;
    }

    //Without using the extra variable and maintaining the order of the array
    public static int[] moveZeros2(int[] arr) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[start] == 0 && arr[end] == 0) {
                end++;
            } else if (arr[start] == 0 && arr[end] != 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end++;
            } else {
                start++;
                end++;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        return arr;
    }

    //Without using the extra variable and maintaining the order of the array
    public static int[] moveZeros3(int[] arr) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[start] == 0 && arr[end] != 0) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
            }

            if (arr[start] != 0) {
                start++;
            }

            end++;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 0, 12};

//        moveZeros(arr);
//        System.out.println("");
//        moveZeros2(arr);
//        System.out.println("");
//        moveZeros3(arr);

        System.out.println("");
        moveZeros1(arr);


    }
}
