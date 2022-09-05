package OS;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PSum {
    @Test
    public void pSum(){
        double[][] weight = {{1,2},{3,4}};
        double[][] ifmap = {{1,2,3},{2,3,4},{3,4,5}};
        double[][] PSum = Conv.conv(weight,ifmap);
        for (int i = 0; i < PSum.length; i++) {
            System.out.println(Arrays.toString(PSum[i]));
        }
    }
}
