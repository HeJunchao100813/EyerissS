import Dao.Cost;
import Dao.Input;
import RLC.Compress;
import RLC.Decompress;
import RS.Conv2D;
import RS.PSum;
import active.MaxPool;
import active.ReLu;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    @Test
    public void test(){
        System.out.println("Hello World!");
        System.out.println("12345");
    }

    @Test
    public void reLuTest(){
        double[][] numTest = {{1.2,-4.5},{0,-2}};
        numTest = ReLu.ReLu(numTest);
        for (int i = 0; i < numTest.length; i++) {
            System.out.println(Arrays.toString(numTest[i]));
        }
    }

    @Test
    public void maxPoolTest() throws Exception {
        double[][] numTest = {{1.2,-4.5,0},{0,-2,7},{3,4,1}};
        numTest = MaxPool.maxPool(numTest,3);
        for (int i = 0; i < numTest.length; i++) {
            System.out.println(Arrays.toString(numTest[i]));
        }
    }

    @Test
    public void daoTest(){
        double[][] weight = {{1,2},{3,4}};
        double[][] ifmap = {{1,2,3},{2,3,4},{3,4,5}};
        Input input = new Input(weight,ifmap);
        Cost.a1=1;
        Cost.b1=1;
        Cost.c1=1;
        Cost.ComputeCost=1;
        Cost.d1=1;
        Cost.a2=1;
        Cost.b2=1;
        Cost.c2=1;
        Cost.d2=1;
        System.out.println(Cost.inputDataAccessEnergyCost());
        System.out.println(Cost.psumAccumulationEnergyCost());
        System.out.println(Cost.computeCost());
    }

    @Test
    public void RSTest(){
        double[][] weight = {{1,2},{3,4}};
        double[][] ifmap = {{1,2,3},{2,3,4},{3,4,5}};
        Input input = new Input(weight,ifmap);
        double[][] res = PSum.psum(Conv2D.conv2d(input.getIfmap(),input.getFilerWeight()));
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    @Test
    public void rLCTest() throws Exception {
        double[][] weight = {{1,2},{3,4}};
        weight = Compress.compress(weight);
        for (int i = 0; i < weight.length; i++) {
            System.out.println(Arrays.toString(weight[i]));
        }
        weight = Decompress.decompress(weight);
        for (int i = 0; i < weight.length; i++) {
            System.out.println(Arrays.toString(weight[i]));
        }
    }

    @Test
    public void wSTest(){
        return;
    }

    @Test
    public void oSTest(){
        return;
    }

    @Test
    public void nLRTest(){
        return;
    }

    @Test
    public void iSTest(){
        return;
    }

    @Test
    public void tesy(){
        Deque<Integer> deque = new LinkedList<>();
    }

}
