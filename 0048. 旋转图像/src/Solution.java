/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月22日 17:11
 */
public class Solution {
    public void rotate(int[][] matrix) {
        //TODO medium
        int n= matrix.length;
        int temp ;
        for(int i= 0; i<n/2;i++){
            for(int j =0;j<n/2+(n&1);j++){
                temp=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=matrix[i][j];
                matrix[i][j]=temp;
            }
        }
    }

}
