import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述
 *
 * @author: PJY
 * @date: 2022年08月01日 11:47
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return new ArrayList<>();
        }

        char[][] chars = new char[8][];
        chars[0]= new char[]{'a','b','c'};
        chars[1]= new char[]{'d','e','f'};
        chars[2]= new char[]{'g','h','i'};
        chars[3]= new char[]{'j','k','l'};
        chars[4]= new char[]{'m','n','o'};
        chars[5]= new char[]{'p','q','r','s'};
        chars[6]= new char[]{'t','u','v'};
        chars[7]= new char[]{'w','x','y','z'};

        ArrayList<String> strings = new ArrayList<>();
        char[] cd=digits.toCharArray();
        getStrings(strings,chars,0,cd,new StringBuilder());
        return strings;

    }

    public void getStrings(List<String> strings,char[][] charss,int  index, char[] cd,StringBuilder str){
        if(index==cd.length){
            strings.add(str.toString());
        }else{
            char[] chars=charss[cd[index]-'2'];
            for(int i=0;i<chars.length;i++){
                str.append(chars[i]);
                getStrings(strings,charss,index+1,cd,str);
                str.deleteCharAt(index);
            }
        }
    }

    public char[] getCharList(char c){
        switch (c){
            case '2': return new char[]{'a','b','c'};
            case '3': return new char[]{'d','e','f'};
            case '4': return new char[]{'g','h','i'};
            case '5': return new char[]{'j','k','l'};
            case '6': return new char[]{'m','n','o'};
            case '7': return new char[]{'p','q','r','s'};
            case '8': return new char[]{'t','u','v'};
            case '9': return new char[]{'w','x','y','z'};
            default: return null;
        }
    }

    public static void main(String[] args) {
        new Solution().letterCombinations("23");
    }
}
