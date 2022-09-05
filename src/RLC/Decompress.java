package RLC;

import java.util.ArrayList;
import java.util.List;

public class Decompress {
    public static double[][] decompress(double[][] array){
        List<List<Double>> res = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Double> res1 = new ArrayList<>();
            for (int j = 0; j < array[0].length; j++) {
                if (j%2==0){
                    for (int k = 0; k < array[i][j]; k++) {
                        res1.add(0.0);
                    }
                }
                else{
                    res1.add(array[i][j]);
                }
            }
            res.add(res1);
        }
//        int length = 0;
//        for (int i = 0; i < res.size(); i++) {
//            length = Math.max(res.get(i).size(),length);
//        }
        double[][] num = new double[res.size()][res.get(0).size()];
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(0).size(); j++) {
                num[i][j] = res.get(i).get(j);
            }
        }
        return num;
    }
}
