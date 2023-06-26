import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        var h=new LinkedHashMap<String,Integer>();
        for(int i=0;i<players.length;i++){
            h.put(players[i],h.getOrDefault(players[i],i));
        }

        //**원리: map에 저장된 변수의 index를 불러와 앞의 선수와 값을 swap 함
      
         for (String calling : callings) {

            int tmp = h.get(calling); //**map의 index(현재 등수)를 불러 옴

            String k = players[tmp - 1]; //앞에 있는 선수를 불러 옴

            players[tmp - 1] = calling;
            players[tmp] = k; //앞 뒤 선수 swap

            h.put(calling, tmp - 1); //swap 후 선수의 value를 -1로 (등수 +1) 갱신
            h.put(k, tmp);
        }
        System.arraycopy(players, 0, answer, 0, answer.length);
        return answer;
    }
}
