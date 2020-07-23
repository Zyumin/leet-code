/**
 * @author zhengyumin
 * @description ：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 *
 * 组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2


 * @date 2020-07-16 4:06 PM
 */
public class MajorityElement {

    /**
     * 解题思路：
     * 方法一：使用哈希统计
     * 方法二：排序
     * 方法三；摩尔投票法 （正负抵消）
     * @param args
     */
    public static void main(String[] args) {



    }

    public static int solution(int nums[]){

        int vote=0,x=0;

        for(int num:nums){

            //替换投票人
            if(vote==0){ x= num;}
            //正负抵消
            vote+= (num==x?1:-1);
        }

        return x;
    }

}
