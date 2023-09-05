class Solution {
    public int solution(String name) {
        int answer = 0;

        //위, 아래의 조이스틱 조작 경우의 수
        for (int i = 0; i < name.length(); i++) {

            int move = name.charAt(i) - 'A';
            if (move > 13) {
                move = 26 - move;
            }
            answer += move;
        }

        int next; //현재 값 기준 다음 값
        int move = name.length() - 1; //좌, 우 움직임 변수

        //좌,우 값 비교하여 좌,우 조이스틱 조작 경우의 수
        for (int i = 0; i < name.length(); i++) {

            next = i + 1;

            //연속되는 A의 개수 확인(좌,우 이동방향 결정)
            while (next < name.length() && name.charAt(next) == 'A') {
                next += 1;
            }

            move = Math.min(move, i * 2 + name.length() - next); //정주행, 역주행 판단
            move = Math.min(move, (name.length() - next) * 2 + i); //처음부터 역주행할 경우를 판단
            //ex) BBBBAAB와 같이 연속된 A개수 기준 앞 부분이 뒷 부분보다 길다면 뒷 부분부터 계산
        }
        answer += move;      
        return answer;
    }
}
