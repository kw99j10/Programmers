import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        var a=new LinkedList<String>(); //도시 이름 리스트
        
        if(cacheSize==0){
            return cities.length*5;
        }
        for(int i=0;i<cities.length;i++){
        
            //대소문자 구분 x -> 도시 이름 소문자 통일
            String s=cities[i].toLowerCase();
        
            //이미 캐시에 존재하는 도시 이름==>삭제 후 다시 넣어줌(LRU 알고리즘 만족 위함), cache hit 이므로 시간+1
            if(a.contains(s)){
                answer+=1;
                a.remove(s);
            }
           
            //캐시에 존재하는 도시 이름X==> 캐시 사이즈와 리스트 사이즈가 같다면 첫 도시를 삭제(가장 예전에 사용), cache miss 이므로 시간+5 -->제거 후 새 도시 이름 추가
            else{
                if(cacheSize==a.size()){
                    a.removeFirst();
                }
                answer+=5;
            }
            a.add(s);
        }
        return answer;
    }
}
