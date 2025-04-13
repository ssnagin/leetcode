
import java.util.Arrays;

class Solution {
    public long findScore(int[] nums) {

        int[] marked = new int[nums.length];
        long result = 0;
        
        for (int i = 0; i < marked.length; i++) {
            marked[i] = 0;
        }
        
        long index = -1;
        
        while (index != -666) {
            index = getIndexOfSmallestElement(nums, marked);
            
            if (index == -666 || index == -1) break;
            
            marked[index] = 1;
            
            result += nums[index];
            if (nums.length == 1) break;
            if (index == 0 && nums.length > 1) {
                marked[index + 1] = 1;
                continue;
            }
            
            if (index == nums.length - 1) {
                marked[index - 1] = 1;
                continue;
            }
            marked[index + 1] = 1;
            marked[index - 1] = 1;
        }
        
        return result;
    }
    
    public static int getIndexOfSmallestElement(int[] nums, int[] marked) {
        if (nums == null || nums.length == 0) return -1;

        int minIdx = -666;
        int minVal = Integer.MAX_VALUE; 
        
        if (nums.length == 1 && marked[0] == 1) return -666;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= minVal) continue;
            
            if (marked[i] == 1) continue;
            
            minVal = nums[i]; 
            minIdx = i;
           
        }
        return minIdx;
    }
}