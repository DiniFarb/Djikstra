package DjikstraAlg;

import java.util.Random;

/**
 * Testprozeduren
 */
public class Testprozeduren
{

    /**
     * todo: When testing is finished, remove this Methode!
     *
     * This is a testprozedure to test the Djikstra code!
     * When testing is finished, this methode must be removed!
     *
     * Important --> Node from A - Z must be stored into the nodeMap!
     *           --> Mehtode is not observed for Exceptions!
     *
     * Methode calculate a few of routes like:
     * A to Y
     * B to Z
     * C to X
     * ......
     * X to C
     * Z to B
     * Y to A
     *
     */
    public static void testProzedure1()
    {
        Djikstra newRoute = new Djikstra();

        System.out.println("Es wird ein Testlauf gestartet, welcher alle Nodes von A bis Z und von Z bis A abfaegt.");
        for (int i = 0; i < 26; i++)
        {
            newRoute.getDirection(Character.toString((char)((int)'A' + i)), Character.toString((char)((int)'Z' - i)));
            System.out.println("-- Ende Testlauf Nr: " + (i+1) + " --\n");
        }
    }

    /**
     * todo: When testing is finished, remove this Methode!
     *
     * This is a testprozedure to test the Djikstra code!
     * When testing is finished, this methode must be removed!
     *
     * Important --> Node from A - Z must be stored into the nodeMap!
     *           --> Mehtode is not observed for Exceptions!
     *
     * Calculate a few of routs with random start- and endpoint
     *
     */
    public static void testProzedure2()
    {
        double rndValue = 0;
        Djikstra newRoute = new Djikstra();

        int start = 0;
        int end = 0;

        System.out.println("Es wird ein Testlauf gestartet, welcher den Startnode und Endnode zufaellig definiert.");
        for (int i = 0; i < 50; i++)
        {
            rndValue = Math.random()*26;
            start = ((int)'A' + (int)rndValue);
            rndValue = Math.random()*26;
            end = ((int)'A' + (int)rndValue);

            newRoute.getDirection(Character.toString((char)start), Character.toString((char)end));
            System.out.println("-- Ende Testlauf Nr: " + (i+1) + " --\n");
        }
    }


    /**
     * todo: When testing is finished, remove this Methode!
     *
     * This is a testprozedure to test the Djikstra code!
     * When testing is finished, this methode must be removed!
     *
     * Important --> Node from A - Z must be stored into the nodeMap!
     *           --> Mehtode is not observed for Exceptions!
     *
     * Calculate a few of routs with random startpoint, endpoint and viapoint
     *
     */
    public static void testProzedure3()
    {
        double rndValue = 0;
        Djikstra newRoute = new Djikstra();

        int start = 0;
        int end = 0;
        int via = 0;

        System.out.println("Es wird ein Testlauf gestartet, welcher den Startnode, Endnode und Vianode zufaellig definiert.");
        for (int i = 0; i < 50; i++)
        {
            rndValue = Math.random()*26;
            start = ((int)'A' + (int)rndValue);
            rndValue = Math.random()*26;
            end = ((int)'A' + (int)rndValue);
            rndValue = Math.random()*26;
            via = ((int)'A' + (int)rndValue);

            newRoute.getDirection(Character.toString((char)start), Character.toString((char)via),Character.toString((char)end));
            System.out.println("-- Ende Testlauf Nr: " + (i+1) + " --\n");
        }
    }
}
