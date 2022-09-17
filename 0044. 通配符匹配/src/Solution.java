/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年09月08日 15:19
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();
        int n=s.length();
        int m=p.length();
        boolean[][] pd = new boolean[n+1][m+1];
        pd[0][0]=true;
        for(int i=1;i<m+1;i++){
            if(pc[i-1]=='*'){
                pd[0][i]=true;
            }else break;
        }
        for(int i = 1;i < n+1;i++ ){
            for(int j = 1;j < m+1;j++){
                if(pc[j-1]=='*'){
                    pd[i][j]=pd[i][j-1]||pd[i-1][j];
                }else if(pc[j-1]=='?'||pc[j-1]==sc[i-1]){
                    pd[i][j]=pd[i-1][j-1];
                }
            }
        }
        return pd[n][m];
    }
}
