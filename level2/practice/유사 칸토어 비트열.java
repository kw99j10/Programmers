class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        //구간 [l,r] 탐색
        for (long i = l - 1; i < r; i++) {
            answer += check(n, i);
        }
        return answer;
    }

    static int check(int n, long i) {

        //n이 0이거나 구간의 시작이 0이면 무조건 1을 리턴
        if (n == 0 || i == 0) {
            return 1;
        }

        //인덱스 상으로 2번째 값에만 0이 모두 포함 -> 00000
        if (i % 5 == 2) {
            return 0; //개수 count x
        }

        return check(n - 1, i / 5);
    }
}
