class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int idx = 0; // 현재 검사하는 위치
        int position = 1; // 기지국 설치(해야 할지 판단할)위치 (아파트가 1부터 시작하므로 1부터 시작)

        //주어진 아파트 개수의 범위까지 반복문 실행
        while (position<=n){

            if (idx<stations.length && position>=stations[idx]-w) {
                position = stations[idx] + w + 1; // 해당 위치가 기지국 범위(stations[idx]+w,stations[idx]-w) 에 존재한다면 범위 밖으로 이동
                idx += 1; // 이동 후 배열 인덱스 증가
            }
            else {
                answer += 1; 
                position += 2 * w + 1; //현재 위치에 기지국이 없고 +w,-w를 만족한다면 기지국을 설치한 후 영향을 받지 않는 범위 밖으로 이동
            }
        }

        return answer;
    }
}
