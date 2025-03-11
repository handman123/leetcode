import java.util.HashMap;
import java.util.Map;

public class Code454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> hash = new HashMap<>();
        int temp;
        // 计算 a + b 出现次数
        for (int a : nums1)
            for (int b : nums1){
                temp = a + b;
                if (!hash.containsKey(temp))
                    hash.put(temp, 1);
                else hash.replace(temp, hash.get(temp) + 1);
            }
        // 遍历 c + d
        int counts = 0;
        for (int c : nums3)
            for (int d : nums4){
                temp = c + d;
                if (hash.containsKey(-temp))
                    counts += hash.get(-temp);
            }
        return counts;
    }
}
