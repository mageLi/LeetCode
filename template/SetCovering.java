import java.util.*;
/*
*
* Example 1:

Input: req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
Output: [0,2]
*
* */
public class SetCovering {
        List<Integer> sol;
        int[] dp;
        public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
            int N = req_skills.length;
            dp = new int[people.size()];
            Map<String, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < N; i++) {
                indexMap.put(req_skills[i], i);
            }
            for (int i = 0; i < people.size(); i++) {
                for (String skill : people.get(i)) {
                    dp[i] |= 1 << indexMap.get(skill);
                }
            }
            sol = new ArrayList<>();
            search(0, dp, new ArrayList<>(), N);
            int[] result = new int[sol.size()];
            for (int i = 0; i < sol.size(); i++)
                result[i] = sol.get(i);
            return result;
        }
        public void search(int cur, int[] pe, List<Integer> onesol, int n) {
            if (cur == (1<<n) - 1) {  // when all bits are 1, all skills are coverred
                if (sol.size() == 0 || onesol.size() < sol.size()) {
                    sol = new ArrayList<>(onesol);
                }
                return;
            }
            if (sol.size() != 0 && onesol.size() >= sol.size()) return;    //pruning
            int zeroBit = 0;
            while (((cur>>zeroBit)&1) == 1) zeroBit++;
            for (int i = 0; i < pe.length; i++) {
                int per = pe[i];
                if (((per>>zeroBit)&1) == 1) {
                    onesol.add(i); // when a person can cover a zero bit in the current number, we can add him
                    search(cur|per, pe, onesol, n);
                    onesol.remove(onesol.size() - 1);  //search in a backtracking way
                }
            }
        }
}
