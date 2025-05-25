public class _30_LC2145_CountOfHiddenSequences {

    public static void main(String[] args) {
        int[] differences = {1, -3, 4};
        int lower = 1, upper = 6;

        System.out.println(hiddenSequences(differences, lower, upper));
    }

    private static int hiddenSequences(int[] differences, int lower, int upper) {

        long a = 0, max = 0, min = 0; //starting number is 0

        for (int d : differences) {
            a += d;
            max = Math.max(max, a);
            min = Math.min(min, a);
        }

        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }
}
