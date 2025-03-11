import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Code15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        char[] chars =new char[10];
        String s = new String(chars);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 剪枝
            if (nums[i] > 0)
                return res;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            // 双指针
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end){
                if (nums[i] + nums[start] + nums[end] > 0)
                    end--;
                else if (nums[i] + nums[start] + nums[end] < 0)
                    start++;
                else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[start]);
                    temp.add(nums[end]);
                    res.add(temp);
                    // start 前移
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    // end 后移动
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                }
            }
        }
        return res;
    }
//    public List<List<Integer>> threeSum(int[] nums) {
//        // 数组排序
//        Arrays.sort(nums);
//        // 三指针
//        List<List<Integer>> res = new ArrayList<>();
//        int i = 0, j = i + 1;
//        while (i < nums.length - 2){
//            if(nums[i] > 0)
//                // 剪枝
//                return res;
//            for (int k = j + 1; k < nums.length; k++) {
//                if(i > 0 && nums[i] == nums[i - 1]){
//                    i++;
//                    break;
//                }
//                else if(nums[k] == nums[k - 1] && k - 1 > j)    // 去重
//                    continue;
//                else if(nums[j] == nums[j - 1] && j - 1 > i){   // 去重
//                    j++;
//                    continue;
//                }
//                else if (nums[i] + nums[j] + nums[k] == 0){
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(nums[j]);
//                    temp.add(nums[k]);
//                    res.add(temp);
//                }
//                else if (nums[i] + nums[j] + nums[k] > 0){
//                    // 剪枝
//                    break;
//                }
//
//            }
//            j++;
//            if(j >= nums.length - 1){
//                i++;
//                j = i + 1;
//            }
//        }
//        return res;
//    }
}
