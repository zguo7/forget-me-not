Find the Smallest Missing Positive Number (medium) #
Given an unsorted array containing numbers, find the smallest missing positive number in
it.

Example 1:

Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'
Example 2:

Input: [3, -2, 0, 1, 2]
Output: 4
Example 3:

Input: [3, 2, 5, 1]
Output: 4


Solution #
This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing
Number with one big difference. In this problem, the numbers are not bound by any range so
we can have any number in the input array.

However, we will follow a similar approach though as discussed in Find the Missing Number
to place the numbers on their correct indices and ignore all numbers that are out of the
range of the array (i.e., all negative numbers and all numbers greater than or equal to
the length of the array). Once we are done with the cyclic sort we will iterate the array
and the first index that does not have the correct number will be the smallest missing
positive number!

class FirstMissingPositive {

  public static int findNumber(int[] nums) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1])
        swap(nums, i, nums[i] - 1);
      else
        i++;
    }
    
    for (i = 0; i < nums.length; i++)
      if (nums[i] != i + 1)
        return i + 1;

    return nums.length + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    System.out.println(FirstMissingPositive.findNumber(new int[] { -3, 1, 5, 4, 2 }));
    System.out.println(FirstMissingPositive.findNumber(new int[] { 3, -2, 0, 1, 2 }));
    System.out.println(FirstMissingPositive.findNumber(new int[] { 3, 2, 5, 1 }));
  }
}


Time complexity #
The time complexity of the above algorithm is O(n).

Space complexity #
The algorithm runs in constant space O(1).