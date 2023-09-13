import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //경로(크기)순 대로 정렬
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));

        int max = Integer.MIN_VALUE;

        for (int[] route : routes) {
            if (route[0] <= max && max <= route[1]) {
                continue; //이 범위내에 차량이 존재하면 단속용 카메라 배치 필요X
            }
            max = route[1];
            answer += 1;
        }
        return answer;
    }
}
