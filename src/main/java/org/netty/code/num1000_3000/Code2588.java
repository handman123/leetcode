package org.netty.code.num1000_3000;

public class Code2588 {

    /**
     *
     */





    /**
     * 思路：利用大根堆，依次将所有元素入堆
     * 输出两个最大值，如果两个值相等，则美丽数组加1，否则绝对值相减入堆
     * 依次处理，直到堆中只有一个元素或元素数量为0
     *
     * 数组内有0，导致代码很复杂
     */

//    public long beautifulSubarrays(int[] nums) {
//        long len = nums.length;
//        if (nums.length == 0)
//            return 0;
//        Queue<Integer> queue = new PriorityQueue<>((e1, e2) -> Integer.compare(e2, e1));
//        // 入堆
//        int zeroNum = 0;
//        for (int item : nums){
//            if (item == 0)
//                zeroNum++;
//            else queue.offer(item);
//        }
//        if (queue.peek() == 0){
//            return (long) Math.pow(2, len) - 1;
//        }
//        // 处理
//        long number = 0;
//        while (queue.size() > 1){
//            // 输出两个最大值
//            int a = queue.poll();
//            int b = queue.poll();
//            if (a == b)
//                number++;
//            else queue.add(a - b);
//        }
//        while (!queue.isEmpty() && queue.peek() != 0) queue.poll();
//        if (queue.peek() == 0){
//            System.out.println("queue.peek() = " + queue.peek());
//            return (long) Math.pow(2, queue.size()) - 1;
//        }
//        return number;
//    }
}
