/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-09-11 1:05 AM
 */
public class Rotate {

    public static void main(String[] args) {


        /**
         * 给定 matrix =
         [
         [1,2,3],
         [4,5,6],
         [7,8,9]
         ],
         */

        int [][]matrix = {{1,2,3},{4,5,6},{7,8,9}};

        //沿中线两两交换
        int n = matrix.length;

        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
//                swap(matrix,i,n-i-1,j);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-i-1][j];
                matrix[n-i-1][j]= temp;
            }
        }


        // 沿对角线交换
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }

    }

    /**
     *
     * @param matrix
     * @param i   头
     * @param j   尾
     * @param n   同一直线
     */
    private static void swap( int [][]matrix,int i, int j,int n) {
        int temp = matrix[i][n];
        matrix[i][n] = matrix[j][n];
        matrix[j][n]= temp;
    }
}
