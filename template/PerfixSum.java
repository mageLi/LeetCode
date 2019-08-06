import java.util.HashMap;
import java.util.Map;

public class PerfixSum {
        public int findMaxLength(int[] nums) {
            int prefixSum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);
            int max = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) nums[i] = -1;
            }
            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                if (map.containsKey(prefixSum)) {
                    max = Math.max(max, i - map.get(prefixSum));
                } else {
                    map.put(prefixSum, i);
                }
            }
            return max;
        }
}
