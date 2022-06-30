
commit test 2022-06-30

# 树遍历
## 递归实现

```java
public static void preOrderRecur(TreeNode head) {
    if (head == null) {
        return;
    }
    System.out.print(head.value + " ");
    preOrderRecur(head.left);
    preOrderRecur(head.right);
}

```



## 利用栈实现

## 前序遍历 (中->左->右)

入栈信息 中右左

```java
public static void preOrderIteration(TreeNode head) {
	if (head == null) {
		return;
	}
	Stack<TreeNode> stack = new Stack<>();
  List < Integer > res = new ArrayList < > ();
	stack.push(head);
	while (!stack.isEmpty()) {
		TreeNode node = stack.pop();
		res.add(node.val);
		if (node.right != null) {
			stack.push(node.right);
		}
		if (node.left != null) {
			stack.push(node.left);
		}
	}
}

```



## 中序遍历(左->中->右) 
左->中->右

```java
 public List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }

        return res;
    }
```



## 后序遍历(左->右->中)

```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
   
    TreeNode cur = root;
    TreeNode last = null;
    while (cur != null || !stack.isEmpty()) {
       //先找到最左节点
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }  
        curr = stack.peek();
        //是否变到右子树
        if (curr.right != null && curr.right != last) {
            cur = curr.right;
        } else {
            res.add(curr.val);
            last = curr;
            stack.pop();
        }
        
    }
    return list;
}
```



前序遍历是(中->左->右)  转化下顺序 中右左

再利用栈 转换为 左右中

```java
public static void postOrderIteration(TreeNode head) {
		if (head == null) {
			return;
		}
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.push(head);
		while (!stack1.isEmpty()) {
			TreeNode node = stack1.pop();
			stack2.push(node);
			if (node.left != null) {
				stack1.push(node.left);
			}
			if (node.right != null) {
				stack1.push(node.right);
			}
		}
		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().value + " ");
		}
	}

```


层序遍历  :bfs

```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    if (root == null) return levels;

    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);

    while ( !queue.isEmpty() ) {
      // start the current level
      List<Integer> list = new ArrayList<Integer>();
      // number of elements in the current level
      for(int i = 0; i < queue.size(); ++i) {
        TreeNode node = queue.remove();

        // fulfill the current level
        list.add(node.val);

        // add child nodes of the current level
        // in the queue for the next level
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      // go to next level
      levels.add(list);
    }
    return levels;
  }
```

最多次数 :g(i,n) = g(i) + g(n-i)



最大半径: 递归

```java
  public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxd;
    }
    public int depth(TreeNode node){
        if(node==null){
            return 0;
        }
        int Left = depth(node.left);
        int Right = depth(node.right);
        maxd=Math.max(Left+Right,maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left,Right)+1;//返回节点深度
    }
```

最大相同路径:递归 (新增判断)

```java
class Solution {
    int ans;
    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    public int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
```

树高 :层序遍历,或者递归

```java
public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    } else {
      int left_height = maxDepth(root.left);
      int right_height = maxDepth(root.right);
      return Math.max(left_height, right_height) + 1;
    }
  }
```

翻转 :bfs

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
        TreeNode current = queue.poll();
        TreeNode temp = current.left;
        current.left = current.right;
        current.right = temp;
        if (current.left != null) queue.add(current.left);
        if (current.right != null) queue.add(current.right);
    }
    return root;
}
```

或者

```java
public TreeNode invertTree(TreeNode root) {
    if (root == null) {
        return null;
    }
    TreeNode right = invertTree(root.right);
    TreeNode left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
}
```



镜像: 两个栈判断




# 快速排序

https://www.lagou.com/lgeduarticle/6225.html

```java
public void sort(int low, int hight, int array[]) {

        if (low > hight) {
            return;
        }
        int begin = low;
        int end = hight;

        int middle = array[begin];
        while (begin < end) {
            while (begin < end && array[end] > middle) {
                end--;
            }
            if (begin < end) {
                array[begin] = array[end];
            }
            while (begin < end && array[begin] < middle) {
                begin++;
            }
            if (begin < end) {
                array[end] = array[begin];
            }

        }
        array[begin] = middle;

        sort(low, begin - 1, array);
        sort(begin + 1, hight, array);
    }
```

# topK

https://www.cnblogs.com/9dragon/p/10777017.html

```java
 private static <T extends Comparable<? super T>> void quickSelect(T[] a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            //三数中值分割法获取枢纽元
            T pivot = median3(a, left, right);

            //开始分割序列
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            //将枢纽元与位置i的元素交换位置
            swapReferences(a, i, right - 1);

            if (k <= i) {
                quickSelect(a, left, i - 1, k);
            } else if (k > i + 1) {
                quickSelect(a, i + 1, right, k);
            }
        } else {
            insertionSort(a, left, right);
        }
    }
