package strings.Simple.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class matrix {

    public static int[][] getDiagnoalMatrix( int n) {

        int[][] matrix = new int[n][n];

        Scanner sc = new Scanner(System.in);
        for(int row =0; row<n ; row++){
            for(int col=0; col< n; col++){
                matrix[row][col] = sc.nextInt();
            }
        }
        System.out.println(Arrays.deepToString(matrix));

        for(int row =0; row<n ; row++) {
            for (int col = 0; col < n; col++) {
                matrix[row][col] = matrix[row][n-1-col];
            }
        }
        for(int row =0; row<n ; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println("");
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix;
    }

    public static void main(String[] args) {
        getDiagnoalMatrix(2);
    }
}
