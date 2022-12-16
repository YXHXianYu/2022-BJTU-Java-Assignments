/**
 * @author YXH_XianYu
 * @create 2022-03-29
 */
public class TestArray {
    public static void main(String[] args) {
        int[] array1 = {2, 3, 5, 7, 11, 13, 17, 19};
        int[] array2;

        printArray(array1);
        System.out.println();

        array2 = array1;
        array2[0] = 0;
        array2[2] = 2;
        array2[4] = 4;
        array2[6] = 6;

        printArray(array1);
        System.out.println();

        // --- fen ge xian ---
        System.out.println();
        // --- fen ge xian ---

        int[][] matrix = {{}, {}, {}, {}, {}};
        for(int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[i];
            for(int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = i * j;
        }
        for(int i = 0; i < matrix.length; i++) {
            System.out.print("matrix[" + i + "] is ");
            printArray(matrix[i]);
            System.out.println();
        }

    }

    public static void printArray(int[] array) {
        System.out.print('<');
        for ( int i = 0; i < array.length; i++ ) {
            // print an element
            System.out.print(array[i]);
            // print a comma delimiter if not the last element
            if ( (i + 1) < array.length ) {
                System.out.print(", ");
            }
        }
        System.out.print('>');
    }
}