```




# 二分查找

 

```java
c    /**
      *  二分法查找
      * @param num 数组
      * @param target 目标值
      * @return
      */
     public int binarySearch(int num[],int target){
         /**
          * [left,right]
          */
         int left = 0,right=num.length-1;
         while(left<=right){
 
             int mid = left+ (right-left)/2;
 
             if(num[mid]>target){
                 right = mid-1;
             } else if(num[mid]<target){
                 left = mid+1;
             } else if(num[mid]==target){
                 return mid;
             }
         }
         return -1;
     }
 
 
     /**
      * 返回左边界
      * @param num
      * @param target
      * @return
      */
     public int binarySearchLeft(int num[],int target){
         /**
          * [left,right]
          */
         int left = 0,right=num.length-1;
         while(left<=right){
             int mid = left+ (right-left)/2;
             if(num[mid]>target){
                 right = mid-1;
             } else if(num[mid]<target){
                 left = mid+1;
             } else if(num[mid]==target){
                 //锁定左边边界
                 right = mid - 1;
             }
         }
         if(left>=num.length||num[left]!=target){
             return -1;
         }
         return left;
     }
 
     /**
      * 返回右边界
      * @param num
      * @param target
      * @return
      */
     public int binarySearchRight(int num[],int target){
         /**
          * [left,right]
          */
         int left = 0,right=num.length-1;
         while(left<=right){
             int mid = left+ (right-left)/2;
             if(num[mid]>target){
                 right = mid-1;
             } else if(num[mid]<target){
                 left = mid+1;
             } else if(num[mid]==target){
                 left = mid + 1;
             }
         }
         if(right<0||num[right]!=target){
             return -1;
         }
         return right;
     }
 
 
     public static void main(String[] args) {
         Demo demo = new Demo();
         int []num = {1,2,3,6,6,6,7,8,10};
         System.out.println(demo.binarySearch(num,6));
         System.out.println(demo.binarySearchLeft(num,6));
         System.out.println(demo.binarySearchRight(num,6));
     }
```



旋转数组

 https://leetcode-cn.com/problems/search-in-rotated-sorted-array/

思路:

​	二分查找, 对有序的部分进行判断,否则在另一边

```java
class Solution {
    public int search(int[] nums, int target) {
          if (nums == null || nums.length == 0) {
            return -1;
        }
        int pviot,left=0,right = nums.length-1;
        while(left<=right){
            pviot = left+(right-left)/2;
            int val = nums[pviot];
            if(val==target) return pviot;
            
            if(nums[left]<=val){
                //前半部分有序,判断是否在该区间内
                if(nums[left]<=target && target<val){
                    right = pviot-1;
                }else{
                    left = pviot+1;
                }
            }else{
              //后半部分有序,判断是否在区间内
                if (val<target && target <= nums[right] ) {
                    left = pviot + 1;
                } else {
                    right = pviot - 1;
                }   
            }
        }
        return -1;
    }
}
```



# 双指针

链表问题
    

两数之和

```java
/**
    先排序 后移动两个指针找出target
**/
class Solution {
    public int[] twoSum(int[] nums, int target) {
       int[] res = new int[2];
			 int[] temp = Arrays.copyOf(nums,nums.length);
			 Arrays.sort(nums);
			 int head=0, end =nums.length-1;
			 while(head<end) {
					if(nums[head]+nums[end]<target) {
							head++;
					}else if(nums[head]+nums[end]>target){
							end--;
					}else {
            //找到原数组的索引
            for(int i=0;i<temp.length;i++) {
              if(temp[i]==nums[head]) {
                res[0]=i;
              }
            }
            for(int i=temp.length-1;i>=0;i--) {
              if(temp[i]==nums[end]) {
                res[1]=i;
              }
            }
            return res;
					}
				}
				return null;
    }
}
```



#滑动窗口

## 无重复最长子串

```java
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }
}
```



双指针

```java
  public int lengthOfLongestSubstring(String s) {
		  if (s == null || s.length() == 0) {
            return 0;
        }
        int[] tmp = new int[256];
        int maxlen = 0;
        int l = 0;
        int r = 0;

        while (l < s.length()) {
            if (r < s.length() && tmp[s.charAt(r)] == 0) {
                tmp[s.charAt(r++)] = 1;
            } else {
                maxlen = maxlen > (r - l) ? maxlen : (r - l);
                tmp[s.charAt(l++)] = 0;
            }
        }

        return maxlen;

    }
```

