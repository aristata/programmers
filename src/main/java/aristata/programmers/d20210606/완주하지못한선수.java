package aristata.programmers.d20210606;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class 완주하지못한선수 {

    public static void main(String[] args) {
        Solution sol = new Solution();

        // TestCase1
        String[] parti1 = {"leo", "kiki", "eden"};
        String[] compl1 = {"eden", "kiki"};
        String answer1 = "leo";
        String result1 = sol.solution(parti1, compl1);
        boolean isPass1 = answer1.equals(result1);
        String message1 = "TestCase1 >>> answer1 = '" + answer1 + "', result1 = '" + result1 + "' >>> " + isPass1 + "!!!";
        System.out.println(message1);

        // TestCase2
        String[] parti2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] compl2 = {"josipa", "filipa", "marina", "nikola"};
        String answer2 = "vinko";
        String result2 = sol.solution(parti2, compl2);
        boolean isPass2 = answer2.equals(result2);
        String message2 = "TestCase2 >>> answer2 = '" + answer2 + "', result2 = '" + result2 + "' >>> " + isPass2 + "!!!";
        System.out.println(message2);

        // TestCase3
        String[] parti3 = {"mislav", "stanko", "mislav", "ana"};
        String[] compl3 = {"stanko", "ana", "mislav"};
        String answer3 = "mislav";
        String result3 = sol.solution(parti3, compl3);
        boolean isPass = answer3.equals(result3);
        String message3 = "TestCase3 >>> answer3 = '" + answer3 + "', result3 = '" + result3 + "' >>> " + isPass + "!!!";
        System.out.println(message3);
    }


    static class Solution {
        public String solution(String[] participant, String[] completion) {
            // AtomicReference 클래스는 멀티쓰레드 환경에서 동시성을 보장합니다.
            AtomicReference<String> answer = new AtomicReference<>("");

            // HashMap 생성
            HashMap<String, Integer> map = new HashMap<>();

            // 참가자를 map 에 추가한다. 이때 동명이인일 경우 값을 + 1 한다.
            Arrays.stream(participant)
                    .forEach(it ->
                        map.put(
                                it,
                                map.getOrDefault(it, 0) + 1 // 기존의 map 에서 key 로 value 를 찾아 1을 더한 값을 새 value 로 저장한다.
                        )
                    );

            // 완주자를 map 에서 찾아 값을 -1 한다.
            Arrays.stream(completion)
                    .forEach(it ->
                            map.put(
                                    it,
                                    map.get(it) - 1
                            )
                    );

            // 완주하지 못한 자를 map 에서 찾아 반환한다.
            map.forEach((key, value) -> {
                if (value > 0) {
                    answer.set(key);
                }
            });

            return answer.get();
        }
    }
}


