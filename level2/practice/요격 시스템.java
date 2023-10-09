import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        //구간 범위 끝 값(e)가 큰 순서대로 정렬
        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        int max = 0; //구간 값 비교 변수

        for (int[] target : targets) {
            if (target[0] >= max) {
                max = target[1];
                answer += 1;
            }
        }
        return answer;
    }
}
