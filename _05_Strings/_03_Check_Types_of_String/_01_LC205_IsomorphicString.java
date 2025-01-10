package _03_Check_Types_of_String;

/*
https://leetcode.com/problems/isomorphic-strings/description/
 */
public class _01_LC205_IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("abb", "tab"));
    }

    public static boolean isIsomorphic(String s, String t) {
        //check for one-directional map
        //if an character (say sch) maps from s to t (say tch)
        //then that tch should be mapped to only sch
        //so we will have sch array and tch array to keep track

        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] schMap = new int[256];
        int[] tchMap = new int[256];

        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();

        for (int i = 0; i < n; i++) {
            if (schMap[sch[i]] != tchMap[tch[i]]) return false;
            schMap[sch[i]] = i + 1;
            tchMap[tch[i]] = i + 1;
        }

        return true;
    }
}
