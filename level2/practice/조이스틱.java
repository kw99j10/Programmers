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
        int move = name.length() - 1; //좌, 우 움직임 변수(기본 값은 순서대로 처리)

        //좌,우 값 비교하여 좌,우 조이스틱 조작 경우의 수
        for (int i = 0; i < name.length(); i++) {

            next = i + 1;

            //연속되는 A의 개수 확인
            //(좌,우 이동방향 결정: 연속된 A의 개수 기준 정방향, 역방향 실행)
            while (next < name.length() && name.charAt(next) == 'A') {
                next += 1;
            }

            //i*2하는 이유: A가 나오기 전까지의 앞 부분(왕복)
            //name.length()-next: A가 나오기전 까지의 뒷 부분, 기존 move 변수는 순서대로 세는 경우의 수
            //계산 순서: i*2 부분 -> name.length()-next
            move = Math.min(move, i * 2 + (name.length() - next));
            
            // "BBBBAAAAAAAB" 처럼 뒤로 세는 경우의 수만 존재할 때를 고려
            move = Math.min(move, i + 2 * (name.length() - next));
        }
        answer += move;      
        return answer;
    }
}
