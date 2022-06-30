import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zhengyumin
 * @description
 * 对角线遍历
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * @date 2020-08-26 8:09 PM
 */
public class DiagonalTraverse {

    public static int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[]{};
        }
        //多少行
        int row = matrix.length;
        //多少列
        int col = matrix[0].length;
        int[] result = new int[row * col];
        int index = 0;
        ArrayList<Integer> intermediate = new ArrayList<Integer>();

        for (int i = 0; i < row + col - 1; i++) {
            int r = i < col ? 0 : i - col + 1;
            int c = i < col ? i : col - 1;
            while (r < row && c >= 0) {
                intermediate.add(matrix[r++][c--]);
            }
            if (i % 2 == 0) {
                Collections.reverse(intermediate);
            }
            for (int d = 0; d < intermediate.size(); d++) {
                result[index++] = intermediate.get(d);
            }
            intermediate.clear();
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = {{3}, {2}};
        int[] result = findDiagonalOrder(matrix);

        for (int i : result) {
            System.out.println(i);
        }


    }


}
