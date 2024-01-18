class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int count = 1;
        int[][] arr = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                arr[i][j] = count++;
            }
        }
        for (int i = 0; i < queries.length; i++) {

            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            int min = 10001;
            int tmp = arr[x1][y1];

            //우
            for (int j = y1; j <= y2; j++) {
                int t = arr[x1][j];
                arr[x1][j] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            //하
            for (int j = x1 + 1; j <= x2; j++) {
                int t=arr[j][y2];
                arr[j][y2] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            //좌
            for (int j = y2 - 1; j >= y1; j--) {
                int t=arr[x2][j];
                arr[x2][j] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            //상
            for (int j = x2 - 1; j >= x1; j--) {
                int t=arr[j][y1];
                arr[j][y1] = tmp;
                tmp = t;
                min = Math.min(min, tmp);
            }

            min = Math.min(min, tmp);
            answer[i] = min;
        }
        return answer;
    }
}
