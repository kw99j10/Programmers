import java.util.*;
class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        
        String[][] ans = new String[wallpaper.length][wallpaper[0].length()]; wallpaper의 x좌표와 y좌표를 담을 2차원 배열

        var a = new ArrayList<Integer>(); //x좌표를 담을 list
        var b = new ArrayList<Integer>(); //y좌표를 담을 list
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);
                ans[i][j] = String.valueOf(c);
            }
        }
        
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                if (ans[i][j].equals("#")) {
                    a.add(i);
                    b.add(j); //"#"가 나타난 좌표를 list에 모두 담음
                }
            }
        }
        Collections.sort(a);
        Collections.sort(b);
        answer[0] = a.get(0);
        answer[1] = b.get(0);
        answer[2] = a.get(a.size() - 1) + 1; // 드래그 하기 위해서는 나타난 "#" 좌표보다 1씩 커야 함
        answer[3] = b.get(a.size() - 1) + 1;
        return answer;
    }
}
