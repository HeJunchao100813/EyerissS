package active;

public class ReLu {
    public static double[][] ReLu(double[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j]<0) array[i][j]=0.0;
            }
        }
        return array;
    }
}
