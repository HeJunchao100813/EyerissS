package RS;

import java.util.HashMap;
import java.util.Map;

public class PE {
    public static Map[][] pe(double[][] ifmap,double[][] filter){
        Map<double[],double[]>[][] res = new HashMap[filter.length][ifmap.length- filter.length+1];
//        Map<Double[],Double[]> map = new HashMap<>();
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j].put(filter[i],ifmap[i+j]);
            }
        }
        return res;
    }
}
