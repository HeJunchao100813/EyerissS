package Dao;

public class Cost {
    public static int a1=0;
    public static int b1=0;
    public static int c1=0;
    public static int d1=0;
    public static int a2=0;
    public static int b2=0;
    public static int c2=0;
    public static int d2=0;
    public static int ComputeCost=0;

    public Cost() {
    }

    public static int getA() {
        return a1;
    }

    public static void setA(int a1) {
        Cost.a1 = a1;
    }

    public static int getB() {
        return b1;
    }

    public static void setB(int b1) {
        Cost.b1 = b1;
    }

    public static int getC() {
        return c1;
    }

    public static void setC(int c1) {
        Cost.c1 = c1;
    }

    public static int getD() {
        return d1;
    }

    public static void setD(int d1) {
        Cost.d1 = d1;
    }

    public static int getA2() {
        return a2;
    }

    public static void setA2(int a2) {
        Cost.a2 = a2;
    }

    public static int getB2() {
        return b2;
    }

    public static void setB2(int b2) {
        Cost.b2 = b2;
    }

    public static int getC2() {
        return c2;
    }

    public static void setC2(int c2) {
        Cost.c2 = c2;
    }

    public static int getD2() {
        return d2;
    }

    public static void setD2(int d2) {
        Cost.d2 = d2;
    }

    public static int getComputeCost() {
        return ComputeCost;
    }




    /**
     * 输入数据能耗
     * @return Input Data Access Energy Cost
     */
    public static int inputDataAccessEnergyCost(){
        return a1*CostCoefficient.getDRAM()+a1*b1*CostCoefficient.getGlobalBuff()
                +a1*b1*c1*CostCoefficient.getNoc()+a1*b1*c1*d1*CostCoefficient.getRF();
    }

    /**
     * PSum积累能耗
     * @return Psum Accumulation Energy Cost
     */
    public static int psumAccumulationEnergyCost(){
        return (2*a2-1)*CostCoefficient.getDRAM()+2*a2*(b2-1)*CostCoefficient.getGlobalBuff()
                +a2*b2*(c2-1)*CostCoefficient.getNoc()+2*a2*b2*c2*(d2-1)*CostCoefficient.getRF();
    }

    /**
     * 计算能耗
     * @return Compute Cost
     */
    public static int computeCost(){
        return ComputeCost*CostCoefficient.getComputation();
    }

}
