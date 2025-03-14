package org.whut;

import org.whut.code.hash.Code_01;

import java.util.Arrays;

public class Main {

        public static void main(String[] args) {
            Code_01 solution = new Code_01();

            int[] input = new int[]{};
            int target = 0;
            int[] res = solution.twoSum(input, target);
            System.out.println("res = " + Arrays.toString(res));
        }

}