package Dao;

public class IfmapCostInput {
    public int a=0;
    public int b=0;
    public int c=0;
    public int d=0;

    public IfmapCostInput(int a, int b, int c, int d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public IfmapCostInput() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int inputDataAccessEnergyCost(){
        int res = a*CostCoefficient.DRAM+a*b*CostCoefficient.GlobalBuff+a*b*c*CostCoefficient.Noc+
                a*b*c*d*CostCoefficient.RF;
        return res;
    }
}
