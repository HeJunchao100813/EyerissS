package OS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PE {
    Map<List<Double>,Integer> map;
    List<Double> list;
    public PE(double[] psum){
        map = new HashMap<>();
        list = new ArrayList<>();
        for (double num:psum){
            list.add(num);
        }
        map.put(list,map.getOrDefault(list,0)+1);
    }

    public Map<List<Double>, Integer> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "PE{" +
                "map=" + map +
                ", list=" + list +
                '}';
    }
}
