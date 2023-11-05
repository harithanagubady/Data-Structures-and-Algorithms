public class PrintZ {

    public static void main(String[] args) {
        int n = 5;
        StringBuilder star5 = new StringBuilder();
        int k1 = n;
        while (k1-- > 0) {
            star5.append("*");
        }
        for (int k =1 ; k <= n; k++) {
            int count = 0;
            if (k != 1 && k != n) {
                count = n - k;
                new PrintZ().printStar(count);
                System.out.println("*");
            } else {
                System.out.println(star5);
            }

        }
    }

    private void printStar(int count) {
        while (count-- > 0) {
            System.out.print(" ");
        }
    }
}