package main;

import Dao.Cost;
import Dao.IfmapCostInput;
import Dao.Input;
import Dao.WeightCostInput;
import IS.Conv;

import java.util.Arrays;

public class ISF {
    public static void main(String[] args) {
        double[][] weight = {{1,2},{3,4}};
        double[][] ifmap = {{1,2,3},{2,3,4},{3,4,5}};

        Input input = new Input(weight,ifmap);

        double[][] res = Conv.conv(weight,ifmap);
        System.out.println("运算结果：");
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
        int icost = WeightCostInput.inputDataAccessEnergyCost()*4;
        IfmapCostInput ifmapCostInput = new IfmapCostInput(1,1,1,1);
        icost+=ifmapCostInput.inputDataAccessEnergyCost()*4*4;
        System.out.println("计算的总消耗为："+ Cost.computeCost());
        System.out.println("输入数据能耗:"+icost);
        System.out.println("PSum积累能耗"+Cost.psumAccumulationEnergyCost());
    }
}
