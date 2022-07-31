/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年07月29日 12:02
 */
public class Solution {
    public boolean isMatch1(String s, String p) {
        char[] pc=p.toCharArray();
        char[] sc=s.toCharArray();
        int flag=0;
        for(int i=0;i<pc.length;i++){

            if(flag==sc.length){
                int j= pc.length-1;
                while(j>=i){
                    if(pc[j--]!='*'){
                        return false;
                    }
                    j--;
                }
                return true;
            }

            if(i+1<pc.length && pc[i+1]=='*'){
                if(pc[i]=='.'){
                    if(i==pc.length-2){
                        return true;
                    }else{

                        while(flag<sc.length){
                            if((sc[flag]==pc[i+2] || pc[i+2]=='.')&&
                                    isMatch(s.substring(flag),p.substring(i+2))){
                                return true;
                            }
                            if( i+4<pc.length && pc[i+3]=='*'&&
                                    isMatch(s.substring(flag),p.substring(i+4))){
                                return true;
                            }
                            flag++;
                        }
                    }
                }else {
                    while(flag<sc.length&&sc[flag]==pc[i]){
                        if(i<pc.length-2 && (sc[flag]==pc[i+2]||pc[i+2]=='.') &&
                                isMatch(s.substring(flag),p.substring(i+2))){
                            return true;
                        }if( i+4<pc.length && pc[i+3]=='*' &&
                                isMatch(s.substring(flag),p.substring(i+4))){
                            return true;
                        }

                        flag++;
                    }
                    i++;
                }
            }

            else if(pc[i]=='.'){
                flag++;
            }else {
                if(pc[i]!=sc[flag]){
                    return false;
                }
                flag++;
            }
        }
        if(flag<s.length()){
            return false;
        }
        return true;
    }

    public boolean isMatch(String s, String p) {
        char[] sc=s.toCharArray();
        char[] pc=p.toCharArray();

        if(sc.length==0){
            for(int i=pc.length-1;i>=0;i=i-2){
                if(pc[i]!='*'){
                    return false;
                }
            }
            return true;
        }else if(pc.length==0){
            return false;
        }

        //匹配两位以上含*
        if(pc.length>1 && pc[1]=='*'){

            //匹配 .*
            if(pc.length==2){
                for(int i=0;i<sc.length;i++){
                    if (pc[0]!='.' && pc[0]!=sc[i]){
                        return false;
                    }
                }
                return true;
            }else{
                int flag =0;
                while(flag<=sc.length&& isMatch(s.substring(0,flag),p.substring(0,2))){
                    if(isMatch(s.substring(flag),p.substring(2))){
                        return true;
                    }
                    flag++;
                }
            }
        }else if(pc[0]==sc[0]||pc[0]=='.'){
            return isMatch(s.substring(1),p.substring(1));
        }
        return false;
    }


    //动态规划是你爹
    public boolean isMatchByDP(String s,String p){
        return false;
    }


    public static void main(String[] args) {
        boolean ccbbcabcbbaabaccc = new Solution().isMatch("aa"
                ,"b*a*c*");
        System.out.println(ccbbcabcbbaabaccc);


    }
}
