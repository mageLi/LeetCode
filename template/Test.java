import java.util.*;


public class Test {

    private static int count = 0;
    private static List<Integer> target = new ArrayList<>();

    public static void main(String[] args) {
        int[][] stu = new int[][]{{80, 96, 81, 77}, {78, 71, 93, 75},
                {71, 98, 70, 95},
                {80, 96, 89, 77}
        };
        int rank = 2;
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < stu.length; i++) {
            values.add(new ArrayList<>());
            for (int j = 0; j < stu[0].length; j++) {
                values.get(i).add(stu[i][j]);
            }
        }
        System.out.println(rankIndex(values, rank));
    }

    public static int rankIndex(List<List<Integer>> values, int rank) {
        if (values == null || values.size() == 0) return 0;
        int[] total = new int[values.size()];
        for (int i = 0; i < total.length; i++) {
            for (int j = 0; j < values.get(0).size(); j++) {
                total[i] += values.get(i).get(j);
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (b[1] == a[1]) return b[0] - a[0];
            return b[1] - a[1];
        });
        for (int i = 0; i < total.length; i++) {
            pq.offer(new int[]{i, total[i]});
        }
        while (pq.size() > rank) pq.poll();
        return pq.peek()[0];
    }

    // Simulation method, to generate or reset the random number, don't have to focus on it
    public static void reset() {
        target.clear();
        for (int i = 0; i < 4; ++i) {
            target.add((int) (Math.random() * 6) + 1);
        }
        count = 0;
    }

    // Simulation method, don't have to focus it
    public static String sendAndReceive(String str) {
        if (str.toLowerCase().equals("start")) {
            reset();
            return "Ready, target # is " + target.get(0) + target.get(1) + target.get(2) + target.get(3);
        }
        System.out.println("Times of method call: " + ++count + ", coming number: " + str);
        int a = 0;
        List<Integer> copyOfTarget = new ArrayList<>(target);
        List<Integer> t = new ArrayList<>();
        List<Integer> g = new ArrayList<>();

        for (int i = 0; i < 4; ++i) {
            int digit = copyOfTarget.get(i);
            char c = str.charAt(i);

            if (digit == c - '0') ++a;
            else {
                t.add(digit);
                g.add(c - '0');
            }
        }

        int size = g.size();
        g.removeAll(t);
        int b = size - g.size();

        return a + " " + b;
    }

    // Solutions
    public static String guess() {
        String base = "1111";
        int first = Integer.parseInt(sendAndReceive(base).split(" ")[0]);
        if (4 == first) return base;
        char[] res = new char[4];

        for (int i = 0; i < 4; ++i) {
            int lastResponse = first;
            char[] chBase = base.toCharArray();
            for (int j = 2; j < 6; ++j) {
                chBase[i] = (char) ('0' + j);
                int response = Integer.parseInt(sendAndReceive(String.valueOf(chBase)).split(" ")[0]);
                if (4 == response) return String.valueOf(chBase);
                if (response != lastResponse) {
                    res[i] = lastResponse > response ? '1' : (char) ('0' + j);
                    break;
                } else {
                    lastResponse = response;
                }
            }
            if (0 == res[i]) res[i] = '6';
        }

        return String.valueOf(res);
    }
}
