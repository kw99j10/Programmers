class Solution {
    public static boolean []b=new boolean[8]; //해당 요소를 방문하였는지 확인하기 위한 boolean형 배열
    public static int answer=0;
    public int solution(int k, int[][] dungeons) {
        
        b = new boolean[dungeons.length];
        dfs(k,dungeons); //완전탐색
        return answer;
    }
    static void dfs(int k, int[][] dungeons) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!b[i] && k >= dungeons[i][0]) { //방문하지 않았고 최소 피로도 보다 크거나 같은 경우 던전에 들어갈 수 있음
                b[i] = true;
                dfs(k - dungeons[i][1], dungeons); //소모 피로도를 빼면서 탐색을 진행
                b[i]=false;
            }
        }

        int count = 0;
        for (boolean b1 : b) {
            if (b1) {
                count += 1; //가능한 던전 순서를 셈
            }
        }
        answer= Math.max(answer, count);
    }
}
