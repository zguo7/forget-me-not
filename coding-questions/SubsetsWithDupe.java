import java.util.Arrays;
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main
{
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        // 题目中要求每个list是非降序，所以要先从小到大排序
        Arrays.sort(nums);
        // 对于n位，有2^n种情况
        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> list = new ArrayList<Integer>();
            int tmp = i;
            // 对于每种情况，分别求得二进制中1的个数
            // 0代表不选择，1代表选择
            for (int j = 0; j < nums.length; j++) {
                int bit = tmp & 1;
                tmp >>= 1;
                if (bit == 1) {
                    list.add(nums[j]);
                }
            }
            set.add(list);
        }
        System.out.println(set.toString());
        return new ArrayList<List<Integer>>(set);
    }
    
	public static void main(String[] args) {
	    Main test = new Main();
	    test.subsetsWithDup(new int[]{1,2,4,4,5});
	}
	
}
