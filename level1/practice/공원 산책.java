class Solution {
    public int[] solution(String[] park, String[] routes) {
    
        
         int h=0; //세로방향 좌표
        int w=0; //가로방향 좌표
        String [][]map=new String[park.length][park[0].length()];

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                char c = park[i].charAt(j);
                if(c=='S'){
                    h=i;
                    w=j;
                }
                map[i][j] = String.valueOf(c); //시작점 저장
            }
        }
        for(String st : routes) {
            String []k=st.split(" ");
            String op = k[0]; /방향
            int n = Integer.parseInt(k[1]); //이동 거리

            int x = w; //x좌표
            int y = h; //y좌표

            for (int i = 1; i <= n; i++) {
                if (op.equals("E")) {
                    x+=1;
                }
                if (op.equals("W")) {
                    x-=1;
                }
                if (op.equals("S")) {
                    y+=1;
                }
                if (op.equals("N")) {
                    y-=1;
                }
                if (x >= 0 && y >= 0 && y < map.length && x < map[0].length) {
                    if (map[y][x].equals("X")) {
                        break;  //장애물이 있으면 멈춤(저장X)
                    }
                    if (i == n){  //범위 내에 있을 시 좌표를 저장해나감
                        w = x;
                        h = y;
                    }
                }
            }
        }
        int[] answer = new int[2];
        answer[0]=h;
        answer[1]=w;
        return answer;
    }
}
