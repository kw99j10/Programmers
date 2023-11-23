class Solution {
    public int[] solution(String s) {
        
        int[] answer = new int[s.length()];

        boolean[] b = new boolean[26]; //알파벳이 나온 경우를 체크

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            //처음 나온 알파벳 -> -1로 표현
            if (!b[c - 97]) {
                b[c - 97] = true;
                answer[i] = -1;
            }
            
            //이미 존재하는 경우
            else {
                int dif = 0;
                for (int j = i - 1; j >= 0; j--) {
                    dif += 1;
                    if (s.charAt(j) == c) {
                        answer[i] = dif;
                        break;
                    }
                }
            }
        }
        
        return answer;
    }
}
