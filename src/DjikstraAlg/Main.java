package DjikstraAlg;

public class Main
{
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        Djikstra newRoute = new Djikstra();

        newRoute.getDirection("A", "O");
        System.out.println("\n");

//        newRoute.getDirection("A", "X", "W");

        long runtime = System.nanoTime() - startTime;
        System.out.println(runtime/1000000+"ms");
    }
}
