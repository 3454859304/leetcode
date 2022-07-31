/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月31日 11:26
 */
public class Solution {
    public String longestCommonPrefix1(String[] strs) {
        StringBuilder sb = new StringBuilder();
        char c =0;
        int flag=0;

        while(true){

            for(int i=0;i<strs.length;i++){
                if(flag>= strs[i].length()){
                    return sb.toString();
                }
                else if (c==0){
                    c=strs[i].charAt(flag);
                }else if(c!=strs[i].charAt(flag)){
                    return sb.toString();
                }
            }
            sb.append(c);
            c=0;
            flag++;

        }
    }

    public String longestCommonPrefix(String[] strs) {
        int min=strs[0].length();
        String str=strs[0];
        for(int i=1;i<strs.length;i++){
            if(strs[i].length()<min){
                min=strs[i].length();
                str=strs[i];
            }
        }
        for(int i=0;i<strs.length;i++){
            String demo=strs[i].substring(0,min);
            while(!demo.equals(str)&&min!=0){
                str=str.substring(0,--min);
                demo=demo.substring(0,min);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        String[] strs={"cir","car"};
        new Solution().longestCommonPrefix(strs);
    }
}
