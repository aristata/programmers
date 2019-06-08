package aristata.programmers.d20190316;

import java.util.Arrays;
import java.util.HashMap;

public class Camouflage {

    private int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();
        Arrays.stream(clothes).forEach(it ->
                map.put(it[1], map.getOrDefault(it[1], 0) + 1)
        );

        // key - 개수
        // 공식 => 1 * (개수 + 1) [* (개수 + 1)...n] -1
        for (int a : map.values()) {
            answer = answer * (a + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {

        String[][] testCase1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        String[][] testCase2 = {
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        };

        Camouflage camouflage = new Camouflage();
        int result = camouflage.solution(testCase1);
        System.out.println("결과: " + result);

        int result2 = camouflage.solution(testCase2);
        System.out.println("결과2: " + result2);
    }


}