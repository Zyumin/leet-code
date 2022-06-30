import java.util.ArrayList;
import java.util.List;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-20 5:10 PM
 */
public class PascalsTriangle {
    /**
     * 输入: 5
     输出:
     [
     [1],
     [1,1],
     [1,2,1],
     [1,3,3,1],
     [1,4,6,4,1]
     ]

     */

    public static void main(String[] args) {

        PascalsTriangle demo = new PascalsTriangle();
        demo.solution(5);

    }

    public List<List<Integer>> solution(int numRows){

        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }
        //bad case
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        for(int i=1;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            List<Integer> preList = triangle.get(i-1);
            row.add(1);
            for(int j=1;j<i;j++){
                row.add(preList.get(j-1)+preList.get(j));

            }
            row.add(1);
            triangle.add(row);
        }

        return triangle;

    }
}
