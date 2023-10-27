class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];

        //선 대칭 경우의 수
        //{startX, -startY},{m + (m - startX), startY},{-startX, startY},{startX, n + (n - startY)}

        for (int i = 0; i < balls.length; i++) {

            int min = Integer.MAX_VALUE;

            int a = balls[i][0]; //공의 x 좌표
            int b = balls[i][1]; //공의 y 좌표

            //시작 좌표에서 주어진 공의 좌표까지의 거리를 아래 4가지 경우의 수를 이용하여 구함 
            double distance_x = Math.abs(startX - a);
            double distance_y = Math.abs(startY - b);

            int top = (int) (Math.pow(startX - a, 2)) + (int)(Math.pow(startY - (n + (n - b)), 2));
            int bottom= (int) (Math.pow(startX - a, 2)) + (int)(Math.pow(startY + b, 2));
            int left=(int) (Math.pow(startX - (-a), 2)) + (int)(Math.pow(startY - b, 2));
            int right=(int) (Math.pow(startX - (m + (m - a)), 2)) +(int) (Math.pow(startY - b, 2));

            //x 좌표 간의 거리가 0일 때 → 두 좌표의 y 값이 같음
            if (distance_x == 0) {
                if (b>startY){
                    min=Math.min(bottom,Math.min(left,right)); //주어진 공의 y좌표가 시작 y좌표보다 크다면 위로 향하는 선대칭을 구할 수 없음
                }
                else if (b<startY){
                    min=Math.min(top,Math.min(left,right)); //주어진 공의 y좌표가 시작 y좌표보다 작다면 아래로 향하는 선대칭을 구할 수 없음
                }
            }
            //y 좌표 간의 거리가 0일 때 → 두 좌표의 x 값이 같음
            if (distance_y == 0){
                if (a>startX){
                    min=Math.min(top,Math.min(bottom,left)); //주어진 공의 x좌표가 시작 x좌표보다 크다면 오른쪽의 선대칭을 구할 수 없음
                }
                else if (a<startX){
                    min=Math.min(top,Math.min(bottom,right)); //주어진 공의 x좌표가 시작 x좌표보다 작다면 왼쪽 선대칭을 구할 수 없음 
                }
            }
            else{
                min=Math.min(top,Math.min(bottom,Math.min(left,right))); //해당하지 않다면 4가지 경우를 모두 비교하여 최소값 구함
            }
            answer[i] = min;
        }
        return answer;
    }
}
