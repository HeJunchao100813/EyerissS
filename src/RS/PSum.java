package RS;

import Dao.Cost;
import Dao.CostCoefficient;

import java.util.ArrayList;
import java.util.List;

public class PSum {
    public static double[][] psum(List<List<double[]>> res1){
        List<List<Double>> res2 = new ArrayList<>();
        for (int i = 0; i < res1.size(); i++) {
            res2.add(new ArrayList<Double>());
            for (int j = 0; j < res1.get(0).size(); j++) {
                for (double num:res1.get(i).get(j)){
                    res2.get(i).add(num);
                }
            }
        }
        double[] ans = new double[res2.get(0).size()];
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < res2.size(); j++) {
                ans[i]+=res2.get(j).get(i);
            }
        }
        double[][] ans1 = new double[(int) Math.sqrt(ans.length)][(int) Math.sqrt(ans.length)];
        int k=0;
        for (int i = 0; i < ans1.length; i++) {
            for (int j = 0; j < ans1.length; j++) {
                ans1[i][j] = ans[k++];
            }
        }
        Cost.a2=1;
        Cost.b2=2;
        Cost.c2=2;
        Cost.d2=2;
        Cost.ComputeCost=4;
        return ans1;
//        double[][] ans = new double[res1.size()][res1.get(0).get(0).length];
//        for (int i = 0; i < res1.size(); i++) {
//            for (int j = 0; j < res1.get(0).get(0).length; j++) {
//                for (int k = 0; k < res1.get(0).size(); k++) {
//                    ans[i][j]+=res1.get(i).get(k)[j];
//                }
//            }
//        }
//        return ans;
    }
}
