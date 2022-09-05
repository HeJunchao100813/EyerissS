package OS;

import Dao.Cost;
import Dao.WeightCostInput;

public class Conv {

    public static double[][] conv(double[][] weight,double[][] ifmap){

//        Cost.a1+=weight.length*weight[0].length;
//        Cost.a1+=ifmap.length*ifmap[0].length;//先把数据从DRAM中读出
//
//        Cost.b1+=Cost.a1;//写入Global Buffer

        double[][] Psum = new double[ifmap.length-weight.length+1][ifmap.length-weight.length+1];
        for (int i = 0; i < Psum.length; i++) {
            for (int j = 0; j < Psum[0].length; j++) {
//                Cost.b1+= ifmap.length*ifmap[0].length;
//                Cost.c1+=ifmap.length*ifmap[0].length;
//
//                Cost.b1+= weight.length*weight[0].length;
//                Cost.c1+=weight.length*weight[0].length;//ifmap和weight通过NOC写入PE中
                Psum[i][j]=conv(weight,ifmap,i,j);
                Cost.ComputeCost++;
//                Cost.d2++;//psum累积在PE中
            }
        }
        Cost.a2=1;
        Cost.b2=2;
        Cost.c2=2;
        Cost.d2=4;
        WeightCostInput.a=1;
        WeightCostInput.b=1;
        WeightCostInput.c=1;
        WeightCostInput.d=1;
//        Cost.d2+=Psum.length*Psum[0].length;//PE中读出所有的psum
//
//        Cost.c2+=Psum.length*Psum[0].length;//通过NOC把psum传输到Global Buffer
//
//        Cost.b2+=Psum.length*Psum[0].length;//写入Global Buffer
//        Cost.b2+=Psum.length*Psum[0].length;//从Global Buffer读取psum
//
//        Cost.a2+=Psum.length*Psum[0].length;//写入DRAM

        return Psum;
    }

    public static int conv(double[][] weight,double[][] ifmap,int left,int right){
        int res=0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j < weight[0].length; j++) {
                res+=weight[i][j]*ifmap[i+left][j+right];
//                Cost.ComputeCost++;
//                Cost.d1+=2;//读取数据
            }
        }
        return res;
    }

}
