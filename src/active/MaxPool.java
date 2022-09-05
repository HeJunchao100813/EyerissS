package active;

public class MaxPool {
    public static double[][] maxPool(double[][] array,int kSize) throws Exception {
        int line = array[0].length;
        int row = array.length;
        if (line%kSize!=0&&row%kSize!=0){
            throw new Exception("kSize参数错误");
        }
        double[][] res = new double[row/kSize][line/kSize];
        for (int i = 0; i <= row-kSize; i+=kSize) {
            for (int j = 0; j <= line-kSize; j+=kSize) {
                res[i/kSize][j/kSize] = max(array,i,j,kSize);
            }
        }
        return res;
    }
    public static double max(double[][] array, int row,int line,int kSize){
        double res = Integer.MIN_VALUE;
//        double res = Double.MIN_VALUE;
        for (int i = row; i < row+kSize; i++) {
            for (int j = line; j < line+kSize; j++) {
                res = Math.max(res,array[i][j]);
            }
        }
        return res;
    }
}
