#풀이 1
import java.util.*;
class Solution {
    public int solution(int[] elements) {
        var h = new HashSet<Integer>();
        for (int i = 1; i <= elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {

                int sum = 0;
                for (int k = j; k < i + j; k++) {

                    sum += elements[k % elements.length];
                }
                h.add(sum);
            }
        }
        return h.size();
    }
}

#풀이 2(시간, 메모리 절약)
import java.util.*;
class Solution {
    public int solution(int[] elements) {
         var h = new HashSet<Integer>();
        for (int i = 1; i <= elements.length; i++) {

            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += elements[j];
            }
            h.add(sum);

            for (int j = 0; j < elements.length; j++) {
                sum -= elements[j % elements.length];
                sum += elements[(j + i) % elements.length];
                h.add(sum);
            }
        }
        return h.size();
    }
}
