package DjikstraAlg;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;

public class Djikstra
{
    HashMap<String,Node> unvisitedNodeList = new HashMap<String,Node>();
    Network network;
    String currentNode;
    String startpoint;
    String endpoint;



    public Djikstra()
    {
        network = new Network();

        unvisitedNodeList = network.getNodeList();


        setStartAndEndpoint("A", "Z");
    }


    public void setStartAndEndpoint(String startpoint, String endpoint)
    {
        HashMap<String, String>  actNeighboursAndDistance = new HashMap<>();

        /* Store start and endpoint */
        this.startpoint = this.currentNode = startpoint;
        this.endpoint = endpoint;

        /* Returns all neighbours from the startpoint  */
        actNeighboursAndDistance = network.getNeighboursAndDistance(startpoint);

        /* Write the first tempDistance for all Neighbours from the startpoint*/
        for (int i = 0; i < actNeighboursAndDistance.size(); i++)
        {
            /* Read and store the distance from startpoint to the neigbours */
            /* The neighbour and distance is stored into the HashMap "actNeighboursAnddistance */
            unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i])
                    .setTempDist(Integer.parseInt(actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i])));

            /* set on the neigbours the predecessorNode (startpoint) */
            unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(startpoint);
        }

        /* Set on the startpoint the tempDistance to 0(zero) and visited as true */
        unvisitedNodeList.get(startpoint).setTempDist(0);
        unvisitedNodeList.get(startpoint).setVisited(true);

        /* choose the shortest or longest way */
        /* actually only the shortestDistance possible */
        calculateShortestDistance();
    }


    public void calculateShortestDistance()
    {
        HashMap<String, String>  actNeighboursAndDistance = new HashMap<>();
        int currentDistance = 0;

        while(network.checkUnvisitedNode() == true)
        {
            currentNode = network.getShortestDistance();
            System.out.println("Current Node: " + currentNode);

            /* Store the actual Distance */
            currentDistance = unvisitedNodeList.get(currentNode).getTempDist();

            /* Search the neighbours form the currentNode */
            actNeighboursAndDistance = network.getNeighboursAndDistance(currentNode);

            /* Write the new calculated tempDistance for all Neighbours from the currentNode*/
            for (int i = 0; i < actNeighboursAndDistance.size(); i++)
            {
                /* Until jet, no way to this node found */
                if(unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).getTempDist() == -1)
                {
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i])
                            .setTempDist(currentDistance + Integer.parseInt(actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i])));
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(currentNode);
                }
                /* Read and store the distance, including the tempDistance form the predecessor node */
                /* Whe the distance is lower as the the stored distance, write the new distance with the new predecessorNode. --> Shorter distance found! */
                else if(unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).getTempDist() >
                        (currentDistance + unvisitedNodeList.get(currentNode).getTempDist()))
                {
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i])
                            .addTempDist(Integer.parseInt(actNeighboursAndDistance.get(actNeighboursAndDistance.keySet().toArray()[i])));
                    unvisitedNodeList.get(actNeighboursAndDistance.keySet().toArray()[i]).setPredecessorNode(currentNode);
                }
            }

            /* Set on the startpoint the tempDistance to 0(zero) and visited as true */
            unvisitedNodeList.get(currentNode).setVisited(true);
        }
    }

    public void printShortestDistnace(Node starpoint, Node endpoint)
    {

    }

}