import _25_03.Code_25_03_05_209;

public class Main {
    public static void main(String[] args) {
        Code_25_03_05_209 solution = new Code_25_03_05_209();
        int[] inputs = new int[]{2,3,1,2,4,3};
        int target = 7;
//        int[] inputs = new int[]{1,4,4};
//        int target = 4;
        int res = solution.minSubArrayLen(target, inputs);
        System.out.println("res = " + res);
    }
}
