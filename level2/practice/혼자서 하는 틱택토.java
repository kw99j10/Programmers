class Solution {
    //경우의 수 문제 
    public int solution(String[] board) {
        int answer = 1;

        int first = 0; //선공의 개수
        int second = 0; //후공의 개수

        int first_clear = 0; //선공의 한줄 개수
        int second_clear = 0; //후공의 한줄 개수

        for (int i = 0; i < board.length; i++) {
            String s = board[i];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'O') {
                    first += 1;
                }
                if (c == 'X') {
                    second += 1;
                }
            }

            //선공 한줄 
            //세로 한줄
            if (board[i].charAt(0) == 'O' && board[i].charAt(1) == 'O' && board[i].charAt(2) == 'O') {
                first_clear += 1;
            }
            //가로 한줄
            if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') {
                first_clear += 1;
            }

            //대각선
            if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') {
                first_clear += 1;
            }
            if (board[2].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[0].charAt(2) == 'O') {
                first_clear += 1;
            }
            
            //후공 한줄
            //세로 한줄
            if (board[i].charAt(0) == 'X' && board[i].charAt(1) == 'X' && board[i].charAt(2) == 'X') {
                second_clear += 1;
            }
            //가로 한줄
            if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') {
                second_clear += 1;
            }

            //대각선
            if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') {
                second_clear += 1;
            }
            if (board[2].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[0].charAt(2) == 'X') {
                second_clear += 1;
            }
        }

        //불가능한 경우의 수를 구함
        
        //후공의 개수 > 선공의 개수 인 경우
        if (second > first) {
            answer = 0;
        }
        
        //선공의 개수 - 후공의 개수가 0 or 1이 아닐 경우
        if (first - second > 1) {
            answer = 0;
        }
        
        //선공, 후공 둘다 줄이 만들어질 경우

        if (first_clear > 0 && second_clear > 0) {
            answer = 0;
        }
        
        //선공의 줄이 만들어질 때 후공의 개수와 같은 경우
        if (first_clear > 0) {
            if (first == second) {
                answer = 0;
            }
        }
        
        //후공의 줄이 만들어질 때 선공의 개수가 더 많은 경우
        if (second_clear > 0) {
            if (first == second) {
                answer = 0;
            }
        }

        return answer;
    }
}
