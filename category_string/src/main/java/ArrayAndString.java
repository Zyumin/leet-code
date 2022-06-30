/**
 * @author zhengyumin
 * @description todo 写点注释
 * <p>
 * <p>
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * @date 2020-08-26 9:49 PM
 */
public class ArrayAndString {
    public static void main(String[] args) {

        String blue = "the sky is blue";

        int length = blue.length();
        //移动遍历指针
        int index = length;
        //反转指针
        int revIndex;


        String revStr = "";
        char splitChar = ' ';
        while (index-- >= 0) {

            //遇到空格停下
            if (index < 0 || blue.charAt(index) == splitChar) {
                //记录翻转指针开始位置
                revIndex = index + 1;
                if (revStr != "") {
                    revStr += splitChar;
                }
                //开始翻转字符串
                while (revIndex < blue.length() && blue.charAt(revIndex) != splitChar) {
                    revStr += blue.charAt(revIndex);
                    revIndex++;
                }
                //跳过多余空格
                while (index >= 0 && blue.charAt(index) == splitChar) {
                    index--;
                }

            }
        }

        System.out.println(revStr);

    }
}
