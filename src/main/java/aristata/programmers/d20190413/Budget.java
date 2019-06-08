package aristata.programmers.d20190413;

import java.util.Arrays;

public class Budget {
    private int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);

        int sum = 0;
        for (int i = 0; i < d.length && sum < budget; i++) {
            if ( (sum + d[i]) <= budget ) {
                sum += d[i];
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Budget budget = new Budget();
        int[] test1 = new int[] {1,3,2,5,4};
        int result = budget.solution(test1, 9);
        System.out.println("result1 = " + result);

        int[] test2 = new int[] {2,2,3,3};
        int result2 = budget.solution(test2, 10);
        System.out.println("result2 = " + result2);
    }
}


