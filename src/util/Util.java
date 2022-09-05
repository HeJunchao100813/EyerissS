package util;

import java.util.Arrays;

public class Util {

    /**
     *
     * @param num
     * @return num数组的最大值
     */
    public static double max(double[] num){
        double res = Double.MIN_VALUE;
        for (double num1:
             num) {
            res = Math.max(res,num1);
        }
        return res;
    }

    /**
     *
     * @param num
     * @return num数组的最小值
     */
    public static double min(double[] num){
        double res = Integer.MAX_VALUE;
        for (double num1:
             num) {
            res = Math.min(res,num1);
        }
        return res;
    }

    /**
     *
     * @param num
     * @return num数组的平均数
     */
    public static double avg(double[] num){
        int sum = 0;
        for (double num1:
             num) {
            sum+=num1;
        }
        return sum/num.length*1.0;
    }

    /**
     * 打印数组
     * @param num
     */
    public static void printArray(int[] num){
        System.out.println(Arrays.toString(num));
    }
}
