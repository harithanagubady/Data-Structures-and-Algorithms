public class _00_Understanding_Strings_and_StringBuilders {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Example 1: ");
        String s1 = "helloworld";
        String s2 = "helloworld";

        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("literals s1==s2 " + (s1 == s2));
        System.out.println("literals s1.equals(s2) " + s1.equals(s2));
        System.out.println();


        System.out.println("Example 2: ");
        String s3 = new String("Welcome");
        String s4 = new String("Welcome");

        System.out.println("s3 = " + s3 + ", s4 = " + s4);
        System.out.println("Objects s3==s4 " + (s3 == s4));
        System.out.println("Objects s3.equals(s4) " + s3.equals(s4));
        System.out.println();

        System.out.println("Example 3: ");
        s2 = s2 + "";
        System.out.println("literals s1==s2 " + (s1 == s2));
        System.out.println("literals s1.equals(s2) " + s1.equals(s2));

        s1 = s1 + "";
        System.out.println("literals s1==s2 " + (s1 == s2));
        System.out.println("literals s1.equals(s2) " + s1.equals(s2));
        System.out.println();

        System.out.println("Example 4: ");
        s1 = "Haritha";
        s2 = "Haritha" + "";
        System.out.println("literals s1==s2 " + (s1 == s2));
        System.out.println("literals s1.equals(s2) " + s1.equals(s2));

        s1 = s1 + "";
        System.out.println("literals s1==s2 " + (s1 == s2));
        System.out.println("literals s1.equals(s2) " + s1.equals(s2));
        System.out.println();

        try {
            System.out.println("Example 5: ");
            String s5 = "Hi, ";
            String s6 = null;
            s2 = s5 + s6;
            System.out.println(s2);
            s3 = s5.concat(s6); //throws NPE
        } catch (Exception e) {
            System.out.println("NPE");
        }
        System.out.println();

        System.out.println("Example 6: ");
        String s7 = "Haritha";
        String s8 = " Nagubady";
        String s9 = s7 + s8;
        String s10 = "Haritha" + " Nagubady";
        String s11 = "Haritha Nagubady";
        System.out.println(s9 == s11);
        System.out.println(s10 == s11);
        System.out.println();


        //Example 2
        System.out.println("Illustration of performance between String and StringBuilder concatenation");
        String str = "";
        int n = 10000;
        double start_time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            str += "h";
        }
        double end_time = System.currentTimeMillis();
        System.out.println("With + : " + (end_time - start_time) + "ms");
        Thread.sleep(1000);
        /*
            ##Immutability of Strings
            #String Creation:

            When you concatenate two strings (like using +=), Java does not simply append the new character to the existing string. Instead, it creates a new String object.
            #Copying Process:

            When you do str += "h", here's what happens internally:
            A new string object is created to hold the result of the concatenation.
            The existing string (str) must be copied into this new object. This involves iterating through all characters in the original string, which takes O(m) time, where m is the length of the original string.
            The new character (in this case, "h") is then appended to this new string.
            #Total Operations:

            The operation is not just about "adding" the new character; it requires copying the entire content of the original string to the new string, which is why we consider it O(m) for each iteration, not just constant time.
            ##Cumulative Effect
            In the loop:

            On the first iteration, str is empty (0 characters).
            On the second iteration, str has 1 character ("h"), so copying takes O(1).
            On the third iteration, str has 2 characters ("hh"), so copying takes O(2).
            ...
            On the n-th iteration, str has (n-1) characters, so copying takes O(n-1).
            The overall time complexity accumulates to:

            O(0) + O(1) + .... + O(n - 1) = O(n (n-1)/2) = O(n^2)
         */


        String str1 = "";
        start_time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            str1.concat("h");
        }
        end_time = System.currentTimeMillis();
        System.out.println("With concat: " + (end_time - start_time) + "ms");
        Thread.sleep(1000);

        StringBuilder stringBuilder = new StringBuilder();
        start_time = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            stringBuilder.append("h");
        }
        end_time = System.currentTimeMillis();
        System.out.println("With StringBuilder: " + (end_time - start_time) + "ms");


        //Understanding String Builder operations

    }
}
