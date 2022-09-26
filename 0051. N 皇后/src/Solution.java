import java.util.*;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月24日 15:00
 */
public class Solution {

    /*public List<List<String>> solveNQueens(int n) {
        char[] blank = new char[n];
        for(int i =0;i<n;i++){
            blank[i]='.';
        }
        int[] queens = new int[n];
        List<List<String>> res = new ArrayList<>();
        dfs2(res, queens, n,blank, 0, 0, 0, 0);
        return res;
    }*/



    public void dfs2(List<List<String>> res, int[] queens, int n, char[] blank, int row, int columns, int diagonals1, int diagonals2) {
        if (row == n) {
            ArrayList<String> strs = new ArrayList<>();
            for(int i=0; i<n;i++){
                blank[queens[i]]='Q';
                strs.add(new String(blank));
                blank[queens[i]]='.';
            }
            res.add(strs);
        } else {
            int flag = ((1 << n) - 1) & (~(columns | diagonals1 | diagonals2));
            while (flag != 0) {
                int position = flag & (-flag);
                flag = flag & (flag - 1);
                int column = Integer.bitCount(position - 1);
                queens[row] = column;
                dfs2(res, queens, n, blank,row + 1, columns | position, (diagonals1 | position) << 1, (diagonals2 | position) >> 1);
            }
        }
    }

    private void dfs(int row, int n, List<List<String>> res, int[] queen,char[]blank) {
        if(row==n){
            ArrayList<String> strs = new ArrayList<>();
            for(int i=0; i<n;i++){
                blank[queen[i]]='Q';
                strs.add(new String(blank));
                blank[queen[i]]='.';
            }
            res.add(strs);
        }else{
            for(int i=0;i<n;i++){
                boolean flag = true;
                for(int j=0; j<row;j++){
                    if(i==queen[j] || i==(queen[j]-j+row) || i==(queen[j]+j-row)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    queen[row]=i;
                    dfs(row+1,n,res,queen,blank);
                }
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[] blank = new char[n];
        for(int i =0;i<n;i++){
            blank[i]='.';
        }
        int[] queens = new int[n];
        boolean[] columns = new boolean[n];
        boolean[] diagonals1 = new boolean[2*n-1];
        boolean[] diagonals2 = new boolean[2*n-1];
        List<List<String>> res = new ArrayList<>();
        dfs1(res, queens,blank, 0, n, columns,diagonals1 , diagonals2);
        return res;
    }
    private void dfs1(List<List<String>> res, int[] queens,char[]blank, int row, int n,  boolean[] columns,boolean[] diagonals1,boolean[] diagonals2) {
        if(row==n){
            ArrayList<String> strs = new ArrayList<>();
            for(int i=0; i<n;i++){
                blank[queens[i]]='Q';
                strs.add(new String(blank));
                blank[queens[i]]='.';
            }
            res.add(strs);
        }else{
            for(int i=0;i<n;i++){
                if(columns[i]){
                    continue;
                }
                int diff = row - i+n-1;
                if (diagonals1[diff]) {
                    continue;
                }
                int sum = row + i;
                if (diagonals2[sum]) {
                    continue;
                }
                queens[row] = i;
                columns[i]=true;
                diagonals1[diff]=true;
                diagonals2[sum]=true;
                dfs1(res,queens,blank,row+1,n,columns,diagonals1,diagonals2);
                columns[i]=false;
                diagonals1[diff]=false;
                diagonals2[sum]=false;
            }
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(4);
    }
}
