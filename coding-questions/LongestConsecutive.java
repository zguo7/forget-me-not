/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
/* 这道题是要求出最长的整数连续串。我们先说说简单直接的思路，就是先排序，然后做一次扫描，记录当前连续串长度，如果连续串中断，则比较是否为当前最长连续串，并且把当前串长度置0。这样时间复杂度是很明确，就是排序的复杂度加上一次线性扫描。如果不用特殊的线性排序算法，复杂度就是O(nlogn)。
其实这个题看起来是数字处理，排序的问题，但是如果要达到好的时间复杂度，还得从图的角度来考虑。思路是把这些数字看成图的顶点，而边就是他相邻的数字，然后进行深度优先搜索。通俗一点说就是先把数字放到一个集合中，拿到一个数字，就往其两边搜索，得到包含这个数字的最长串，并且把用过的数字从集合中移除（因为连续的关系，一个数字不会出现在两个串中）。最后比较当前串是不是比当前最大串要长，是则更新。如此继续直到集合为空。如果我们用HashSet来存储数字，则可以认为访问时间是常量的，那么算法需要一次扫描来建立集合，第二次扫描来找出最长串，所以复杂度是O(2*n)=O(n)，空间复杂度是集合的大小，即O(n)
————————————————
版权声明：本文为CSDN博主「Code_Ganker」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/linhuanmars/article/details/22964467
*/

import java.util.Arrays;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import java.util.HashSet;

public class Main
{
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
        int res = 1;
        for(int i=0;i<num.length;i++)
        {
            set.add(num[i]);
        }
        while(!set.isEmpty())
        {
            Iterator iter = set.iterator();
            int item = (Integer)iter.next();
            set.remove(item);
            int len = 1;
            int i = item-1;
            while(set.contains(i))
            {
                set.remove(i--);
                len++;
            }
            i = item+1;
            while(set.contains(i))
            {
                set.remove(i++);
                len++;
            }
            if(len>res)
                res = len;
        }
        System.out.println("res=" + res);
        return res;
    }
    
	public static void main(String[] args) {
	    Main test = new Main();
	    test.longestConsecutive(new int[] {1,2,3,4,6,7,8,9,10,22,23,39,44});
	}
}
