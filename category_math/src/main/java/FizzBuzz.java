import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-20 5:29 PM
 */
public class FizzBuzz {
    /**
     * 写一个程序，输出从 1 到 n 数字的字符串表示。

     1. 如果 n 是3的倍数，输出“Fizz”；

     2. 如果 n 是5的倍数，输出“Buzz”；

     3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

     示例：

     n = 15,

     返回:
     [
     "1",
     "2",
     "Fizz",
     "4",
     "Buzz",
     "Fizz",
     "7",
     "8",
     "Fizz",
     "Buzz",
     "11",
     "Fizz",
     "13",
     "14",
     "FizzBuzz"
     ]

     */



    public static void main(String[] args) {

        FizzBuzz demo  = new FizzBuzz();
        demo.solution(15).stream().forEach(o-> System.out.println(o));


    }

    public List<String> solution(int n){

        HashMap<Integer,String> map = new HashMap<>();
        map.put(3,"Fizz");
        map.put(5,"Buzz");


        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            String numAnsStr = "";
            for(int k :map.keySet()){
                if(i%k==0){
                    numAnsStr+=map.get(k);
                }
            }
            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(i);
            }
            ans.add(numAnsStr);
        }
        return ans;

    }
}
