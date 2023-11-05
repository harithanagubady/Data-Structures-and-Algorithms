import java.util.*;


public class Main {

    public static void main(String[] args)

    {

        Scanner scn = new Scanner(System.in);

        int i = Integer.parseInt(scn.nextLine());//To avoid line14 to read next line variable

        String name = scn.nextLine();

        System.out.println("Hello " + name);

        System.out.println("Here is the counting:");

        for (int j = 0; j <= i; j++)

        {

            System.out.println(j);

        }

    }

}