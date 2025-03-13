package org.learning.code.num1_100;

public class Code45 {
    public int jump(int[] nums) {
        int curDistance = 0;
        int nextDistance = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nextDistance, i + nums[i]);
            if (i == curDistance){
                if (curDistance != nums.length - 1){
                    ans++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1)
                        break;
                } else break;
            }
        }
        return ans;
    }
}
