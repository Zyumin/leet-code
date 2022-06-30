import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-20 11:00 PM
 */
public class GroupAnagrams {


    /**
     *   class Solution {
     public List<List<String>> groupAnagrams(String[] strs) {
     if (strs.length == 0) return new ArrayList();
     Map<String, List> ans = new HashMap<String, List>();
     for (String s : strs) {
     char[] ca = s.toCharArray();
     Arrays.sort(ca);
     String key = String.valueOf(ca);
     if (!ans.containsKey(key)) ans.put(key, new ArrayList());
     ans.get(key).add(s);
     }
     return new ArrayList(ans.values());
     }
     }



     /**
     *   输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
         输出:
         [
         ["ate","eat","tea"],
         ["nat","tan"],
         ["bat"]
         ]


     * @param args
     */
    public static void main(String[] args) {

    }


    public List<List<String>>groupAnagrams(String[] arr){

        List<List<String>> ans = new ArrayList<>();

        HashMap<String,List<String>> map = new HashMap<>();

        for(String s:arr){
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());

            }
            map.get(key).add(s);
        }


        for(List<String> list:map.values()){
            ans.add(list);
        }
        return ans;
    }
}
