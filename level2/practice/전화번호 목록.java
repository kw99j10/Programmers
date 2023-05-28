import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        var h=new HashSet<String>();
        for(String s:phone_book){
            h.add(s);
        }
        for(String s:phone_book){
    
            //부분 문자열을 이용
            for(int i=0;i<s.length();i++){
                if(h.contains(s.substring(0,i))){
                    answer=false;
                }
            }
        }
        return answer;
    }
}
