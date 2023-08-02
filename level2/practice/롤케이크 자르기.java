import java.util.*;
class Solution {
    public int solution(int[] topping) {
       
        int answer=0;
        
        var topping_kind=new HashSet<Integer>(); //토핑의 종류를 담을 set 자료구조
        
        var topping_count=new HashMap<Integer,Integer>(); //종류별 토핑의 수를 담을 map 자료구조

        //cf) set, set 으로 구간 나누어서 while문 돌릴 시 시간 초과 발생
        
        for(int i=0;i<topping.length;i++){
            topping_count.put(topping[i],topping_count.getOrDefault(topping[i],0)+1);
        }
        
        for(int i=0;i<topping.length;i++){
            topping_kind.add(topping[i]);
            topping_count.put(topping[i],topping_count.getOrDefault(topping[i],0)-1); // 차례에 해당하는 번호의 count를 제거
            
            if(topping_count.get(topping[i])==0){
                topping_count.remove(topping[i]); //count가 0이면 topping이 set으로 넘어갔으므로 토핑(키)을(를) 제거
            }
            if(topping_kind.size()==topping_count.size()){
                answer+=1;
            }
        }
        return answer;
    }
}
