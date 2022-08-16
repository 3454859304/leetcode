/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月15日 14:56
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row =new int[9][9];
        int[][] col =new int[9][9];
        int[][][] box= new int[3][3][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int index=board[i][j]-'0'-1;
                    row[i][index]++;
                    col[j][index]++;
                    box[i / 3][j / 3][index]++;
                    if(row[i][index]>1||col[j][index]>1||box[i/3][j/3][index]>1){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
