package org.whut;

import org.whut.code.Code_hash_01;

import java.util.Arrays;

public class Main {

        public static void main(String[] args) {
            Code_hash_01 solution = new Code_hash_01();

            int[] input = new int[]{};
            int target = 0;
            int[] res = solution.twoSum(input, target);
            System.out.println("res = " + Arrays.toString(res));
        }

}