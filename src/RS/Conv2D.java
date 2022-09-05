package RS;

import Dao.Cost;
import Dao.WeightCostInput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Conv2D {
//    public static double[][] ifmap;
//    public static double[][] filter;
//
//    public Conv2D(double[][] ifmap, double[][] filter) {
//        this.ifmap = ifmap;
//        this.filter = filter;
//    }

    public static List<List<double[]>> conv2d(double[][] ifmap, double[][] filter){
//        Map[][] res1 = PE.pe(ifmap, filter);
//        double[][][][] res1 = PE.pe(ifmap,filter);
        List<List<double[]>> ans = new ArrayList<>();
        for (int i = 0; i < filter.length; i++) {
            ans.add(new ArrayList<>());
            for (int j = 0; j < ifmap.length- filter.length+1; j++) {
                ans.get(i).add(Conv1D.conv1d(ifmap[i+j],filter[i]));
                if (i==0){
                    WeightCostInput.c++;
                }
            }
        }
        WeightCostInput.d+=ifmap[0].length-filter[0].length+1;

//        for (int i = 0; i < ans.size(); i++) {
//            for (int j = 0; j < ans.get(i).size(); j++) {
//                System.out.println(Arrays.toString(ans.get(i).get(j)));
//            }
//        }
        return ans;
    }
}
