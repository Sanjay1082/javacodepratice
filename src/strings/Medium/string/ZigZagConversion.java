package strings.Medium.string;

public class ZigZagConversion {

    public static String zigZaGString(String zigZag, int noOfRows) {
        int currentRow = 0;
        boolean downUpFlag = false;
        StringBuffer[] rows = new StringBuffer[noOfRows];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < noOfRows; i++) {
            rows[i] = new StringBuffer();
        }

        for (char ch : zigZag.toCharArray()) {
            rows[currentRow].append(ch);

            if ((currentRow == 0) || (currentRow == noOfRows - 1)) {
                downUpFlag = !downUpFlag;
            }
            currentRow = currentRow + (downUpFlag ? 1 : -1);
        }

        for (StringBuffer sb : rows) {
            result.append(sb);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.print(zigZaGString("PAYPALISHIRING", 3));
    }

}
