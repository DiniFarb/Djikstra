package DjikstraAlg;

import java.util.ArrayList;

public class Network
{
//    ArrayList<Character><String> mainList = new List<Character><String>();

    public Network(String name)
    {

    }

    private void createNode(Node node)
    {

    }

    public ArrayList<Node> getNeighboursAndDistance(Node node)
    {
        ArrayList<Node> neighbourList = new ArrayList<>();

        neighbourList.add(node);
        /* Muss noch geaendert werden */
        return neighbourList;
    }


    public Node getShortestNode(Node startpoint)
    {

        return startpoint;
    }


    public int getDistance(Node startpoint, Node endpoint)
    {

        return 0;
    }

}
