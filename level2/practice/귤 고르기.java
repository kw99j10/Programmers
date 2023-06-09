import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        var h=new HashMap<Integer,Integer>();
        
        //들어갈 귤의 크기에 따른 개수는 누적
        for(int i:tangerine){
            h.put(i,h.getOrDefault(i,0)+1);
        }
        var a=new ArrayList<Integer>(h.keySet());
        
        //서로 다른 종류의 수를 최소로 하므로 내림차순 정렬
        Collections.sort(a, (o1, o2) -> (h.get(o2).compareTo(h.get(o1))));
        
        int count=k;
        int i=0;
        while(true){
            if(count<=0){
                break;
            }
            count-=h.get(a.get(i));
            answer+=1;
            i+=1;
        }
        return answer;
    }
}
