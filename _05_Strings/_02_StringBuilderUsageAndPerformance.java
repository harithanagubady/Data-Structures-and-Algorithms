public class _02_StringBuilderUsageAndPerformance {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello");
        System.out.println("String : " + sb);
        // 1.
        System.out.println("Length of string : " + sb.length());
        // 2.
        System.out.println("First character : " + sb.charAt(0));
        // 3.
        sb.setCharAt(0, 'h');
        System.out.println("String : " + sb);
        // 4.
        sb.append("reader");
        System.out.println("String : " + sb);
        // 5.
        sb.insert(5, "  ");
        System.out.println("String : " + sb);
        //6.
        sb.deleteCharAt(5);
        System.out.println("String : " + sb);
        // 6.
        sb.delete(0, 5);
        System.out.println("String : " + sb);
        // 7.
        sb.replace(5, 7, "ing");
        System.out.println("String : " + sb);
        // 8.
        String str = sb.toString();
        System.out.println("String : " + str);
    }
}