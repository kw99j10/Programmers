import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
      
        Arrays.sort(A);
        Arrays.sort(B); //최소한의 점수차로 승점을 얻기 위해 두 배열 모두 정렬
      
        var b=new ArrayList<Integer>();
      
        for(int i=0;i<B.length;i++){
            b.add(B[i]);
        }        
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = b.size() - 1; j >= 0; j--) {
                if (A[i] < b.get(j)) {
                    answer += 1;
                    b.remove(j);
                    break; //승리한다면 b에서 해당 숫자를 제거 후 다음 경기
                }
            }
        }
        return answer;
    }
}
