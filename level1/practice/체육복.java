import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
    
        var h=new HashSet<Integer>();
        for(int i=0;i<reserve.length;i++){
            h.add(reserve[i]);
        }
        
        //중복 제거: 여분을 갖고 있는 학생이 도난당할 수 있으므로 lost에 포함된 reserve 값을 지운다.
        var t=new HashSet<Integer>();
        for (int j : lost) {
            if (h.contains(j)) {
                h.remove(j);
            }
            else{
                t.add(j);
            }
        }
        
        //reserve 중에서 j-1 or j+1값과 일치하면 해당 lost 값을 제거
        for (int j : h) {
            if (t.contains(j - 1)) {
                t.remove(j - 1);
            } else t.remove(j + 1);
        }
        int answer=n-t.size();
        return answer;
    }
}
