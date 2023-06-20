import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        var h=new PriorityQueue<Integer>();
        for(int i=0;i<scoville.length;i++){
            h.add(scoville[i]);
        }
      
        //최솟값>=k이거나 heap의 사이즈<=1이면 종료
      
        while (h.size() > 1 && h.peek() < k) {

            for (Integer ignored : h) {
                h.add(h.poll() + (h.element() * 2));
                h.remove(h.element());
                answer += 1;
                break;
            }
        }
        return h.peek() < K ? -1 : answer; //heap의 사이즈가 1이면 최솟값<k인 상태로 종료한 상태
    }
}
