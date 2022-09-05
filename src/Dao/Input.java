package Dao;

import java.util.Arrays;

/**
 * 输入权重和图片像素fmap
 */
public class Input {

    public double[][] filerWeight;
    public double[][] ifmap;

    public Input() {
    }

    /**
     * 构造方法，输入滤波器权重和ifmap
     * @param filerWeight
     * @param ifmap
     */
    public Input(double[][] filerWeight, double[][] ifmap) {
        this.filerWeight = filerWeight;
        this.ifmap = ifmap;
//        Cost.a1++;
    }

    public double[][] getFilerWeight() {
        return filerWeight;
    }

    public void setFilerWeight(double[][] filerWeight) {
        this.filerWeight = filerWeight;
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
        Input input = (Input) o;
        return Arrays.equals(filerWeight, input.filerWeight) && Arrays.equals(ifmap, input.ifmap);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(filerWeight);
        result = 31 * result + Arrays.hashCode(ifmap);
        return result;
    }

    @Override
    public String toString() {
        return "input{" +
                "filerWeight=" + Arrays.toString(filerWeight) +
                ", ifmap=" + Arrays.toString(ifmap) +
                '}';
    }
}
