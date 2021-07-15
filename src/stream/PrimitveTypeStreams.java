package stream;

import java.util.stream.IntStream;

public class PrimitveTypeStreams
{
    public static void show(String title, IntStream stream)
    {
        final int SIZE = 10;
        int[] firstElements = stream.limit(SIZE + 1).toArray();
        System.out.println(title + ":");
        for (int i = 0; i < firstElements.length; i++)
        {
            if (i < SIZE)
            {
                System.out.print(firstElements[i]);
                System.out.print(",");
            } else
            {
                System.out.print(".....");
            }
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        IntStream is1 = IntStream.generate(() -> (int) (Math.random() * 100));
        show("is1", is1);
        IntStream is2 = IntStream.range(5, 10);
        System.out.println("is2的值为:" + is2);
        show("is2", is2);

    }
}
