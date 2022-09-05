package IS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PE {
    private double[][] ifmap;
    public PE(double[][] ifmap){
        this.ifmap = ifmap;
    }

    public Map<double[][],double[][]> pe(double[][] weight){
        Map<double[][],double[][]> map = new HashMap<>();
        map.put(ifmap,weight);
        return map;
    }

    public double[][] getIfmap() {
        return ifmap;
    }

    public void setIfmap(double[][] ifmap) {
        this.ifmap = ifmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PE pe = (PE) o;
        return Arrays.equals(ifmap, pe.ifmap);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(ifmap);
    }

    @Override
    public String toString() {
        return "PE{" +
                "ifmap=" + Arrays.toString(ifmap) +
                '}';
    }
}
