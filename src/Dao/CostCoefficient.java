package Dao;

/**
 * 成本系数
 */
public class CostCoefficient {

    public static final int computation = 1;
    public static final int RF = 1;
    public static final int Noc = 2;
    public static final int GlobalBuff = 6;
    public static final int DRAM = 200;

    public CostCoefficient() {
    }

    public static int getComputation() {
        return computation;
    }

    public static int getRF() {
        return RF;
    }

    public static int getNoc() {
        return Noc;
    }

    public static int getGlobalBuff() {
        return GlobalBuff;
    }

    public static int getDRAM() {
        return DRAM;
    }

}
