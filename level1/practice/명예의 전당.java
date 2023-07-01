import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        
        var a=new ArrayList<Integer>(); //최하위 점수를 제거하기 위한 리스트
        
        var t=new ArrayList<Integer>(); //일차 별로 최하위 점수를 리턴하는 리스트
        
        for(int i=0;i<score.length;i++){
            
            a.add(score[i]);
            Collections.sort(a); //최하위 점수를 알아내기 위해 정렬
            if(a.size()>k){
                a.remove(a.get(0)); //최하위 점수를 제거
            }
            t.add(a.get(0));
        }
        int[] answer = new int[t.size()];
        for(int i=0;i<t.size();i++){
            answer[i]=t.get(i);
        }
        return answer;
    }
}
