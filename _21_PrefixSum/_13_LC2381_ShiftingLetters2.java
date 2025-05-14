public class _13_LC2381_ShiftingLetters2 {

    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = {{0, 1, 0}, {1, 2, 1}, {0, 2, 1}};
        System.out.println(shiftingLetters(s, shifts));
    }

    public static String shiftingLetters(String s, int[][] shifts) {

        int n = s.length();

        int[] shift = new int[n];
        for (int[] shift_ : shifts) {
            int start = shift_[0], end = shift_[1], direction = shift_[2];
            shift[start] += (direction == 1) ? 1 : -1;
            if (end + 1 < n) shift[end + 1] -= (direction == 1) ? 1 : -1;
        }

        int currSum = 0;
        for (int i = 0; i < n; i++) {
            currSum += shift[i];
            shift[i] = currSum;
        }

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            int netShift = (shift[i] % 26 + 26) % 26;
            sb.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return sb.toString();
    }
}
