import java.util.*;
class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        var s=new HashSet<String>(); //보석의 종류
        var h=new HashMap<String,Integer>(); //보석의 개수
        var q=new LinkedList<String>(); //중복되는 보석의 개수
        
        //모든 보석을 구매하기 위해 set에 전체 보석 개수 저장 (중복 X)
        for(int i=0;i<gems.length;i++){
            s.add(gems[i]);
        } 
        
        int location=0; //현재 위치(배열 인덱스가 0부터)
        int start=0; //구간의 시작점
        int end=100000; //구간의 종료점
        
        for(int i=0;i<gems.length;i++){
            h.put(gems[i],h.getOrDefault(gems[i],0)+1);
            q.offer(gems[i]);
            
            //중복 값에 대한 범위 검사
            while(true){
                  String tmp=q.peek();
                  
                  if(h.get(tmp)<=1){
                      break; //값이 1개있다면 종료
                  }
                  h.put(tmp,h.getOrDefault(tmp,0)-1);
                  q.poll();
                  location+=1; //중복이 있다면 앞에서부터 제거하며 위치를 증가해 나감 
            }

            
            if(s.size()==h.size() && end>q.size()){ // (end>q.size())조건: 시작 진열대 번호가 가장 작은 구간을 구하기 위함
                end=q.size();
                start=location; //보석의 종류와 개수가 같아졌다면 해당 범위까지를 구간으로 설정함
            }
        }
        
        answer[0]=start+1; //index가 0부터 시작이므로 시작점에 +1
        answer[1]=start+end;
        return answer;
    }
}
