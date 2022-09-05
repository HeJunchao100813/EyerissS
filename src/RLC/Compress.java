package RLC;

import Dao.Cost;

import java.util.ArrayList;
import java.util.List;

public class Compress {
    public static double[][] compress(double[][] array) throws Exception {
//        int runNum=0;
        double[][] res;
        List<List<Double>> list = new ArrayList<>();
        if (array.length==1){
            List<Double> list1 = compress1D(array[0]);
            int length = list1.size();
            if (length%2!=0){
                throw new Exception();
            }
//            runNum = ((length/2-1)/3+1)*3;
//            System.out.println("压缩比率为："+((array.length/4)/(runNum/3)));
            res = new double[1][list1.size()];
            for (int i = 0; i < list1.size(); i++) {
                res[0][i] = list1.get(i);
            }
            return res;
        }
        else{
            List<List<Double>> list3 = new ArrayList<>();
            for (int i = 0; i <array.length; i++) {
                List<Double> list2 = compress1D(array[i]);
                int length = list2.size();
                if (length%2!=0){
                    throw new Exception();
                }
//                runNum += ((length/2-1)/3+1)*3;
                list3.add(list2);
            }
//            System.out.println("压缩比率为"+((array[0].length/4)/(runNum/3))*1.0);
            int num=Integer.MIN_VALUE;
            for (int i = 0; i < list3.size(); i++) {
                num = Math.max(num,list3.get(i).size());
            }
            res = new double[list3.size()][num];
            for (int i = 0; i < list3.size(); i++) {
                for (int j = 0; j < num; j++) {
                    res[i][j] = list3.get(i).get(j);
                }
            }
        }
        return res;
    }
    public static List<Double> compress1D(double[] array){
        int length=array.length;
        List<Double> res = new ArrayList<>();
        int zeroSum = 0;
        for (int i = 0; i < length; i++) {
            if (array[i]==0){
                zeroSum++;
                Cost.ComputeCost++;
                if (zeroSum==32){
                    res.add(31.0);
                    res.add(0.0);
                    zeroSum=0;
                }
            }
            else{
                res.add(zeroSum*1.0);
                res.add(array[i]);
                zeroSum=0;
            }
        }
        return res;
    }
}
