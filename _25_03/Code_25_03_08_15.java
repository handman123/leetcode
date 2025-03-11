package _25_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code_25_03_08_15 {

    public List<List<Integer>> threeSum(int[] nums) {

        int len = nums.length;

        // 对元素排序
        Arrays.sort(nums);

        // 返回结果
        List<List<Integer>> res = new ArrayList<>();

        // 双指针
        for (int i = 0; i < nums.length - 2; i++){
            if (nums[i] > 0)    // 剪枝
                break;

            // 左右指针
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right){
                System.out.println("left = " + left);
                System.out.println("right = " + right);
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0)
                    break;
                if (sum == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                }
                left++;
                right--;
                while (left < len && nums[left] == nums[left - 1]) left++;
                while (right > i && right < len - 1 && nums[right] == nums[right + 1]) right--;
            }
        }
        return res;
    }
}
