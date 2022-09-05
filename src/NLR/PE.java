package NLR;

import java.util.*;

public class PE {
    List<List<Double>> weight;
    List<List<Double>> ifmap;
    Map<List<List<Double>>, List<List<Double>>> map;

    public PE(double[][] weight, double[][] ifmap) {
        map = new HashMap<>();
        this.weight = new ArrayList<>();
        this.ifmap = new ArrayList<>();
        for (int i = 0; i < weight.length; i++) {
            this.weight.add(new ArrayList<>());
            for (int j = 0; j < weight[0].length; j++) {
                this.weight.get(i).add(weight[i][j]);
            }
        }
        for (int i = 0; i < ifmap.length; i++) {
            this.ifmap.add(new ArrayList<>());
            for (int j = 0; j < ifmap[0].length; j++) {
                this.ifmap.get(i).add(ifmap[i][j]);
            }
        }
    }

    public Map<List<List<Double>>,List<List<Double>>> pe(){
        map.put(weight,ifmap);
        return map;
    }

    public List<List<Double>> getWeight() {
        return weight;
    }

    public void setWeight(List<List<Double>> weight) {
        this.weight = weight;
    }

    public List<List<Double>> getIfmap() {
        return ifmap;
    }

    public void setIfmap(List<List<Double>> ifmap) {
        this.ifmap = ifmap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PE pe = (PE) o;
        return Objects.equals(weight, pe.weight) && Objects.equals(ifmap, pe.ifmap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, ifmap);
    }

    @Override
    public String toString() {
        return "PE{" +
                "weight=" + weight +
                ", ifmap=" + ifmap +
                '}';
    }
}
