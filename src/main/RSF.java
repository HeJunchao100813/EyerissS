package main;

import Dao.Cost;
import Dao.IfmapCostInput;
import Dao.Input;
import Dao.WeightCostInput;
import RLC.Compress;
import RLC.Decompress;
import RS.Conv2D;
import RS.PSum;
import active.MaxPool;
import active.ReLu;

import java.util.Arrays;

public class RSF {
    public static void main(String[] args) throws Exception {
        double[][] weight = {{1,2},{3,4}};
        double[][] ifmap = {{1,2,3},{2,3,4},{3,4,5}};
        WeightCostInput.a++;
        /**
         * 第一次卷积
         */
        System.out.println("第一次卷积：");
//        ifmap = Compress.compress(ifmap);
        Input input = new Input(weight,ifmap);
        double[][] res = PSum.psum(Conv2D.conv2d(input.getIfmap(),input.getFilerWeight()));
        WeightCostInput.b++;
        System.out.println("运算结果：");
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        res = ReLu.ReLu(res);
        System.out.println("激活后：");
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        IfmapCostInput ifmapCostInput1 = new IfmapCostInput(1,1,1,1);
        IfmapCostInput ifmapCostInput2 = new IfmapCostInput(1,1,1,2);
        int ifmapCost = ifmapCostInput1.inputDataAccessEnergyCost()*2+ifmapCostInput2.inputDataAccessEnergyCost();
        ifmapCost*=2;
        IfmapCostInput ifmapCostInput3 = new IfmapCostInput(1,1,2,1);
        IfmapCostInput ifmapCostInput4 = new IfmapCostInput(1,1,2,2);
        ifmapCost+=ifmapCostInput3.inputDataAccessEnergyCost()*2+ifmapCostInput4.inputDataAccessEnergyCost();
        int inputCost = ifmapCost+WeightCostInput.inputDataAccessEnergyCost()* weight.length*weight[0].length;
//        Decompress.decompress(res);
//        System.out.println("Ofmap：");
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }
        System.out.println("计算的总消耗为："+Cost.computeCost());
        System.out.println("输入数据能耗:"+inputCost);
        System.out.println("PSum积累能耗"+Cost.psumAccumulationEnergyCost());

//        /**
//         * 第二次卷积
//         */
//        System.out.println("第二次卷积：");
//        Input input1 = new Input(weight,res);
//        res = PSum.psum(Conv2D.conv2d(input1.getIfmap(),input1.getFilerWeight()));
//        WeightCostInput.b++;
//        res = ReLu.ReLu(res);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }
//        Decompress.decompress(res);
////        res = MaxPool.maxPool(res,2);
//        System.out.println("MaxPool：");
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(Arrays.toString(res[i]));
//        }
//
//        System.out.println("计算的总消耗为："+Cost.computeCost());
////        System.out.println("输入数据能耗:"+Cost.inputDataAccessEnergyCost());
////        System.out.println("PSum积累能耗"+Cost.psumAccumulationEnergyCost());
//        System.out.println(WeightCostInput.inputDataAccessEnergyCost()* weight.length*weight[0].length);
    }
}
