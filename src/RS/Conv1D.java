package RS;

//import org.junit.jupiter.api.Test;
//import java.util.Arrays;

import Dao.Cost;
import Dao.WeightCostInput;

public class Conv1D {
//    public double[] D;
//    public double[] W;
//    public conv1D(double[] D,double[] W){
//        this.D = D;
//        this.W = W;
//    }

    public static double[] conv1d(double[] D,double[] W){
        double[] P = new double[D.length-W.length+1];
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < W.length; j++) {
                P[i]+=W[j]*D[j+i];
            }
        }
//        System.out.println(Arrays.toString(P));
        return P;
    }

//    @Test
//    public void test(){
//        double[] res1 = {1,2,3,4,5,6,7};
//        double[] res2 = {1,2,3,4};
//        double[] Psum = conv1d(res1,res2);
//        System.out.println(Arrays.toString(Psum));
//    }
}
