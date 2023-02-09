public class JavaBasics {

  public static int countDiagonal(int matrix[][]) {
    int count = 0;
    for (int i = 0 ; i < matrix.length ; i++) {
        if (i != matrix.length - 1 - i) {
            count += matrix[i][matrix.length - 1 - i];
        }
        count += matrix[i][i];
        
    }
    return count;
  }
  
    public static void main (String args[]) {
        int matrix[][] = { {1,2,3,4,0},
                           {5,6,7,8,0},
                           {9,10,11,12,0},
                           {13,14,15,16,0},
                           {0,0,0,0,0}};
        System.out.println(countDiagonal(matrix));
    }
}