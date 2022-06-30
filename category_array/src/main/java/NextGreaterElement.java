import java.util.*;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-14 4:24 PM
 */
public class NextGreaterElement {


    public static void main(String[] args) {

        int[] nums = {2,1,2,4,3};


        int[]ans = nextGreaterElements(nums);
        for(int a:ans){
            System.out.println(a);
        }

//
//        int num[] = {73, 74, 75, 71, 69, 72, 76, 73};
//
//        int[]ans1 = dailyTemperatures(num);
//        for(int a:ans1){
//            System.out.println(a);
//        }

    }


    /**
     * 给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,-1]。
     * @param nums
     * @return
     */
    public static  int [] nextGreaterElement(int []nums){
        int []ans = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i]){
                stack.pop();
            }
            ans[i] = stack.empty()?-1:stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    /**
     * 举例：给你 T = [73, 74, 75, 71, 69, 72, 76, 73]，你返回 [1, 1, 4, 2, 1, 1, 0, 0]。
     * @param num
     * @return
     */
    public static int[] dailyTemperatures(int []num){
        int []ans = new int[num.length];
        //存放下标记
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=num.length-1;i>=0;i--){
            while(!stack.isEmpty()&&num[stack.peek()]<=num[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);

        }

        return ans;
    }


    /**
     *  给你一个数组 [2,1,2,4,3]，你返回数组 [4,2,4,-1,4]。拥有了环形属性，最后一个元素 3 绕了一圈后找到了比自己大的元素 4 。
     * @param nums
     * @return
     */
    public static  int [] nextGreaterElements(int []nums){
        int []ans = new int[nums.length];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i=2*nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<=nums[i%(nums.length)]){
                stack.pop();
            }
            ans[i%((nums.length))] = stack.empty()?-1:stack.peek();
            stack.push(nums[i%((nums.length))]);
        }
        return ans;


    }



    public static void main2(String[] args) {
        int[] num = {2,1,2,4,3};
        int[] ans = new int[num.length];
        Arrays.fill(ans,-1);
        for(int i=0;i<num.length;i++){
            for(int j=i;j<num.length;j++){
                if(num[i]<num[j]){
                    ans[i] = num[j];
                    break;
                }
            }
        }
        for(int a:ans){
            System.out.println(a);
        }
    }

    public static void main1(String[] args) {
        Integer[] a = {2,1,2,4,3};

        List<Integer> integers = Arrays.asList(a);
        ArrayList<Object> list = new ArrayList<Object>();
        for (int i = 0; i < integers.size(); i++) {
            //这特么能到达？？
            if (i == integers.size()){
                System.out.println("i can go here");
                return;
            }
            //这特么命名？
            Integer integer = integers.get(i);
            //这特么嫌空间多？
            List<Integer> integers1 = integers.subList(i + 1, integers.size());
            Iterator<Integer> iterator = integers1.iterator();
            Integer max = null;
            while (iterator.hasNext()){
                Integer next = iterator.next();
                if (next> integer){
                    max = next;
                    break;
                }
            }
            //这特么max 不可以先给初始值？
            if (max == null){
                max = -1;
            }
            list.add(max);
        }
        System.out.println("list = " + list);
    }
}
