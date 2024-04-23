import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class BucketsAndBalls {

    public static void main(String[] args) throws IOException {

        List<String> buckets = List.of("..B....B.BB", "BB.B.BBB...", ".BBB.B", "......B.B", ".BBB.", "B", ".",
                "BB.", "BBBBB");
        for (String bucket : buckets) {
            System.out.println("\"" + bucket + "\" " + new BucketsAndBalls().minMoves(bucket));
        }
    }

    public int minMoves(String buckets) {
        int n = buckets.length();
        int ballOdd = 0;
        int ballEven = 0;
        int bucketOdd = 0;
        int bucketEven = 0;
        char[] bucketArray = buckets.toCharArray();
        for (int i = 0; i < n; i++) {
            if (bucketArray[i] == 'B') {
                if (i % 2 == 0) {
                    ballEven++;
                } else {
                    ballOdd++;
                }
            } else {
                if (i % 2 == 0) {
                    bucketEven++;
                } else {
                    bucketOdd++;
                }
            }
        }
        int minMoves = -1;
        if (ballOdd <= bucketEven && ballEven <= bucketOdd)
            minMoves = Math.min(ballOdd, ballEven);
        else if (ballEven <= bucketOdd)
            minMoves = ballEven;
        else if (ballOdd <= bucketEven)
            minMoves = ballOdd;
        return minMoves;
    }
}
