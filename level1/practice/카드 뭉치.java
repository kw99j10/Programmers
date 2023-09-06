import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "No";
        
        var c1=new LinkedList<String>();
        var c2=new LinkedList<String>();

        String t="";
        
        for(int i=0;i<cards1.length;i++){
            c1.add(cards1[i]);
        }
        
        for(int i=0;i<cards2.length;i++){
            c2.add(cards2[i]);
        }
        
        for(int i=0;i<goal.length;i++){
            
            if(c1.size()>0 && goal[i].equals(c1.getFirst())){
                t+=c1.getFirst();
                c1.removeFirst();
            }
            
            else if(c2.size()>0 && goal[i].equals(c2.getFirst())){
                t+=c2.getFirst();
                c2.removeFirst();
            }
            else{
                break;
            }
        }
        //cf) 두 배열의 요소를 모두 사용하지 않고 문자열을 완성시킬 수 있음
        String p="";
        for(int i=0;i<goal.length;i++){
            p+=goal[i];
        }
        if(p.equals(t)){
            answer="Yes";
        }
        return answer;
    }
}
