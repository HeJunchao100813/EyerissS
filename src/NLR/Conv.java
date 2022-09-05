package NLR;

import Dao.Cost;
import Dao.WeightCostInput;

public class Conv {
    public static double[][] conv(double[][] weight,double[][] ifmap){

//        Cost.a1+=weight.length*weight[0].length;
//        Cost.a1+=ifmap.length*ifmap[0].length;//先把数据从DRAM中读出

//        Cost.b1+=Cost.a1;//写入Global Buffer

        double[][] Psum = new double[ifmap.length-weight.length+1][ifmap.length-weight.length+1];
        for (int i = 0; i < Psum.length; i++) {
            for (int j = 0; j < Psum[0].length; j++) {
//                Cost.b1+= weight.length*weight[0].length;
//                Cost.c1+=weight.length*weight[0].length;
//                if (j%2==0){
//                    Cost.b1+= ifmap.length*ifmap[0].length;
//                    Cost.c1+=ifmap.length*ifmap[0].length;
//                }
                Psum[i][j]=conv(weight,ifmap,i,j);
                Cost.ComputeCost++;
//                Cost.d2++;//psum在PE内部的写
//                Cost.d2+=i* Psum[0].length+j+1;//psum中PE内部的读
//
//                Cost.c2+=i* Psum[0].length+j+1;//psum在PE之间的传递
            }
        }
        Cost.a2=1;
        Cost.b2=2;
        Cost.c2=4;
        Cost.d2=3;
        WeightCostInput.a=1;
        WeightCostInput.b=1;
        WeightCostInput.c=2;
        WeightCostInput.d=1;
//        Cost.b2+=Psum.length* Psum[0].length*2;//psum在Global Buffer中读写

//        Cost.a2+=Psum.length* Psum[0].length;//最终结果写入DRAM中

        return Psum;
    }

    public static int conv(double[][] weight,double[][] ifmap,int left,int right){
        int res=0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                res+=weight[i][j]*ifmap[i+left][j+right];
//                Cost.ComputeCost++;
//                Cost.d1+=2;
            }
        }
        return res;
    }
}
