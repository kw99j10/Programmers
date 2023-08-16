#1
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int left=0; //시작 인덱스
        int right=0; //종료 인덱스

        int sum=0; //시작 인덱스부터 종료 인덱스까지의 합
        int min=1000001; //나올 수 있는 최대값

        //cf)조건문의 순서 중요
      
        while (true) {

            if (sum >= k) {
                if (sum == k) {
                    if (min > right - left) { 
                        min = right - left; //길이가 제일 짧은 인덱스 범위를 리턴하기 위함
                        answer[0] = left;
                        answer[1] = right - 1;
                    }
                }
                sum -= sequence[left]; //sum>k이면 합이 k를 넘었으므로 시작 인덱스를 뺀 후 증가
                left += 1;
            }
            else if (right == sequence.length) {
                break; //종료 인덱스가 배열의 길이에 도달하면 종료
            }
            else {
                sum += sequence[right]; //sum이 k보다 작으므로 종료 인덱스를 더한 후 증가
                right += 1;
            }
        }
        return answer;
    }
}
