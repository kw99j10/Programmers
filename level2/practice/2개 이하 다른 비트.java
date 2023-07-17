class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

         for (int i = 0; i < numbers.length; i++) {
            long tmp = numbers[i];

            if (tmp % 2 == 0) {
                answer[i] = tmp + 1; //정수가 짝수일 시 비트 한칸의 변화만 필요 ==> +1
            }
            else{
                String k = Long.toBinaryString(tmp);
                if (k.length() == 1) {
                    answer[i] = tmp + 1; //1일 경우: +1
                }
                else{
                    String ans = k.substring(k.length() - 2);
                    if (ans.equals("01")) {
                        answer[i] = tmp + 1; //끝자리가 01로 끝날 경우: 01->10 ==> +1
                    }
                    else{
                        long count = 0; //중간에 나온 0(혹은 0이 없는 경우) 뒤에 있는 1의 개수를 나타내는 변수
                        for (int j = k.length() - 1; j >= 0; j--) {
                            char c = k.charAt(j);
                            if (c == '0') {
                                break;
                            }
                            count += 1;
                        }
                        answer[i] = tmp + (long) Math.pow(2, (count - 1)); //기존 값 + 2의 (count-1)만큼의 제곱
                    }
                }
            }
        }
        return answer;
    }
}
