public class Understanding_Strings_and_StringBuilders {

    public static void main(String[] args) throws InterruptedException {

        //Example 1
//        String s = "helloworld";
//        String s1 = "helloworld";

        String s = new String("helloworld");
        String s1 = new String("helloworld");

        if (s == s1) {
            System.out.println("1==: equal");
        }
        if (s.equals(s1)) {
            System.out.println("1 equals: equal");
        }
        s1 = s1 + "";

        if (s == s1) {
            System.out.println("2==: equal");
        }

        if (s.equals(s1)) {
            System.out.println("2 equals: equal");
        }
        s1 = s1 + "";

        if (s == s1) {
            System.out.println("2==: equal");
        }

        //Example 2
        String str = "";
        int n = 10000;
        double start_time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            str += i;
        }
        double end_time = System.currentTimeMillis();
        System.out.println(end_time - start_time + "ms");
        Thread.sleep(5000);

        StringBuilder stringBuilder = new StringBuilder();
        start_time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(i);
        }
        end_time = System.currentTimeMillis();
        System.out.println(end_time - start_time + "ms");
    }
}
