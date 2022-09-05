package RLC;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class CompressTest {

    @Test
    public void compressTest() throws Exception {
//        double[][] test = {{1,2,3},{4,5,6},{7,8,9}};
//        double[][] test = {{0,1,4},{0,1,1},{0,1,1}};
        double[][] test = {{0,2,0,1},{0,3,0,1},{0,6,0,1},{0,4,0,2}};
        System.out.println("压缩前：");
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
        test = Compress.compress(test);
        System.out.println("压缩后：");
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }
        test = Decompress.decompress(test);
        System.out.println("解压后：");
        for (int i = 0; i < test.length; i++) {
            System.out.println(Arrays.toString(test[i]));
        }

    }
}
