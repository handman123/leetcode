package org.learning.code.num501_1000;

import java.util.Map;

public class Code860 {

    /**
     * 三种情况
     * <p>
     *     1. 顾客给5美元，成功交易，5美元数量加一。
     * </p>
     * <p>
     *     2. 顾客给10美元，5美元数量减一，10美元数量加一。5美元数量不足则返回false。
     * </p>
     * <p>
     *     3. 顾客给20美元，优先给10美元和5美元，10美元数量不足则给两张五美元，5美元数量不足则返回false。
     * </p>
     * @param bills 购买柠檬水的顾客i拥有的美元面值。
     * @return  返回布尔值，是否可以找零。
     */
    public boolean lemonadeChange(int[] bills) {
        int len = bills.length;
        // 异常返回
        if (len < 1)
            return true;
        // int[] 记录各个面值数量
        int[] nums = new int[2];
        // 循环
        for (int i = 0; i < len; i++){
            // 情况1
            if (bills[i] == 5){
                nums[0]++;
            }
            // 情况2
            else if (bills[i] == 10) {
                if (nums[0] == 0)
                    return false;
                nums[0]--;
                nums[1]++;
            }
            // 情况3
            else if (bills[i] == 20) {
                // 给10美元和5美元
                if (nums[0] > 0 && nums[1] > 0){
                    nums[0]--;
                    nums[1]--;
                }
                else if (nums[0] >= 3)
                    nums[0] -= 3;
                else return false;
            }
        }
        return true;
    }
}
