import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-09 6:24 PM
 */
public class No207Course {

    public static void main(String[] args) {


    }

    /**
     *
     * @param numCourses  课程数
     * @param prerequisites  前置课程
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        /**
         * 每个节点的入度 入度表
         */
        int[] indegrees = new int[numCourses];

        /**
         *  邻接表
         */
        List<List<Integer>> adjacency = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            adjacency.add(new ArrayList<Integer>());
        }

        for(int []curr:prerequisites){
            indegrees[curr[0]]++;
            adjacency.get(curr[1]).add(curr[0]);
        }


        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegrees[i]==0){
                queue.add(i);
            }
        }

        // BFS TopSort.
        while(!queue.isEmpty()){
            int pre = queue.poll();
            numCourses--;
            for(int curr:adjacency.get(pre)){
               if( --indegrees[curr]==0){
                   queue.add(curr);
               }

            }
        }

        return numCourses==0;
    }
}
