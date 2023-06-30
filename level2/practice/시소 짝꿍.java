//반복문 풀이
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        
        long answer = 0;
       
        Arrays.sort(weights); //배열 정렬(비교 최소화)
        
        long count=0; //몸무게 비가 일치하는 사람 수
        
        for(int i=0;i<weights.length-1;i++){

            /** if문 없을 시 시간 초과 발생 --> 같은 몸무게의 사람일 경우 예외 처리 필요 **/
            if (i > 0) {
                if (weights[i] == weights[i - 1]) {
                    count-=1;  //같은 몸무게일 경우 이전 반복문에서 계산 하였기 때문에 count를 1 감소
                    answer+=count; //남은 같은 몸무게를 가진 사람의 수를 더
                    continue;
                }
            }

            count=0;
            
            for(int j=i+1;j<weights.length;j++){

                if (weights[i] * 2 < weights[j]) {
                    break;  // 큰 값이 작은 값의 2배보다 클 경우 비교 불가능(시소 거리 최소 2m)
                }
                if (weights[i] * 2 == weights[j] || weights[i] == weights[j] || weights[i] * 4 == weights[j] * 3 || weights[i] * 3 == weights[j] * 2) {
                    count+=1; //(1,1), (2,1), (3,2), (4,3) 일 경우에 count
                }
            }
            answer+=count; //반복문이 끝난 후 count를 answer에 누적
        }
        return answer;
    }
}


//hash를 이용한 풀이
import java.util.*;
class Solution {
    public long solution(int[] weights) {
        
        long answer = 0;
        
        Arrays.sort(weights); //배열 정렬 필요(중복 값 방지) 
        
        var h=new HashMap<Double,Integer>();

        //배열 요소를 반복하면서 (1,1) (2,1) (3,2) (4,3) 비율에 해당하는 값을 저장 --> 포함된 key(시소에 해당하는 비율)가 있을 때 answer를 증가 시킴
        for(int i=0;i<weights.length;i++){

            double ans=(double)weights[i];

            if(h.containsKey(ans)){
                answer+=h.get(ans);
            }
            h.put(ans,h.getOrDefault(ans,0)+1);
            h.put(ans*2,h.getOrDefault(ans*2,0)+1);
            h.put(ans*3/2,h.getOrDefault(ans*3/2,0)+1);
            h.put(ans*4/3,h.getOrDefault(ans*4/3,0)+1);
        }
        return answer;
    }
}
