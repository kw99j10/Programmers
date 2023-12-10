import java.util.ArrayList;
public class 우박수열정적분 {
    public double[] solution(int k, int[][] ranges) {

        var seq = new ArrayList<Integer>(); //우박수열을 담을 리스트

        seq.add(k);

        //1이되면 반복문 종료
        while (k > 1) {

            if (k % 2 != 0) {
                k = k * 3 + 1;
            } else {
                k = k / 2;
            }
            seq.add(k);
        }

        var size = new ArrayList<Double>(); //구역의 넓이를 담을 리스트
        size.add(0.0); //초기 넓이 0 셋팅

        double sum = 0.0; //넓이의 누적합

        for (int i = 1; i < seq.size(); i++) {
            int maxY = Math.max(seq.get(i), seq.get(i - 1));
            int minY = Math.min(seq.get(i), seq.get(i - 1));

            double triangle = ((double) maxY - minY) / 2;
            double square = minY;
            sum += (triangle + square);
            size.add(sum);
        }

        double[] answer = new double[ranges.length];

        for (int i = 0; i < ranges.length; i++) {

            //(a,-b)의 적분 -> (a,n-b)의 적분 영역을 적분
            int start = ranges[i][0]; //적분 시작 점
            int end = seq.size() - 1 + ranges[i][1]; //적분 종료점

            //적분 범위를 넘어서면 -1을 저장
            if (start > end) {
                answer[i] = -1.0;
            }

            //동일하면 0
            else if (start == end) {
                answer[i] = 0.0;
            }

            //해당 구역 넓이를 저장
            else {
                answer[i] = size.get(end) - size.get(start);
            }
        }

        return answer;
    }
}
