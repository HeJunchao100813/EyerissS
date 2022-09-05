package WS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PE {
    private double[][] weight;
    public PE(double[][] weight){
        this.weight = weight;
    }

    public Map<double[][],double[][]> pe(double[][] ifmap){
        Map<double[][],double[][]> map = new HashMap<>();
        map.put(weight,ifmap);
        return map;
    }

    public void setWeight(double[][] weight) {
        this.weight = weight;
    }

    public double[][] getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PE pe = (PE) o;
        return Arrays.equals(weight, pe.weight);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(weight);
    }

    @Override
    public String toString() {
        return "PE{" +
                "weight=" + Arrays.toString(weight) +
                '}';
    }
}
