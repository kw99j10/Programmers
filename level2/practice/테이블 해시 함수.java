import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        
        //col열 기준 오름차순 정렬 -> 같다면 1번째 컬럼값 기준 내림차순 정렬
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) {
                return o2[0] - o1[0];
            }
            return o1[col - 1] - o2[col - 1];
        });

        int bitSum = 0; //XOR 연산을 위한 비트 합 변수

        //begin ~ end 까지 나머지 합 구하기
        for (int i = row_begin - 1; i < row_end; i++) {
            int[] tmp = data[i]; //i번째 데이터
            int sum = 0; //나머지의 합
            for (int k : tmp) {
                sum += k % (i + 1);
            }
            bitSum = bitSum ^ sum; //bitwise XOR 해시값 반환
        }
        return bitSum;
    }
}
