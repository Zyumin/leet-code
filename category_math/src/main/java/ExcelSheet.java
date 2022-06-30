/**
 * @author zhengyumin
 * @description todo 写点注释
 * @date 2020-10-20 5:02 PM
 */
public class ExcelSheet {

    /**
     * 给定一个Excel表格中的列名称，返回其相应的列序号。

     例如，

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
     ...
     示例 1:

     输入: "A"
     输出: 1
     示例 2:

     输入: "AB"
     输出: 28
     示例 3:

     输入: "ZY"
     输出: 701

     */

    public static void main(String[] args) {

//        char a = 'A';
//        System.out.println(a-'A'+1);

        String s = "ABCD";
        ExcelSheet demo =  new ExcelSheet();
        System.out.println(demo.solutiton(s));
    }

    public int solutiton(String s){
        int ans =0;

        for(int i=0;i<s.length();i++){
            int num = s.charAt(i)-'A'+1;
            ans = ans*26+num;
        }
        return ans;
    }
}
