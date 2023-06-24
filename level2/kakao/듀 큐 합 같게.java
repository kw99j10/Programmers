import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        int answer=0;
        
        var qa=new LinkedList<Long>(); //배열을 담을 큐(LinkedList) 생성
        var qb=new LinkedList<Long>();

        long sum1=0L;
        long sum2=0L;

        for(int i=0;i<queue1.length;i++){
            sum1+=queue1[i];
            sum2+=queue2[i];
            qa.add((long) queue1[i]);
            qb.add((long) queue2[i]);
        }

        long total=sum1+sum2;

        if(total%2!=0){
            answer=-1; //total이 홀수이면 두 큐는 합이 같을 수 없음
        }

        while (true) {

            if (sum1==sum2){
                break;
            }
            if (answer>600000){
                answer=-1; //answer의 최댓값은 두 큐의 최대 길이보다 클 수 없음 --> 크다면 두 큐의 합은 같을 수 없음
                break;
            }
            if (sum1<sum2){
                qa.addLast(qb.pollFirst()); //한 쪽 큐가 다른 쪽 큐보다 크다면 그 큐의 첫번째 요소를 제거하여 다른 쪽 큐에 넣는다.(answer 1회)
                sum1+=qa.getLast(); //비교에 따른 합 또한 바뀐다.
                sum2-=qa.getLast();
            }
            else {
                qb.addLast(qa.pollFirst());
                sum2+=qb.getLast();
                sum1-=qb.getLast();
            }
            answer+=1;
        }
        return answer;
    }
}
