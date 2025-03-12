package org.review;


import org.review._25_03._01_10.Code_05_209;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        Code_05_209 solution = new Code_05_209();
        int[] inputs = new int[]{2,3,1,2,4,3};
        int target = 7;
//        int[] inputs = new int[]{1,4,4};
//        int target = 4;
        int res = solution.minSubArrayLen(target, inputs);
        System.out.println("res = " + res);
    }
}