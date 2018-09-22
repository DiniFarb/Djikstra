package DjikstraAlg;

public class Main
{
    public static void main(String[] args)
    {
        long startTime = System.nanoTime();
        Djikstra newRoute = new Djikstra();

/*
        System.out.println("Example from a point-to-point way.");
        newRoute.getDirection("B", "Q");
        System.out.println("\n");

        System.out.println("Example from a point-to-point way with an integrated via point.");
        newRoute.getDirection("A", "Y", "B");
*/


        /* testProzeduren */
        /* testProzedure1() oder testProzedure2() oder testProzedure3() */
        Testprozeduren.testProzedure3();




        long runtime = System.nanoTime() - startTime;
        System.out.println(runtime/1000000+"ms");
    }
}
