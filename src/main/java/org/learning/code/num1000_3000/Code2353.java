package org.learning.code.num1000_3000;

import java.util.*;

public class Code2353 {
    private String[] foods;
    private String[] cuisines;
    private int[] ratings;

    private Map<String, Integer> foodMap;
    private int[][] ratingMap;
    private Map<Integer, Integer> ratingMMap;

    private int food_nums = 0;
    private int capacity = 0;

    private static final int DEFAULT_MAX_NUMS = 20;

    public Code2353(String[] foods, String[] cuisines, int[] ratings) {
        init(foods, cuisines, ratings);
    }

    public void changeRating(String food, int newRating) {
        int foodIndex = findFoodIndex(food);
        if (foodIndex == -1)
            return;
        ratings[foodIndex] = newRating;
//        for (int i = 0; i < ratingMap.length; i++) {
//            if (ratingMap[i][0] == foodIndex)
//                ratingMap[i][1] = newRating;
//        }
        System.out.println("food = " + food);
        System.out.println("foodIndex = " + foodIndex);
        System.out.println("ratingMMap.get(foodIndex) = " + ratingMMap.get(foodIndex));
        ratingMap[ratingMMap.get(foodIndex)][0] = newRating;
        Arrays.sort(ratingMap, Comparator.comparingInt(a -> a[1]));
    }

    public String highestRated(String cuisine) {
        int maxRate = Integer.MIN_VALUE;
        String res = "";
        Queue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < ratingMap.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(" " + ratingMap[i][j]);
            }
            System.out.println();
        }
        // 找到最大值
        for (int i = food_nums - 1; i >= 0; i--) {
//            if (maxRate == ratings[i] && cuisines[i].equals(cuisine)){
//                queue.add(foods[i]);
//                maxRate = ratings[i];
//            }
//            else if (maxRate < ratings[i] && cuisines[i].equals(cuisine)){
//                queue.clear();
//                queue.add(foods[i]);
//                maxRate = ratings[i];
//            }
            // 获取最大值下标
            int maxIndex = ratingMap[i][0];
            int maxCode = ratingMap[i][0];
            if (maxRate < maxCode && cuisines[maxIndex].equals(cuisine)){
                queue.clear();
                maxRate = ratingMap[i][1];
                queue.add(foods[i]);
            }
            else if (maxRate == maxCode && cuisines[maxIndex].equals(cuisine)){
                queue.add(foods[i]);
            }
            else break;
        }
        return queue.poll();
    }

    // 初始化
    private void init(String[] foods, String[] cuisines, int[] ratings){
        // 初始化
        int nums = foods.length;
        // this.capacity = nums > DEFAULT_MAX_NUMS ? (int) (nums * 1.5) : DEFAULT_MAX_NUMS;
        this.foods = foods;
        this.cuisines = cuisines;
        this.ratings = ratings;
        // 赋值
        this.food_nums = nums;
        // 生成food hashMap
        this.foodMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++)
            foodMap.put(foods[i], i);
        // 生成rating hashMap
        this.ratingMap = new int[ratings.length][2];
        for (int i = 0; i < foods.length; i++){
            ratingMap[i][0] = i;
            ratingMap[i][1] = ratings[i];
        }
        Arrays.sort(ratingMap, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        // rating 与 ratingMap关联
        this.ratingMMap = new HashMap<>();
        for (int i = 0; i < ratingMap.length; i++) {
            System.out.print(" " + ratingMap[i][0] + " " + ratingMap[i][1]);
            ratingMMap.put(ratingMap[i][0], i);
        }
    }

    // 找到食物下标
    private int findFoodIndex(String food){
        if (foodMap.containsKey(food))
            return foodMap.get(food);
        return -1;
    }
}
