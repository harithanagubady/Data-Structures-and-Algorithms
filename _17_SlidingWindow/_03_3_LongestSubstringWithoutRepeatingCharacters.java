import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class _03_3_LongestSubstringWithoutRepeatingCharacters {

        //Shrinkable
        public int lengthOfLongestSubstring(String s) {

            int i = 0, j = 0, N = s.length(), ans = 0;
            int[] count = new int[128];
            int dup = 0;
            while (j < N) {
                if (++count[s.charAt(j++)] == 2) {
                    dup++;
                }
                while (dup > 0) {
                    if (--count[s.charAt(i)] == 1) {
                        dup--;
                    }
                    i++;
                }
                ans = Math.max(ans, j - i);
            }
            return ans;
        }

    //Non-shrinkable
    public int lengthOfLongestSubstring1(String s) {

        int i = 0, j = 0, N = s.length(), ans = 0;
        int[] count = new int[128];
        int dup = 0;
        while (j < N) {
            if (++count[s.charAt(j++)] == 2) {
                dup++;
            }
            if (dup > 0) {
                if (--count[s.charAt(i++)] == 1) {
                    dup--;
                }
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);
        dq.add(2);
        dq.add(3);
        dq.remove(2);
        for (int k : dq) {
            System.out.println(k);
        }
    }
}
