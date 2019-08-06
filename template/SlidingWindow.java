import java.util.*;
public class SlidingWindow {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int len = s1.length();
        int counter = map.size();
        int begin = 0, end = 0;
        while (end < s2.length()) {
            char c = s2.charAt(end++);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) counter--;
            }
            while (counter == 0 && begin < s2.length()) {
                if (end - begin == len) {
                    return true;
                }
                char temp = s2.charAt(begin++);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                    if (map.get(temp) == 1) counter++;
                }
            }
        }
        return false;
    }
}
